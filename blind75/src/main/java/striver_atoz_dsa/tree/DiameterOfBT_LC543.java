package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

public class DiameterOfBT_LC543 {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();
        // this will not work bcz it is creating new integer and trying to reassign it inside the method
        // which will not affect the old reference, hence we won't find any changes
//        Integer num = 5;  // Create an Integer object with value 5
//
//        // Attempting to modify the value of num
//        num = num + 1;    // Creates a new Integer object with value 6
//
//        System.out.println(num);  // Outputs 6
//        Integer diameter = new Integer(0);

        // so use mutable ds
        int[] diameter = new int[]{0};
        int height = getDiameterOfTree(root, diameter);
        System.out.println(diameter[0]);
    }

    private static int getDiameterOfTree(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int lh = getDiameterOfTree(root.left, diameter);
        int rh = getDiameterOfTree(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
