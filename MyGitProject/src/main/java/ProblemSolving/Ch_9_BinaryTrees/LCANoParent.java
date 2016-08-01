package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/20/16.
 */
public class LCANoParent {
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> n,
                                          BinaryTree<Integer> a,
                                          BinaryTree<Integer> b) {
        if (n == null) {
            // Empty subtree.
            return null;
        } else if (n == a || n == b) {
            return n;
        }

        BinaryTree<Integer> lRes = LCA(n.getLeft(), a, b);
        BinaryTree<Integer> rRes = LCA(n.getRight(), a, b);
        if (lRes != null && rRes != null) {
            // Found a and b in different subtrees.
            return n;
        }
        return lRes != null ? lRes : rRes;
    }

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
        // should output 3
        BinaryTree<Integer> x = LCA(root, root.getLeft(), root.getRight());
        assert (x.getData().equals(3));
        System.out.println(x.getData());
        // should output 5
        x = LCA(root, root.getRight().getLeft(), root.getRight().getRight());
        assert (x.getData().equals(5));
        System.out.println(x.getData());
        // should output 5
        x = LCA(root, root.getRight(), root.getRight().getRight());
        assert (x.getData().equals(5));
        System.out.println(x.getData());
    }
}
