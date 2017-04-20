package org.github.sustbird.statemachine.contract;

import org.github.sustbird.statemachine.exception.ActionFailedException;

/**
 * Contract for actions after all constraints are satisfied for a transition.
 * @author shafiul.gp@gmail.com
 */
public interface StateAction<T> {

    /**
     * default order of action.
     */
    int DEFAULT_ORDER = 100;

    /**
     * Execute the defined action, which will be called by state machine.
     * @param oldValue old domain object
     * @param newValue new domain object
     * @param fromState old state
     * @param toState new state
     * @return updated domain object of the action execution
     * @throws ActionFailedException action execution failure exception
     */
    T execute(T oldValue, T newValue, State<T> fromState, State<T> toState) throws ActionFailedException;

    /**
     * Determines if this action will halt the transition.
     * If false, other actions will continue to execute.
     * @return
     */
    default boolean isBlocking() {
        return true;
    }

    /**
     * Low means higher priority.
     * @return
     */
    default int getOrder() {
        return DEFAULT_ORDER;
    }

    String toString();
}
