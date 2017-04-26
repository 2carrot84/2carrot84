package study;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by eguns on 2017. 4. 26..
 */
public class IsPalindrome {
    public static boolean isPalindrome(final String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    @Test
    public void isPalindrome() {
        Assert.assertEquals(true, IsPalindrome.isPalindrome("tasat"));
        Assert.assertEquals(false, IsPalindrome.isPalindrome("abcd"));
    }
}
