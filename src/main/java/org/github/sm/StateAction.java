package org.github.sm;

/**
 * Contract for actions after all constraints are satisfied for a transition.
 * @author shafiul.gp@gmail.com
 */
public interface StateAction<T> {

    int DEFAULT_ORDER = 100;

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
