package ProblemSolving.Ch_8_StacksAndQueues;

import ProblemSolving.Utils.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hmahant on 7/18/16.
 */
public class BinaryTreeLevelOrder {
    public static void printBinaryTreeLevelOrder(BinaryTree<Integer> root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.getData());

            if(root.getLeft() != null) {
                queue.add(root.getLeft());
            }

            if(root.getRight() != null) {
                queue.add(root.getRight());
            }
        }
    }

    public static void main(String... args) {
        /*
                            4
               2                 6
          1        3          5      7
        */
        BinaryTree<Integer> root = new BinaryTree<>(4);

        BinaryTree<Integer> p = new BinaryTree<>(1);
        BinaryTree<Integer> q = new BinaryTree<>(2);
        BinaryTree<Integer> r = new BinaryTree<>(3);

        BinaryTree<Integer> w = new BinaryTree<>(5);
        BinaryTree<Integer> x = new BinaryTree<>(6);
        BinaryTree<Integer> y = new BinaryTree<>(7);

        root.setLeft(q);
        q.setLeft(p);
        q.setRight(r);

        root.setRight(x);
        x.setLeft(w);
        x.setRight(y);

        printBinaryTreeLevelOrder(root);
    }
}
