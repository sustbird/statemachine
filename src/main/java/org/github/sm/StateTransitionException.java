package org.github.sm;

import java.util.List;

/**
 * Global state transition exceptions.
 * @author shafiul.gp@gmail.com
 */
public class StateTransitionException extends RuntimeException {

    private final List<ConstraintViolationException> constraintViolationExceptions;

    public StateTransitionException(
            final List<ConstraintViolationException> constraintViolationExceptions) {
        this.constraintViolationExceptions = constraintViolationExceptions;
    }

    public StateTransitionException(final String message,
                                    final List<ConstraintViolationException> constraintViolationExceptions) {
        super(message);
        this.constraintViolationExceptions = constraintViolationExceptions;
    }

    public List<ConstraintViolationException> getConstraintViolationExceptions() {
        return constraintViolationExceptions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StateTransitionException{");
        sb.append("constraintViolationExceptions=").append(constraintViolationExceptions);
        sb.append('}');
        return sb.toString();
    }
}
