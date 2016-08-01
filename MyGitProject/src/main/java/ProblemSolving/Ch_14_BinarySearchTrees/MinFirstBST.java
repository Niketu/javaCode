package ProblemSolving.Ch_14_BinarySearchTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/22/16.
 */
public class MinFirstBST {
    public boolean minFirstBST(BinaryTree<Integer> root, int k) {
        if(root == null || root.getData() > k) {
            return false;
        } else if (root.getData() == k) {
            return true;
        }

        return minFirstBST(root.getLeft(), k) || minFirstBST(root, k);
    }
}
