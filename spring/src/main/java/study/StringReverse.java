package study;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eguns on 2017. 4. 25..
 */
public class StringReverse {
    public static String reverse(final String s) {
        final StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length()-1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    @Test
    public void stringReverse() {
        Assert.assertEquals("dcba", StringReverse.reverse("abcd"));
    }
}
