package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/18/16.
 *
 * Given the root of the Binary tree, find if the tree is balanced or not.
 * Space complexity: O(h)
 *
 * Balanced tree: The absolute difference of the left and the right subtree is not greater than 1.
 */
public class BalancedBinaryTree {
    public static boolean isBalanced(BinaryTree<Integer> bTree) {
        return getHeight(bTree) != -2;
    }

    public static int getHeight(BinaryTree node) {
        if(node == null) {
            return -1;
        }

        int lHeight = getHeight(node.getLeft());
        if(lHeight == -2) {
            return -2;
        }

        int rHeight = getHeight(node.getRight());
        if(rHeight == -2) {
            return -2;
        }

        if(Math.abs(lHeight-rHeight) >1) {
            return -2;
        }

        return 1 + Math.max(lHeight, rHeight);

    }

    public static void main(String... args) {
                /*
                            4
               2                 6
          1        3          5      7
        */
        BinaryTree<Integer> root = new BinaryTree<>(4);

        BinaryTree<Integer> p = new BinaryTree<>(1);
        BinaryTree<Integer> q = new BinaryTree<>(2);
        BinaryTree<Integer> r = new BinaryTree<>(3);

        BinaryTree<Integer> w = new BinaryTree<>(5);
        BinaryTree<Integer> x = new BinaryTree<>(6);
        BinaryTree<Integer> y = new BinaryTree<>(7);
        BinaryTree<Integer> z = new BinaryTree<>(8);
        BinaryTree<Integer> a = new BinaryTree<>(9);

        root.setLeft(q);
        q.setLeft(p);
        q.setRight(r);

        root.setRight(x);
        x.setLeft(w);
        x.setRight(y);
        y.setRight(z);
        z.setRight(a);

        System.out.println("Is the given tree balanced ? : "+isBalanced(root));
    }
}
