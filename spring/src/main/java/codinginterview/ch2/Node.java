package codinginterview.ch2;

/**
 * Created by eguns on 2017. 5. 30..
 */
public class Node {
    public int data;
    public Node next = null;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;

        while (n.next != null) n = n.next;

        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;

        if(n.data == d) {
            return head.next;
        }

        while (n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node n = this;
        sb.append(n.data);
        while (n.next != null) {
            n = n.next;
            sb.append(n.data);
        }

        return sb.toString();
    }
}
