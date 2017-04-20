package org.github.sustbird.statemachine.contract;

import org.github.sustbird.statemachine.model.ConstraintActionPair;

import java.util.Map;

/**
 * The interface which should be implemented by the application business state enum.
 * @author shafiul.gp@gmail.com
 */
public interface State<T> {

    /**
     * main method to define the states from which this state can be reached and
     * pair of constraints and actions for this transition.
     * @return map of state and pair of constraints and actions
     */
    Map<State, ConstraintActionPair<T>> getTransitions();
}
