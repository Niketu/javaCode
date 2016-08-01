package ProblemSolving.Ch_8_StacksAndQueues;

import ProblemSolving.Utils.BinaryTree;

import java.util.Stack;

/**
 * Created by hmahant on 7/17/16.
 */
public class BSTSortedOrder {
    public static void printBSTSortedOrder(BinaryTree bst) {
        Stack<BinaryTree> stack = new Stack();
        BinaryTree root = bst;

        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                root = stack.pop();
                System.out.println(root.getData());
                root = root.getRight();
            }
        }
    }

    public static void main(String... args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTree<Integer> root = new BinaryTree<>(3);
        root.setLeft(new BinaryTree<>(2));
        root.getLeft().setLeft(new BinaryTree<>(1));
        root.setRight(new BinaryTree<>(5));
        root.getRight().setLeft(new BinaryTree<>(4));
        root.getRight().setRight(new BinaryTree<>(6));
        // should output 1 2 3 4 5 6
        printBSTSortedOrder(root);
    }
}
