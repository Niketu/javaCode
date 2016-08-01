package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/16/16.
 */
public class DeleteNode {
    public static void deleteNode(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
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

        System.out.println("Before deletion of node 3:: ");
        Node.printList(a);
        deleteNode(c);
        System.out.println("Before deletion of node 3:: ");
        Node.printList(a);
    }
}
