# Simplest possible Java State Machine

This simple state machine consists of few dead simple contracts for defining constraints and actions along with single engine file of ~80 lines.
 
This code base also includes few example file to show how to implement the contracts.

### Transition Rule

Transition rules are defined in the state enum which implements a simple interface. Look at the example code to see how to define the rules. 

Every state in the state enum defines from which states this state can be reached and what are the preconditions(a list) to statisfy for the transition and it allows to define a set of actions while doing the transition after satisfying all the preconditions.

Below is an example to define rule
```
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
```
It indicates that state DELETED can only be reached from DRAFT, satisfying RoleConstraint and if satisfied, it executes Publish Action (just for example).

### Transition Constraints
Constrains are classes implementing below simple contract. Constraints have access to old value, new value, old state, new state; making it easy to validate the business logic.

```
public interface StateConstraint<T> {
    boolean validate(T oldValue, T newValue, State fromState, State toState);

    ConstraintViolationException getViolationException(T oldValue, T newValue, State fromState, State toState);
}
```
### Transition Actions
Actions are class implementing below simple contract.
The only method required to implement is execute(), which have access to old value, new value, old state, new state.
```
public interface StateAction<T> {

    int DEFAULT_ORDER = 100;

    T execute(T oldValue, T newValue, State<T> fromState, State<T> toState) throws ActionFailedException;

    /**
     * Determines if this action will halt the transition.
     * If false, other actions will continue to execute.
     * @return
     */
    default boolean isBlocking() {
        return true;
    }

    /**
     * Low means higher priority.
     * @return
     */
    default int getOrder() {
        return DEFAULT_ORDER;
    }

    String toString();
}
```
#### Action Order
Actions are executed in order. You can override getOrder() method to set order of action. Lower the order number means higher prioriy. But you are not required to override this method, by default all actions have same priority(100).
#### Blocking & Non-blocking
Some actions may be blocking i.e if exception is thrown, no other actions is executed. In case of non-blocking actions, if it thows exception, next actions are executed sequentially.
You can define a task blocking/non-blocking by simply overriding isBlocking() method in the action class. Be default all actions are blocking.
