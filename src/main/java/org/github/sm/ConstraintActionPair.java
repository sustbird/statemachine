package org.github.sm;

import java.util.List;
import java.util.Set;

/**
 * Represents a pair of constraints and actions.
 * @author shafiul.gp@gmail.com
 */
public class ConstraintActionPair<T> {

    private List<StateConstraint<T>> constraints;

    private Set<StateAction<T>> actions;

    public ConstraintActionPair(final List<StateConstraint<T>> constraints, final Set<StateAction<T>> actions) {
        this.constraints = constraints;
        this.actions = actions;
    }

    public List<StateConstraint<T>> getConstraints() {
        return constraints;
    }

    public Set<StateAction<T>> getActions() {
        return actions;
    }
}
