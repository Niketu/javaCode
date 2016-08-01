package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hmahant on 7/19/16.
 *
 * Post order with null could construct the binary tree.
 *
 * IT IS IMPOSSIBLE TO CONSTRUCT THE BINARY TREE USING ONLY INORDER TRAVERSAL,
 * EVEN IF THE NULL AT THE LEAF NODE IS GIVEN.
 */

public class ReconstructPreorderWithNull {
    public static BinaryTree<Integer> reconstructPreorder(List<Integer> preorder) {
        Deque<BinaryTree<Integer>> s = new LinkedList<>();
        for (int i = preorder.size() - 1; i >= 0; i--) {
            if (preorder.get(i) == null) {
                s.push(null);
            } else { // Non-null.
                BinaryTree<Integer> l = s.pop();
                BinaryTree<Integer> r = s.pop();
                BinaryTree<Integer> tree = new BinaryTree<>(preorder.get(i));
                tree.setLeft(l);
                tree.setRight(r);
                s.push(tree);
            }
        }
        return s.peek();
    }
}
