package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;
import ProblemSolving.Utils.Pair;

/**
 * Created by hmahant on 7/18/16.
 *
 * Given a binary tree and an integer k.
 * Algorithm should return a node in the tree that is not k-balanced.
 * If no such node exist, return null.
 */
public class KBalancedNodes {
    // @include
    public static BinaryTree<Integer> findKUnBalancedNode(BinaryTree<Integer> T,
                                                          int k) {
        return findKUnBalancedNodeHelper(T, k).getKey();
    }

    private static Pair<BinaryTree<Integer>, Integer> findKUnBalancedNodeHelper(
            BinaryTree<Integer> T, int k) {
        // Empty tree.
        if (T == null) {
            return new Pair<>(null, 0);
        }

        // Early return if left subtree is not k-balanced.
        Pair<BinaryTree<Integer>, Integer> L = findKUnBalancedNodeHelper(T.getLeft(), k);
        if (L.getKey() != null) {
            return L;
        }
        // Early return if right subtree is not k-balanced.
        Pair<BinaryTree<Integer>, Integer> R = findKUnBalancedNodeHelper(T.getRight(), k);
        if (R.getKey() != null) {
            return R;
        }

        int nodeNum = L.getValue() + R.getValue() + 1;
        if (Math.abs(L.getValue() - R.getValue()) > k) {
            return new Pair<>(T, nodeNum);
        }
        return new Pair<>(null, nodeNum);
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
        int k = 1;
        BinaryTree<Integer> ans = findKUnBalancedNode(root, 0);
        System.out.println(ans == null ? "No "+k+" un-balanced nodes found." : ans.getData());
    }
}
