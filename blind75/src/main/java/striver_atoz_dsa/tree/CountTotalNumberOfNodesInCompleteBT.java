package striver_atoz_dsa.tree;

import java.util.Queue;

public class CountTotalNumberOfNodesInCompleteBT {
    public static void main(String[] args) {
        //          1
        //         / \
        //        2    3
        //       / \  / \
        //      4   5 10 11
        //     / \  / \
        //    6   7 8  9
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);


        // to count all the nodes present in complete BT
        // sol 1: do any traversal and count nodes
        // sol 2 : use the Complete BT property i.e. total node = 2^h - 1 (h = height of tree)

        int totalNodes = getTotalNodes(root);
        System.out.println("Total Nodes in the given BT :: " + totalNodes);
    }

    private static int getTotalNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            return (2 << (leftHeight)) - 1;
        } else
            return 1 + getTotalNodes(root.left) + getTotalNodes(root.right);
    }

    private static int getRightHeight(TreeNode root) {
        int rightHeight = 0;

        while (root.right != null) {
            rightHeight++;
            root = root.right;
        }

        return rightHeight;
    }

    private static int getLeftHeight(TreeNode root) {
        int leftHeight = 0;

        while (root.left != null) {
            leftHeight++;
            root = root.left;
        }

        return leftHeight;
    }
}
