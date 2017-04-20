package org.github.sustbird.statemachine.example;

import org.github.sustbird.statemachine.exception.ActionFailedException;
import org.github.sustbird.statemachine.contract.State;
import org.github.sustbird.statemachine.contract.StateAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shafiul.gp@gmail.com
 */
public class PublishAction implements StateAction<Blog> {
    private static Logger logger = LoggerFactory.getLogger(PublishAction.class);

    @Override
    public Blog execute(final Blog oldValue, final Blog newValue, final State<Blog> fromState,
                        final State<Blog> toState)
            throws ActionFailedException {
        //execute your business logic and return the updated Blog
        logger.debug("Executing action PublishAction for blog: {}", oldValue.getId());
        oldValue.setState(BlogState.PUBLISHED);
        //save to db

        return oldValue;
    }
}
