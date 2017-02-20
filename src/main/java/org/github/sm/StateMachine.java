package org.github.sm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The state machine core engine.
 * For a state transition, it validates all constraints and if satisfied executes defines actions.
 * @author shafiul.gp@gmail.com
 */
public class StateMachine<T> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public T doTransition(T oldValue, T newValue, State<T> fromState, State<T> toState) {
        List<ConstraintViolationException> constraintViolationExceptions = new ArrayList<>();

        Map<State, ConstraintActionPair<T>> transitionMap = toState.getTransitions();

        //no map defined!
        if (transitionMap == null) {
            return newValue;
        }

        //check if valid transition from previous state
        if (!transitionMap.containsKey(fromState)) {
            throw new ActionFailedException("No transition defined from state: " + fromState + " to state: " + toState);
        }

        ConstraintActionPair<T> constraintActionPair = transitionMap.get(fromState);
        //there is a transition but without any constraint and action! (it shouldn't be)
        if (constraintActionPair == null) {
            return newValue;
        }

        //validate the constraints
        List<StateConstraint<T>> constraints = constraintActionPair.getConstraints();
        if (constraints != null) {
            for (StateConstraint<T> constraint : constraints) {
                if (!constraint.validate(oldValue, newValue, fromState, toState)) {
                    constraintViolationExceptions
                            .add(constraint.getViolationException(oldValue, newValue, fromState, toState));
                }
            }
        }

        //constraint violations
        if (constraintViolationExceptions.size() != 0) {
            log.debug("State transition failed. Violations: {}", constraintViolationExceptions);
            throw new StateTransitionException("State transition failed.", constraintViolationExceptions);
        }

        //validation successful
        T response = oldValue;
        Set<StateAction<T>> actions = constraintActionPair.getActions();

        //sort the actions according to order(low means higher priority)
        SortedSet<StateAction<T>> sortedActions = new TreeSet<>((o1, o2) -> {
            if (o1.getOrder() > o2.getOrder()) {
                return 1;
            }
            return -1;
        });

        sortedActions.addAll(actions);

        //execute the actions
        if (actions != null) {
            for (StateAction<T> stateAction : sortedActions) {
                try {
                    log.debug("Action executing: {}", stateAction.getClass().getSimpleName());
                    response = stateAction.execute(oldValue, newValue, fromState, toState);
                    log.debug("Action executed: {}", stateAction.getClass().getSimpleName());

                } catch (ActionFailedException e) {
                    log.debug("State transition Action: {} failed from: {} to {}. Error: {}", stateAction, fromState,
                              toState, e.getMessage());
                    if (stateAction.isBlocking()) {
                        throw e;
                    }
                }
            }
        }

        return response;
    }
}
