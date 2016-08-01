package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/15/16.
 */
public class MedianOfSortedCircularList {
    public static double findMedianSortedCircularLinkedList(Node rNode) {
        // Checks all nodes are identical or not and identify the start of list.
        Node curr = rNode;
        Node start = rNode;
        int count = 0;
        do {
            ++count;
            curr = curr.next;
            // start will point to the largest element in the list.
            if (start.data <= curr.data) {
                start = curr;
            }
        } while (curr != rNode);
        // start's next is the begin of the list.
        start = start.next;

        // Traverses to the middle of the list and returns the median.
        for (int i = 0; i < ((count - 1) / 2); ++i) {
            start = start.next;
        }
        return (count & 1) != 0 ? start.data : 0.5 * (start.data + start.next.data);
    }

    public static void main(String... args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        Node c = new Node(3);
        b.next = c;
        Node x = new Node(3);
        c.next = x;
        Node d = new Node(4);
        x.next = d;
        Node f = new Node(5);
        d.next = f;
        Node g = new Node(6);
        f.next = g;
        g.next = a;

        System.out.println(findMedianSortedCircularLinkedList(a));
    }
}
