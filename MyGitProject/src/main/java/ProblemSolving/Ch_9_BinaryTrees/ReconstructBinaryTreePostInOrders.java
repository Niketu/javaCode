package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

import java.util.List;

/**
 * Created by hmahant on 7/19/16.
 *
 *                      4
 *                2           6
 *           1       3     5     7
 *
 * Post: 1 3 2 5 7 6 4
 *   In: 1 2 3 4 5 6 7
 *
 *   Root = 4
 *   In: (1 2 3 ) Post: (1 3 2) ** Recurse with this input now
 *   In: (5 6 7) Post: (5 7 6) ** Recurse with this input now
 *
 */
public class ReconstructBinaryTreePostInOrders {
    public static <T> BinaryTree<T> reconstructPostInOrders(List<T> post, List<T> in) {
        return reconstructPostInOrdersHelper(post, 0, post.size(), in, 0, in.size());
    }

    private static <T> BinaryTree<T> reconstructPostInOrdersHelper(List<T> post, int postS, int postE, List<T> in, int inS, int inE) {
        if (postE > postS && inE > inS) {
            int it = in.subList(inS, inE).indexOf(post.get(postE - 1));
            it = it < 0 ? inE : (it + inS);
            int leftTreeSize = it - inS;
            BinaryTree<T> tree = new BinaryTree<>(post.get(postE - 1));
                    // Recursively build the left subtree.
            tree.setLeft(reconstructPostInOrdersHelper(post, postS, postS + leftTreeSize, in,inS, it));
                    // Recursively build the right subtree.
            tree.setRight(reconstructPostInOrdersHelper(post, postS + leftTreeSize, postE - 1, in, it + 1, inE));
        }
        return null;
    }
}
