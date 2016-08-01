package ProblemSolving.Ch_9_BinaryTrees;

/**
 * Created by hmahant on 7/19/16.
 *
 * For certain applications, processes need to lock the nodes in the binary tree.
 *
 * Constraint: A node can not be locked if any of it's ancestor or descendant is locked.
 *
 * Develop the following functions:
 * lock() - O(1)
 * isLock() - O(h)
 * unlock() - O(h)
 *
 * h = Height of the tree
 * Note: Each node contains a parent field.
 */
public class BinaryTreeWithLock {
    private class BinaryTree<T> {
        private T data;
        private BinaryTree<T> left;
        private BinaryTree<T> right;
        private BinaryTree<T> parent;
        private boolean locked;
        private int numChildrenLocks;

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

        public void setData(T data) {
            this.data = data;
        }

        public BinaryTree<T> getParent() {
            return parent;
        }

        public void setParent(BinaryTree<T> parent) {
            this.parent = parent;
        }

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }

        public int getNumChilderenLock() {
            return numChildrenLocks;
        }

        public void setNumChilderenLock(int numChilderenLocks) {
            this.numChildrenLocks = numChilderenLocks;
        }

        public boolean isLock() {
            return locked;
        }

        public void lock() {
            if (numChildrenLocks == 0 && !locked) {
                // Make sure all parents do not lock.
                BinaryTree n = parent;
                while (n != null) {
                    if (n.locked) {
                        return;
                    }
                    n = n.parent;
                }

                // Lock itself and update its parents.
                locked = true;
                n = parent;
                while (n != null) {
                    ++n.numChildrenLocks;
                    n = n.parent;
                }
            }
        }

        public void unlock() {
            if (locked) {
                // Unlock itself and update its parents.
                locked = false;
                BinaryTree n = parent;
                while (n != null) {
                    --n.numChildrenLocks;
                    n = n.parent;
                }
            }
        }
    }
}
