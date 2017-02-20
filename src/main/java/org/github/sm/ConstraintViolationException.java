package org.github.sm;

/**
 * Represents the constraint violations.
 * @author shafiul.gp@gmail.com
 */
public class ConstraintViolationException {

    private final String code;
    private final String message;

    public ConstraintViolationException(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

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
