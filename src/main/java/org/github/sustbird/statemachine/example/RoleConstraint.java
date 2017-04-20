package org.github.sustbird.statemachine.example;

import org.github.sustbird.statemachine.exception.ConstraintViolationException;
import org.github.sustbird.statemachine.contract.State;
import org.github.sustbird.statemachine.contract.StateConstraint;

/**
 * @author shafiul.gp@gmail.com
 */
public class RoleConstraint implements StateConstraint<Blog> {

    @Override
    public boolean validate(final Blog oldValue, final Blog newValue, final State fromState, final State toState) {
        //validate business logic, return true/false
        return true;
    }

    @Override
    public ConstraintViolationException getViolationException(final Blog oldValue, final Blog newValue,
                                                              final State fromState,
                                                              final State toState) {
        //return actual violation with possible code & message, you can extend ConstraintViolationException for customization.
        return new ConstraintViolationException("", "Invalid Role to publish this blog");
    }
}
