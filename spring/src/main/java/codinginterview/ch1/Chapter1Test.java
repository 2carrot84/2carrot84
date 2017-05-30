package codinginterview.ch1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class Chapter1Test {
    ArraysAndString c = new ArraysAndString();

    @Test
    public void p1Test() {
        Assert.assertEquals(c.p1("abcd"),true);
        Assert.assertEquals(c.p1("abad"),false);
        Assert.assertEquals(c.p1("abwodksxsjxlsdksjd"),false);
        Assert.assertEquals(c.p1("aa"),false);
        Assert.assertEquals(c.p1("abcdefghijklmno"),true);
    }

    @Test
    public void isUniqueChars2Test() {
        Assert.assertEquals(c.isUniqueChars2("abcd"),true);
        Assert.assertEquals(c.isUniqueChars2("abad"),false);
        Assert.assertEquals(c.isUniqueChars2("abwodksxsjxlsdksjd"),false);
        Assert.assertEquals(c.isUniqueChars2("aa"),false);
        Assert.assertEquals(c.isUniqueChars2("abcdefghijklmno"),true);
    }
}
