package codinginterview.ch2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class LinkedListTest {
    Node n = new Node(0);

    @Test
    public void appendTailNode() {
        n.appendToTail(1);
        Assert.assertEquals(n.toString(),"01");
        n.appendToTail(1);
        Assert.assertEquals(n.toString(),"011");
        n.appendToTail(2);
        Assert.assertEquals(n.toString(),"0112");
    }
}
