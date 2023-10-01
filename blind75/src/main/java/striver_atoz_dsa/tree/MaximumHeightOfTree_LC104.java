package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

public class MaximumHeightOfTree_LC104 {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        int height = getHeight(root);
        System.out.println(height);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;

       return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
