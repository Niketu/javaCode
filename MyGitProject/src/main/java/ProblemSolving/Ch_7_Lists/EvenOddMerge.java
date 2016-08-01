package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/15/16.
 */
public class EvenOddMerge {
    public static Node evenOddMerge(Node head) {
        if(head == null) {
            return null;
        }

        Node oddHead = null;
        Node evenHead = null;
        Node oddLast = null;
        Node evenLast = null;

        while (head != null ) {
            if(head.data % 2 == 0) {
                if(evenHead == null) {
                    evenHead = head;
                    evenLast = head;
                } else {
                    evenLast.next = head;
                    evenLast = head;
                }
                head = head.next;
            } else {
                if(oddHead == null) {
                    oddHead = head;
                    oddLast = head;
                } else {
                    oddLast.next = head;
                    oddLast = head;
                }
                head = head.next;
            }
        }

        if(evenHead != null) {
            evenLast.next = oddHead;
        }

        if(evenHead == null) {
            evenHead = oddHead;
        }

        if(oddHead != null) {
            oddLast.next = null;
        }

        return evenHead;
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

        Node.printList(evenOddMerge(a));

    }
}
