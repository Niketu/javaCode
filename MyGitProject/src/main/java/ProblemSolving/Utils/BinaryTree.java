package ProblemSolving.Utils;

/**
 * Created by hmahant on 7/17/16.
 */
public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> left, right, parent;

    public BinaryTree(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<T> parent) {
        this.parent = parent;
    }

    public static void inorderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }

        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.print(root.getData());
            inorderTraversal(root.getRight());
        }
    }

    public static void preorderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }

        if (root != null) {
            System.out.print(root.getData());
            inorderTraversal(root.getLeft());
            inorderTraversal(root.getRight());
        }
    }

    public static void postorderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }

        if (root != null) {
            inorderTraversal(root.getLeft());
            inorderTraversal(root.getRight());
            System.out.print(root.getData());
        }
    }

    public static void inorderTraversalIterative(BinaryTree root) {
    }

    public static void preorderTraversalIterative(BinaryTree root) {
    }

    public static void postorderTraversalIterative(BinaryTree root) {
    }

}
