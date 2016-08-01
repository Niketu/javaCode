package ProblemSolving.Ch_9_BinaryTrees;

import ProblemSolving.Utils.BinaryTree;

/**
 * Created by hmahant on 7/20/16.
 */
public class LCAWithHash {
    public static BinaryTree<Integer> LCA(BinaryTree<Integer> i,
                                          BinaryTree<Integer> j) {
//        Set<BinaryTree<Integer>> hash = new HashSet<>();
//        while (i != null || j != null) {
//            if (i != null) {
//                if (!hash.add(i)) {
//                    return i; // Adds a failed because a exists in hash.
//                }
//                i = i.getParent();
//            }
//            if (j != null) {
//                if (!hash.add(j)) {
//                    return j; // Adds a failed because a exists in hash.
//                }
//                j = j.getParent();
//            }
//        }
//        // Throw error if a and b are not in the same tree.
//        throw new RuntimeException("a and b are not in the same tree");
        return null; //TODO REMOVE IT
    }
    // @exclude

    public static void main(String[] args) {
        // 3
        // 2 5
        // 1 4 6
//        BinaryTree<Integer> root = new BinaryTree<>(3, null, null);
//        root.setLeft(new BinaryTree<>(2, null, null));
//        root.getLeft().setParent(root);
//        root.getLeft().setLeft(new BinaryTree<>(1, null, null));
//        root.getLeft().getLeft().setParent(root.getLeft());
//        root.setRight(new BinaryTree<>(5, null, null));
//        root.getRight().setParent(root);
//        root.getRight().setLeft(new BinaryTree<>(4, null, null));
//        root.getRight().getLeft().setParent(root.getRight());
//        root.getRight().setRight(new BinaryTree<>(6, null, null));
//        root.getRight().getRight().setParent(root.getRight());
//
//        // should output 3
//        assert (LCA(root.getLeft(), root.getRight()).getData().equals(3));
//        System.out.println(LCA(root.getLeft(), root.getRight()).getData());
//        // should output 5
//        assert (LCA(root.getRight().getLeft(), root.getRight().getRight())
//                .getData().equals(5));
//        System.out.println(LCA(root.getRight().getLeft(),
//                root.getRight().getRight()).getData());
    }
}
