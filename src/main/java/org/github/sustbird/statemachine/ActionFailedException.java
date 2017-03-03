package org.github.sustbird.statemachine;

/**
 * Exception for action failure.
 * @author shafiul.gp@gmail.com
 */
public class ActionFailedException extends RuntimeException {

    /**
     * No-arg Constructor
     */
    public ActionFailedException() {
    }

    /**
     * Constructor with a message
     * @param message error message
     */
    public ActionFailedException(final String message) {
        super(message);
    }
}
