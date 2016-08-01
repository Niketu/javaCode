package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

import java.util.List;

/**
 * Created by hmahant on 7/19/16.
 */
public class ReconstructBinaryTreePreInorders {
    /**
     * Created by hmahant on 7/19/16.
     *
     *                      4
     *                2           6
     *           1       3     5     7
     *
     *  Pre: 4 2 1 3 6 5 7
     *   In: 1 2 3 4 5 6 7
     *
     *   Root = 4
     *   In: (1 2 3 ) Pre: (2 1 3) ** Recurse with this input now
     *   In: (5 6 7) Pre: (6 5 7) ** Recurse with this input now
     *
     */
    public static <T> BinaryTree<T> reconstructPreInOrders(List<T> pre,
                                                           List<T> in) {
        return reconstructPreInOrdersHelper(pre, 0, pre.size(), in, 0, in.size());
    }

    private static <T> BinaryTree<T> reconstructPreInOrdersHelper(
            List<T> pre, int preS, int preE, List<T> in, int inS, int inE) {
        if (preE > preS && inE > inS) {
            int it = in.subList(inS, inE).indexOf(pre.get(preS));
            it = it < 0 ? inE : (it + inS);
            int leftTreeSize = it - inS;

            BinaryTree<T> tBinaryTree = new BinaryTree<>(pre.get(preS));
            tBinaryTree.setLeft(reconstructPreInOrdersHelper(pre, preS + 1, preS + 1 + leftTreeSize, in, inS, it));
            tBinaryTree.setRight(reconstructPreInOrdersHelper(pre, preS + 1 + leftTreeSize, preE, in, it + 1, inE));
            return tBinaryTree;
        }
        return null;
    }

}
