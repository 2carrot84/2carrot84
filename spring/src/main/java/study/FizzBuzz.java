package study;

import akka.japi.pf.FI;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eguns on 2017. 4. 25..
 */
public class FizzBuzz {
    public static List<String> alternativeFizzBuzz(final int n) {
        final List<String> toReturn = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");

            if(!StringUtils.isEmpty(word)) {
                toReturn.add(Integer.toString(i));
            }
            else {
                toReturn.add(word);
            }
        }

        return toReturn;
    }

    private static String toWord(final int divisor,
                                 final int value,
                                 final String word) {
        return value % divisor == 0 ? word : "";
    }

    @Test
    public void fizzbuzzTest() {
        Assert.assertEquals(Arrays.asList("1","2","Fizz"), FizzBuzz.alternativeFizzBuzz(3));
    }
}
