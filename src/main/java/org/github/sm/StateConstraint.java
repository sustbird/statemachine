package org.github.sm;

/**
 * Contract for constraint.
 * @author shafiul.gp@gmail.com
 */
public interface StateConstraint<T> {
    boolean validate(T oldValue, T newValue, State fromState, State toState);

    ConstraintViolationException getViolationException(T oldValue, T newValue, State fromState, State toState);
}
