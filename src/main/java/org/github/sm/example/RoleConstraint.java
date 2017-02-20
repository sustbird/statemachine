package org.github.sm.example;

import org.github.sm.ConstraintViolationException;
import org.github.sm.State;
import org.github.sm.StateConstraint;

/**
 * @author shafiul.gp@gmail.com
 */
public class RoleConstraint implements StateConstraint<Blog> {

    @Override
    public boolean validate(final Blog oldValue, final Blog newValue, final State fromState, final State toState) {
        //validate business logic, return true/false
        return false;
    }

    @Override
    public ConstraintViolationException getViolationException(final Blog oldValue, final Blog newValue,
                                                              final State fromState,
                                                              final State toState) {
        //return actual violation with possible code & message, you can extend ConstraintViolationException for customization.
        return null;
    }
}
