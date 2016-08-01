package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/21/16.
 */
public class Successor {
    public static BinaryTree<Integer> findSuccessor(BinaryTree<Integer> node) {
        BinaryTree<Integer> n = node;
        if (n.getRight() != null) {
            // Find the leftmost element in n's right subtree.
            n = n.getRight();
            while (n.getLeft() != null) {
                n = n.getLeft();
            }
            return n;
        }

        // Find the first parent whose left child contains n.
        while (n.getParent() != null && n.getParent().getRight() == n) {
            n = n.getParent();
        }
        // Return nullptr means n does not have successor.
        return n.getParent();
    }
}
