package org.github.sm.example;

import org.github.sm.ActionFailedException;
import org.github.sm.State;
import org.github.sm.StateAction;

/**
 * @author shafiul.gp@gmail.com
 */
public class PublishAction implements StateAction<Blog> {

    @Override
    public Blog execute(final Blog oldValue, final Blog newValue, final State<Blog> fromState,
                        final State<Blog> toState)
            throws ActionFailedException {
        //execute your business logic and return the updated Blog
        return null;
    }
}
