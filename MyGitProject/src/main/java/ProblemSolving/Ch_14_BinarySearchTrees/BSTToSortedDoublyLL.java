package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/22/16.
 */
public class BSTToSortedDoublyLL {
    // @include
    // Transform a BST into a circular sorted doubly linked list in-place,
    // return the head of the list.
    public static BinaryTree<Integer> bstToDoublyLinkedList(BinaryTree<Integer> n) {
        // Empty subtree.
        if (n == null) {
            return null;
        }

        // Recursively build the list from left and right subtrees.
        BinaryTree<Integer> lHead = bstToDoublyLinkedList(n.getLeft());
        BinaryTree<Integer> rHead = bstToDoublyLinkedList(n.getRight());

        // Append n to the list from left subtree.
        BinaryTree<Integer> lTail = null;
        if (lHead != null) {
            lTail = lHead.getLeft();
            lTail.setRight(n);
            n.setLeft(lTail);
            lTail = n;
        } else {
            lHead = lTail = n;
        }

        // Append the list from right subtree to n.
        BinaryTree<Integer> rTail = null;
        if (rHead != null) {
            rTail = rHead.getLeft();
            lTail.setRight(rHead);
            rHead.setLeft(lTail);
        } else {
            rTail = lTail;
        }
        rTail.setRight(lHead);
        lHead.setLeft(rTail);

        return lHead;
    }
}
