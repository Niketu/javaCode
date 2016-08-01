package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/19/16.
 */
public class SymmetricBinaryTrees {
    // @include
    public static boolean isSymmetric(BinaryTree<Integer> T) {
        return T == null || isSymmetricHelper(T.getLeft(), T.getRight());
    }

    private static boolean isSymmetricHelper(BinaryTree<Integer> l, BinaryTree<Integer> r) {
        if (l == null && r == null) {
            return true;
        } else if (l != null && r != null) {
            return l.getData() == r.getData()
                    && isSymmetricHelper(l.getLeft(), r.getRight())
                    && isSymmetricHelper(l.getRight(), r.getLeft());
        } else {
            // (l != null && r == null) || (l == null && r != null)
            return false;
        }
    }
    // @exclude

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTree<Integer> root = new BinaryTree<>(3);
        root.setLeft(new BinaryTree<>(2));
        root.getLeft().setLeft(new BinaryTree<>(1));
        root.setRight(new BinaryTree<>(5));
        root.getRight().setLeft(new BinaryTree<>(4));
        root.getRight().setRight(new BinaryTree<>(6));
        System.out.println(isSymmetric(root));
    }
}
