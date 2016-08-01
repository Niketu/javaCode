package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

import java.util.List;

/**
 * Created by hmahant on 7/22/16.
 */
public class BSTFromASortedArray {
    public static BinaryTree<Integer> buildBSTFromSortedArray(List<Integer> a) {
        return buildBSTFromSortedArrayHelper(a, 0, a.size());
    }

    // Build BST based on subarray A[start : end - 1].
    private static BinaryTree<Integer> buildBSTFromSortedArrayHelper(
            List<Integer> a, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            BinaryTree<Integer> bst = new BinaryTree<>(a.get(mid));
            bst.setLeft(buildBSTFromSortedArrayHelper(a, start, mid));
            bst.setRight(buildBSTFromSortedArrayHelper(a, mid + 1, end));
            return bst;
        }
        return null;
    }
}
