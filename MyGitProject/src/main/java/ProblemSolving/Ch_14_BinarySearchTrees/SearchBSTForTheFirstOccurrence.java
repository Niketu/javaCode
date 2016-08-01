package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/22/16.
 */
public class SearchBSTForTheFirstOccurrence {
    //Iterative
    public static BinaryTree<Integer> findFirstEqualKItr(
            BinaryTree<Integer> T, Integer k) {
        BinaryTree<Integer> first = null;
        BinaryTree<Integer> curr = T;
        while (curr != null) {
            if (curr.getData().compareTo(k) < 0) {
                curr = curr.getRight();
            } else if (curr.getData().compareTo(k) > 0) {
                curr = curr.getLeft();
            } else { // curr.getData().compareTo(k) == 0
                // Searches for the leftmost in the left subtree.
                first = curr;
                curr = curr.getLeft();
            }
        }
        return first;
    }

    //Recursive
    public static BinaryTree<Integer> findFirstEqualKRec(
            BinaryTree<Integer> T, Integer k) {
        if (T == null) {
            return null; // No match.
        } else if (T.getData().compareTo(k) == 0) {
            // Recursively searches the left subtree for first one == k.
            BinaryTree<Integer> n = findFirstEqualKRec(T.getLeft(), k);
            return n != null ? n : T;
        }
        // Searches left or right tree according to T.getData() and k.
        return findFirstEqualKRec(
                T.getData().compareTo(k) < 0 ? T.getRight() : T.getLeft(), k);
    }
}
