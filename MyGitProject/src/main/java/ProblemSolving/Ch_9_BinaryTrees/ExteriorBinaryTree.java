package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/20/16.
 */
public class ExteriorBinaryTree {
    public static void exteriorBinaryTree(BinaryTree<Integer> T) {
        if (T != null) {
            System.out.print(T.getData() + " ");
            leftBoundaryBinaryTree(T.getLeft(), true);
            rightBoundaryBinaryTree(T.getRight(), true);
        }
    }

    private static void leftBoundaryBinaryTree(
            BinaryTree<Integer> T, boolean isBoundary) {
        if (T != null) {
            if (isBoundary || (T.getLeft() == null && T.getRight() == null)) {
                System.out.print(T.getData() + " ");
            }
            leftBoundaryBinaryTree(T.getLeft(), isBoundary);
            leftBoundaryBinaryTree(T.getRight(), isBoundary && T.getLeft() == null);
        }
    }

    private static void rightBoundaryBinaryTree(
            BinaryTree<Integer> T, boolean isBoundary) {
        if (T != null) {
            rightBoundaryBinaryTree(T.getLeft(), isBoundary && T.getRight() == null);
            rightBoundaryBinaryTree(T.getRight(), isBoundary);
            if (isBoundary || (T.getLeft() == null && T.getRight() == null)) {
                System.out.print(T.getData() + " ");
            }
        }
    }

    public static void main(String[] args) {
        //               3
        //          2            5
        //      1       0     4     6
        //          -1     -2
        BinaryTree<Integer> root = new BinaryTree<>(3);
        root.setLeft(new BinaryTree<>(2));
        root.getLeft().setRight(new BinaryTree<>(0));
        root.getLeft().getRight().setLeft(new BinaryTree<>(-1));
        root.getLeft().getRight().setRight(new BinaryTree<>(-2));
        root.getLeft().setLeft(new BinaryTree<>(1));
        root.setRight(new BinaryTree<>(5));
        root.getRight().setLeft(new BinaryTree<>(4));
        root.getRight().setRight(new BinaryTree<>(6));
        // should output 3 2 1 -1 -2 4 6 5
        exteriorBinaryTree(root);
    }
}
