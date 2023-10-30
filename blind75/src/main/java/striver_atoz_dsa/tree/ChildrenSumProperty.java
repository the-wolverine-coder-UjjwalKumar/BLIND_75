package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        // satisfy the children sum property
        // sum of left child + right child value <= root
        // we can increment the node value by +1, as many time as we want
        // generate the new tree which satisfies the children sum property.
        System.out.println("Before children sum property satisfied :: ");
        DFS_Traversal.printInOrder(root);
        System.out.println();
        satisfyChildrenSumProperty(root);

        System.out.println("After children sum property satisfied :: ");
        DFS_Traversal.printInOrder(root);
        System.out.println();
        //       36
        //      / \
        //    10   26
        //   / \   / \
        //  4   6 7  19
        //     /     / \
        //     6    9  10

    }

    private static void satisfyChildrenSumProperty(TreeNode root) {
        if (root==null) return;

        // collect the down value
        int childSum = 0;
        if (root.left != null) {
            childSum+=root.left.val;
        }

        if (root.right!=null) {
            childSum+=root.right.val;
        }

        if (childSum >= root.val) {
            // holding the min value
            root.val = childSum;
        } else {
            // updating the lower child and so that we can be in shortage
            if (root.left != null) root.left.val = childSum;
            if (root.right != null) root.right.val = childSum;
        }

        satisfyChildrenSumProperty(root.left);
        satisfyChildrenSumProperty(root.right);

        // after call over, collect the values from lc,rc
        int updatedChildSum = 0;
        if (root.left!=null) updatedChildSum+=root.left.val;
        if (root.right!=null) updatedChildSum+=root.right.val;

        if (root.left!=null || root.right!=null) root.val = updatedChildSum;


    }
}
