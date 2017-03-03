package org.github.sustbird.statemachine.example;

import org.github.sustbird.statemachine.StateMachine;

/**
 * @author shafiul@cefalo.com
 */
public class TestStateMachine {

    public static void main(String[] args) {
        Blog oldValue = new Blog("1", BlogState.DRAFT);
        Blog newValue = new Blog("1", BlogState.PUBLISHED);

        StateMachine<Blog> stateMachine = new StateMachine<>();
        Blog updatedBlog = stateMachine.doTransition(oldValue, newValue, BlogState.DRAFT, BlogState.PUBLISHED);
        System.out.println("Updated blog: " + updatedBlog);
    }
}
