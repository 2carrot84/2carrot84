package study.designpattern.templatemethodpattern;

import java.util.LinkedList;

/**
 * Created by eguns on 2017. 4. 25..
 */
public class Stack {
    private final LinkedList<Integer> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public Stack(final LinkedList<Integer> stack) {
        this.stack = stack;
    }

    public void push(final int number) {
        stack.add(0, number);
    }

    public Integer pop() {
        return stack.remove(0);

    }

    public Stack filter(final StackPredicate filter) {
        final LinkedList<Integer> initialState = new LinkedList<>();

        for (Integer integer: stack) {
            if (filter.isValid(integer)) {
                initialState.add(integer);
            }
        }

        return new Stack(initialState);
    }
}
