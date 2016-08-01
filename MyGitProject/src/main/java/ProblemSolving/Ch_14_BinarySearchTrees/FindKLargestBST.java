package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmahant on 7/22/16.
 */
public class FindKLargestBST {
    public static List<Integer> findKLargestInBST(
            BinaryTree<Integer> root, int k) {
        List<Integer> kElements = new ArrayList<>();
        findKLargestInBSTHelper(root, k, kElements);
        return kElements;
    }

    private static void findKLargestInBSTHelper(
            BinaryTree<Integer> r, int k, List<Integer> kElements) {
        // Performs reverse inorder traversal.
        if (r != null && kElements.size() < k) {
            findKLargestInBSTHelper(r.getRight(), k, kElements);
            if (kElements.size() < k) {
                kElements.add(r.getData());
                findKLargestInBSTHelper(r.getLeft(), k, kElements);
            }
        }
    }
}
