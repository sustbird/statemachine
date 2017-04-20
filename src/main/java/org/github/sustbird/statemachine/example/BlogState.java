package org.github.sustbird.statemachine.example;

import org.github.sustbird.statemachine.model.ConstraintActionPair;
import org.github.sustbird.statemachine.contract.State;
import org.github.sustbird.statemachine.contract.StateAction;
import org.github.sustbird.statemachine.contract.StateConstraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shafiul.gp@gmail.com
 */
public enum BlogState implements State<Blog> {

    DRAFT {
        @Override
        public Map<State, ConstraintActionPair<Blog>> getTransitions() {
            return null;
        }
    },
    PUBLISHED {
        @Override
        public Map<State, ConstraintActionPair<Blog>> getTransitions() {
            Set<StateAction<Blog>> stateActions = new HashSet<>();
            stateActions.add(new PublishAction());

            List<StateConstraint<Blog>> stateConstraints = new ArrayList<>();
            stateConstraints.add(new RoleConstraint());

            ConstraintActionPair<Blog> constraintActionPair =
                    new ConstraintActionPair<>(stateConstraints, stateActions);

            Map<State, ConstraintActionPair<Blog>> constraintActionPairMap = new HashMap<>();
            //here the key is the state from which this state can be reached and
            //the value is a pair of constraints and actions for that state
            constraintActionPairMap.put(BlogState.DRAFT, constraintActionPair);

            return constraintActionPairMap;
        }
    }
}
