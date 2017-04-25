package study.designpattern.templatemethodpattern;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by eguns on 2017. 4. 25..
 */
public class StackPredicateTest {
    private Stack stack;

    @Before
    public void createStack() {
        stack = new Stack();

        for (int i = 0; i <= 10; i++) {
            stack.push(i);
        }
    }

    @Test
    public void evenPredicate() {
        final Stack filtered = stack.filter(new StackPredicate() {
            @Override
            public boolean isValid(int i) {
                return (i%2 == 0);
            }
        });

        Assert.assertEquals(Integer.valueOf(10), filtered.pop());
        Assert.assertEquals(Integer.valueOf(8), filtered.pop());
        Assert.assertEquals(Integer.valueOf(6), filtered.pop());

    }

    @Test
    public void allPredicate() {
        final Stack filtered = stack.filter(new StackPredicate() {
            @Override
            public boolean isValid(int i) {
                return true;
            }
        });

        Assert.assertEquals(Integer.valueOf(10), filtered.pop());
        Assert.assertEquals(Integer.valueOf(9), filtered.pop());
        Assert.assertEquals(Integer.valueOf(8), filtered.pop());
    }
}
