package springbook.learningtest.template;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;

/**
 * Created by eguns on 2017. 2. 16..
 */
public class CalcSumTest {
    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calSum(getClass().getResource("numbers.txt").getPath());
        Assert.assertThat(sum, is(10));
    }
}
