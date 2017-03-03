package org.github.sustbird.statemachine;

import java.util.List;
import java.util.Set;

/**
 * Represents a pair of constraints and actions.
 * @author shafiul.gp@gmail.com
 */
public class ConstraintActionPair<T> {

    /**
     * to hold list of constraints
     */
    private List<StateConstraint<T>> constraints;

    /**
     * to hold the set of actions
     */
    private Set<StateAction<T>> actions;

    /**
     * Constructor.
     * @param constraints list of constraints
     * @param actions set of actions
     */
    public ConstraintActionPair(final List<StateConstraint<T>> constraints, final Set<StateAction<T>> actions) {
        this.constraints = constraints;
        this.actions = actions;
    }

    /**
     * Getter for constraints.
     * @return
     */
    public List<StateConstraint<T>> getConstraints() {
        return constraints;
    }

    /**
     * Getter for actions.
     * @return
     */
    public Set<StateAction<T>> getActions() {
        return actions;
    }
}
