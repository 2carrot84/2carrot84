package springbook.learningtest.template;

        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import java.io.IOException;

        import static org.hamcrest.core.Is.is;

/**
 * Created by eguns on 2017. 2. 16..
 */
public class CalcSumTest {
    private Calculator calculator;
    private String filePath;

    @Before
    public void setUp() {
        calculator = new Calculator();
        filePath = getClass().getResource("numbers.txt").getPath();
    }

    @Test
    public void sumOfNumbers() throws IOException {
//        Calculator calculator = new Calculator();
        int sum = calculator.calSum(filePath);
        Assert.assertThat(sum, is(10));
    }

    @Test
    public void multipleOfNumbers() throws IOException {
        int sum = calculator.calMultiple(filePath);
        Assert.assertThat(sum, is(24));
    }
    
    @Test
    public void conctenateStrings() throws IOException {
    	Assert.assertThat(calculator.concatenate(filePath), is("1234"));
    }
}
