package ProblemSolving.Ch_9_BinaryTrees;

/**
 * Created by hmahant on 7/19/16.
 *
 * In this scheme, we need to know the child that just got visited in the flow was it's parent's
 * right child or a left child. If it was the left child, we need to complete visite for the right child,
 * if it was right, then we just completed visiting the parent node.
 *
 * This could be achieved by storing:
 * the previous visited node in the prev storage, before we mode to the parent pointer.
 */
public class InorderTraversalWithParent {
    private static class BinaryTree<T> {
        private T data;
        private BinaryTree<T> left, right;
        private BinaryTree<T> parent;

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
    }
    public static void inOrderTraversal(BinaryTree<Integer> T) {
        // Empty tree.
        if (T == null) {
            return;
        }

        BinaryTree<Integer> prev = null, curr = T, next;
        while (curr != null) {
            if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
                if (curr.getLeft() != null) {
                    next = curr.getLeft();
                } else {
                    System.out.println(curr.getData());
                    next = (curr.getRight() != null ? curr.getRight() : curr.getParent());
                }
            } else if (curr.getLeft() == prev) {
                System.out.println(curr.getData());
                next = (curr.getRight() != null ? curr.getRight() : curr.getParent());
            } else {
                // curr.getRight() == prev.
                next = curr.getParent();
            }

            prev = curr;
            curr = next;
        }
    }

    // @exclude

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
        BinaryTree<Integer> root = new BinaryTree<>(3);
        root.setLeft(new BinaryTree<>(2));
        root.getLeft().setParent(root);
        root.getLeft().setLeft(new BinaryTree<>(1));
        root.getLeft().getLeft().setParent(root.getLeft());
        root.setRight(new BinaryTree<>(5));
        root.getRight().setParent(root);
        root.getRight().setLeft(new BinaryTree<>(4));
        root.getRight().getLeft().setParent(root.getRight());
        root.getRight().setRight(new BinaryTree<>(6));
        root.getRight().getRight().setParent(root.getRight());

        // Should output 1 2 3 4 5 6.
        inOrderTraversal(root);
    }
}
