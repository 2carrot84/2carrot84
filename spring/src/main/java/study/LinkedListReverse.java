package study;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eguns on 2017. 4. 26..
 */
public class LinkedListReverse {
    public static <T> LinkedList<T> reverse(final LinkedList<T> orginal) {
        if(orginal == null) {
            throw new NullPointerException("Cannot reverse a null list");
        }

        if(orginal.getNext() == null) {
            return orginal;
        }

        final LinkedList<T> next = orginal.getNext();
        orginal.setNext(null);

        final LinkedList<T> othersReversed = reverse(next);
        next.setNext(orginal);

        return othersReversed;
    }

    @Test
    public void reversedLinkedList() {
        final LinkedList<String> three = new LinkedList<>("3", null);
        final LinkedList<String> two = new LinkedList<>("2", three);
        final LinkedList<String> one = new LinkedList<>("1", two);

        Assert.assertEquals("1", one.getElement());
        Assert.assertEquals("2", one.getNext().getElement());
        Assert.assertEquals("3", one.getNext().getNext().getElement());

        final LinkedList<String> reversed = LinkedListReverse.reverse(one);

        Assert.assertEquals("3", reversed.getElement());
        Assert.assertEquals("2", reversed.getNext().getElement());
        Assert.assertEquals("1", reversed.getNext().getNext().getElement());


    }
}
