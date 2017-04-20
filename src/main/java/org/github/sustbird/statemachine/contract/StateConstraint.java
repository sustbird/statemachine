package org.github.sustbird.statemachine.contract;

import org.github.sustbird.statemachine.exception.ConstraintViolationException;

/**
 * Contract for constraint.
 * @author shafiul.gp@gmail.com
 */
public interface StateConstraint<T> {

    /**
     * Validate the constraint. If satisfied return true, else return false.
     * @param oldValue old domain object
     * @param newValue new domain object
     * @param fromState old state
     * @param toState new state
     * @return true/false
     */
    boolean validate(T oldValue, T newValue, State fromState, State toState);

    /**
     * Get the violation exception with message when this constraint returns false.
     * @param oldValue old domain object
     * @param newValue new domain object
     * @param fromState old state
     * @param toState new state
     * @return constraint violation exception
     */
    ConstraintViolationException getViolationException(T oldValue, T newValue, State fromState, State toState);
}
