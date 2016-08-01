package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/15/16.
 */
public class OverlappingListsNoCycle {
    public static Node findCommonNode(Node l1, Node l2) {

        int l1Length = listLength(l1);
        int l2Length = listLength(l2);

        int diff = Math.abs(l1Length - l2Length);

        if(l1Length > l2Length) {
            while(diff > 0) {
                l1 = l1.next;
                diff--;
            }
        } else {
            while(diff > 0) {
                l2 = l2.next;
                diff--;
            }
        }

        while(l1 != null && l2 != null) {
            if(l1 == l2) {
                return l1;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }

    public static int listLength(Node l) {
        int length = 0;

        while (l != null) {
            length++;
            l = l.next;
        }

        return length;
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

        Node m = new Node(10);
        Node p = new Node(9);
        m.next = p;
        Node q = new Node(8);
        p.next = q;
        q.next = c;

        System.out.println(findCommonNode(a, m));
    }
}
