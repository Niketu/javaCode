package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/16/16.
 */
public class DeleteKthLastElement {
    public static void deleteKthLast(Node a, int kthLast) {
        if(kthLast == 0) {
            return;
        }

        Node current = a;
        int counter = kthLast;
        while(counter-- >0) {
            current = current.next;
        }

        Node head = a;
        while(current != null) {
            head = head.next;
            current = current.next;
        }

        if(kthLast == 1) {
            head.data = null;
            head.next = null;
        } else {
            head.data = head.next.data;
            head.next = head.next.next;
        }
    }

    public static void main(String... args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        Node c = new Node(3);
        b.next = c;
        Node d = new Node(4);
        c.next = d;
        Node f = new Node(5);
        d.next = f;

        System.out.println("Before deletion of node 5rd last:: ");
        Node.printList(a);
        deleteKthLast(a, 5);
        System.out.println("Before deletion of node 5rd last:: ");
        Node.printList(a);
    }
}
