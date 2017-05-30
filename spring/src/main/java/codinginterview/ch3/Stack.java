package codinginterview.ch3;

import codinginterview.ch2.Node;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class Stack {
    Node top;

    public Node pop() {
        if(top == null) return null;
        else {
            top = top.next;
            return top;
        }
    }

    public void push(int d) {
        Node n = new Node(d);

        n.next = top;
        top = n;
    }

    public Node peek() {
        return top;
    }
}
