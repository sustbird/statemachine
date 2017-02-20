package org.github.sm;

import java.util.Map;

/**
 * The interface which should be implemented by the application business state enum.
 * @author shafiul.gp@gmail.com
 */
public interface State<T> {
    Map<State, ConstraintActionPair<T>> getTransitions();
}
