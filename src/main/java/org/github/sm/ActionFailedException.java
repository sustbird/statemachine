package org.github.sm;

/**
 * Exception for action failure.
 * @author shafiul.gp@gmail.com
 */
public class ActionFailedException extends RuntimeException {

    public ActionFailedException() {
    }

    public ActionFailedException(final String message) {
        super(message);
    }
}
