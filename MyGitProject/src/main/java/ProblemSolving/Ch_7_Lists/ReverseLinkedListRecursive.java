package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * 1->2->3->4->5
 * 1<-2<-3<-4<-5
 */
public class ReverseLinkedListRecursive {

    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
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
