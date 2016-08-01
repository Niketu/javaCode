package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 *  1 -> 2 -> 3
 *              \
 *          5 ->8 -> 9 -> 10
 *          ^              |
 *          |______________|
 */
public class OverlappingListsWithCycle {
    public static Node findCommonNode(Node l1, Node l2) {
        Node l1Cycle = ListCycle.hasCycle(l1);
        Node l2Cycle = ListCycle.hasCycle(l2);

        if (l1Cycle == null && l2Cycle == null) {
            //No cycle detected, use the logic to find out common nodes, no cycle.
            return OverlappingListsNoCycle.findCommonNode(l1, l2);
        } else if (l1Cycle != null && l2Cycle != null) {
            Node tmp = l2Cycle;

            do {
                tmp = tmp.next;
            } while (tmp != l1Cycle && tmp != l2Cycle);

            //l1 and l2 do not have a node in common
            if(tmp != l1Cycle) {
                return null; //Cycles do not end
            }

            // Since L1 and L2 are end in the same cycle, find the overlapping node
            // if it happens before cycle starts.
            int distL1c = findDistance(l1, l1Cycle);
            int distL2c = findDistance(l2, l2Cycle);
            int diff = Math.abs(distL1c - distL2c);

            if(distL1c > distL2c) {
                while(diff-- > 0) {
                    l1 = l1.next;
                }
            } else {
                while(diff-- > 0) {
                    l2 = l2.next;
                }
            }

            while(l1 != l2 && l1 != l1Cycle && l2 != l2Cycle) {
                l1 = l1.next;
                l2 = l2.next;
            }

            // If L1 == L2 before reaching s1, it means overlapping node happens
            // before cycle starts; otherwise, the node cycle starts is one of the
            // overlapping nodes.
            return l1 == l2 ? l1 : l1Cycle;
        }

        return null;
    }

    private static int findDistance(Node l1, Node l2) {
        int count = 0;

        if(l1 != l2) {
            l1 = l1.next;
            count++;
        }

        return count;
    }

    public static void main(String... args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        Node c = new Node(3);
        b.next = c;


        Node m = new Node(5);
        Node p = new Node(8);
        m.next = p;
        c.next = p;
        Node q = new Node(9);
        p.next = q;
        Node r = new Node(10);
        q.next = r;
        r.next = m;


        System.out.println(findCommonNode(a, m));
    }
}
