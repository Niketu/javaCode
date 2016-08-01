package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/15/16.
 */
public class ListCycle {
    public static Node hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow != null && slow.next != null && fast != null
                && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // There is a cycle.
                // Calculates the cycle length.
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);

                // Tries to find the start of the cycle.
                slow = head;
                fast = head;
                // Fast pointer advances cycleLen first.
                while (cycleLen-- > 0) {
                    fast = fast.next;
                }
                // Both pointers advance at the same time.
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // The start of cycle.
            }
        }
        return null; // no cycle.
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
        f.next = c;

        System.out.println(hasCycle(a));
    }
}
