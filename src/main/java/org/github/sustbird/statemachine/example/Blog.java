package org.github.sustbird.statemachine.example;

import org.github.sustbird.statemachine.State;

/**
 * @author shafiul.gp@gmail.com
 */
public class Blog {

    private String id;
    private BlogState state;

    public Blog(final String id, final BlogState state) {
        this.id = id;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public State<Blog> getState() {
        return state;
    }

    public Blog setState(final BlogState state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Blog{");
        sb.append("id='").append(id).append('\'');
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}
