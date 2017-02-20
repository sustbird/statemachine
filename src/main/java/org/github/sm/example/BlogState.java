package org.github.sm.example;

import org.github.sm.ConstraintActionPair;
import org.github.sm.State;
import org.github.sm.StateAction;
import org.github.sm.StateConstraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shafiul.gp@gmail.com
 */
public enum BlogState implements State<Blog> {

    DRAFT {
        @Override
        public Map<State, ConstraintActionPair<Blog>> getTransitions() {
            return null;
        }
    },
    DELETED {
        @Override
        public Map<State, ConstraintActionPair<Blog>> getTransitions() {
            Set<StateAction<Blog>> stateActions = new HashSet<>();
            stateActions.add(new PublishAction());

            List<StateConstraint<Blog>> stateConstraints = new ArrayList<>();
            stateConstraints.add(new RoleConstraint());

            ConstraintActionPair<Blog> constraintActionPair =
                    new ConstraintActionPair<>(stateConstraints, stateActions);

            Map<State, ConstraintActionPair<Blog>> constraintActionPairMap = new HashMap<>();
            //here the key is the state from which this state can be reached and
            //the value is a pair of constraints and actions for that state
            constraintActionPairMap.put(BlogState.DRAFT, constraintActionPair);

            return constraintActionPairMap;
        }
    }
}
