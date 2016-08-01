package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/19/16.
 */
public class TreeTraversalsTest {
    public static void main (String... args) {
        BinaryTree<Integer> root = new BinaryTree<>(3);
        root.setLeft(new BinaryTree<>(2));
        root.getLeft().setLeft(new BinaryTree<>(1));
        root.setRight(new BinaryTree<>(5));
        root.getRight().setLeft(new BinaryTree<>(4));
        root.getRight().setRight(new BinaryTree<>(6));

        BinaryTree.inorderTraversal(root);
        System.out.println();
        BinaryTree.preorderTraversal(root);
        System.out.println();
        BinaryTree.postorderTraversal(root);
    }
}
