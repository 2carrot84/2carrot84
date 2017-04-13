package springbook.learningtest.jdk;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by eguns on 2017. 4. 13..
 */
public class JavaStudyTest {
    @Test
    public void staticVariableAccess() {
        Assert.assertThat(StaticVariableClass.EXAMPLE_VALUE, is(6));

        StaticVariableClass s1 = new StaticVariableClass();
        StaticVariableClass s2 = new StaticVariableClass();

        s1.EXAMPLE_VALUE = 22;

        Assert.assertThat(StaticVariableClass.EXAMPLE_VALUE, is(22));
        Assert.assertThat(s2.EXAMPLE_VALUE, is(22));
    }

    @Test
    public void polymorphicList() {
        Rectangle r1 = new Rectangle(5, 1);
        Rectangle r2 = new Rectangle(2, 10);
        Square s1 = new Square(4);
        Rectangle r3 = new Square(5);

    }
}
