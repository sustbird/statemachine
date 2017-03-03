package org.github.sustbird.statemachine;

import java.util.List;

/**
 * Global state transition exceptions.
 * @author shafiul.gp@gmail.com
 */
public class StateTransitionException extends RuntimeException {

    /**
     * holder list of constraint violation exception
     */
    private final List<ConstraintViolationException> constraintViolationExceptions;

    /**
     * Constructor
     * @param constraintViolationExceptions list of exceptions
     */
    public StateTransitionException(
            final List<ConstraintViolationException> constraintViolationExceptions) {
        this.constraintViolationExceptions = constraintViolationExceptions;
    }

    /**
     * Constructor
     * @param message error message
     * @param constraintViolationExceptions list of exceptions
     */
    public StateTransitionException(final String message,
                                    final List<ConstraintViolationException> constraintViolationExceptions) {
        super(message);
        this.constraintViolationExceptions = constraintViolationExceptions;
    }

    /**
     * Getter of violation exceptions.
     * @return list of exceptions
     */
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
