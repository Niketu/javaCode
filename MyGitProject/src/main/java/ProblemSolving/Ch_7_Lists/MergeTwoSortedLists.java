package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/15/16.
 */
public class MergeTwoSortedLists<T> {
    public Node mergeTwoSortedLists (Node l1, Node l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        Node answer = new Node(-1);
        Node merged = answer;

        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                merged.next = l1;
                l1 = l1.next;
                merged = merged.next;
            } else {
                merged.next = l2;
                l2 = l2.next;
                merged = merged.next;
            }
        }

        if(l1 != null) {
            merged.next = l1;
        }

        if(l2 != null) {
            merged.next = l2;
        }
            
        return answer.next;
    }

    public static void main (String... args) {
        Node l11 = new Node(5);
        Node l12 = new Node(11);
        Node l13 = new Node(77);
        
        l11.next = l12;
        l12.next = l13;
        l13.next = null;
        
        Node l21 = new Node(3);
        Node l22 = new Node(17);
        Node l23 = new Node(50);
        
        l21.next = l22;
        l22.next = l23;
        l23.next = null;
        
        MergeTwoSortedLists ml = new MergeTwoSortedLists();
        Node.printList(ml.mergeTwoSortedLists(l11, l21));
    }

}

