package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmahant on 7/19/16.
 */
public class ConnectLeaves {
    // @include
    public static List<BinaryTree<Integer>> connectLeaves(BinaryTree<Integer> n) {
        List<BinaryTree<Integer>> L = new ArrayList<>();
        connectLeavesHelper(n, L);
        return L;
    }

    private static void connectLeavesHelper(BinaryTree<Integer> n, List<BinaryTree<Integer>> L) {
        if (n != null) {
            if (n.getLeft() == null && n.getRight() == null) {
                L.add(n);
            } else {
                connectLeavesHelper(n.getLeft(), L);
                connectLeavesHelper(n.getRight(), L);
            }
        }
    }
}
