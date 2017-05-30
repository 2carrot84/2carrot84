package codinginterview.ch3;

import codinginterview.ch2.Node;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class Queue {
    Node first, last;

    public void enqueue(int d) {
        Node n = new Node(d);

        if(first == null) {
            last = n;
            first = last;
        }
        else {
            last.next = n;
            last = n;
        }
    }

    public int dequeue() {
        int d = -1;
        if(first != null) {
            d = first.data;
            first = first.next;
        }

        return d;
    }
}
