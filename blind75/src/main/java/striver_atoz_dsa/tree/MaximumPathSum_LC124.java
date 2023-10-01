package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

public class MaximumPathSum_LC124 {

    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();
        int[] maxi = {0};
        int ans = getMaxPathSum(root, maxi);
        System.out.println(maxi[0]);
    }

    private static int getMaxPathSum(TreeNode root, int[] maxi) {
        if (root == null) return 0;

        int leftPathSum = Math.max(0,getMaxPathSum(root.left, maxi));
        int rightPathSum = Math.max(0,getMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}
