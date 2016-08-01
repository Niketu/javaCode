package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/21/16.
 */
public class IsABinaryTreeBST {
    public static boolean isBST(BinaryTree<Integer> root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTHelper(BinaryTree<Integer> root,
                                       Integer lower, Integer upper) {
        if (root == null) {
            return true;
        } else if (root.getData().compareTo(lower) < 0
                || root.getData().compareTo(upper) > 0) {
            return false;
        }

        return isBSTHelper(root.getLeft(), lower, root.getData())
                && isBSTHelper(root.getRight(), root.getData(), upper);
    }
}
