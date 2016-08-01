package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/16/16.
 */
public class ReverseListIterative {
    public static Node reverseLinkedList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
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

        System.out.println("Original list: ");
        Node.printList(a);
        System.out.println("Reversed list: ");
        Node.printList(reverseLinkedList(a));
    }
}
