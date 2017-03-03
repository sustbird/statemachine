package org.github.sustbird.statemachine;

/**
 * Represents the constraint violations.
 * @author shafiul.gp@gmail.com
 */
public class ConstraintViolationException {

    /**
     * Error code.
     */
    private final String code;

    /**
     * Error message
     */
    private final String message;

    /**
     * Constructor
     * @param code error code
     * @param message error message
     */
    public ConstraintViolationException(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Getter for code.
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter for message
     * @return
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConstraintViolationException{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
