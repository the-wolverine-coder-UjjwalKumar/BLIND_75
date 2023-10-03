package striver_atoz_dsa.tree.view;

import striver_atoz_dsa.tree.TreeNode;
import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.LinkedList;
import java.util.List;

public class RightView_BT {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();
        // we have two approach 1. level order (in worst case it will contain half of the nodes)
        // 2. recursive here TC O(n) but SC will be height of tree (logN)
        List<Integer> rightView = new LinkedList<>();

        printRightView(root, 0, rightView);

        System.out.println("Right view :: "+rightView);
    }

    private static void printRightView(TreeNode root, int level, List<Integer> rightView) {
        // here we will be using reverse PreOrder -> (Root, Left, Right) - (Root, Right, Left)
        if (root == null) return;

        if (rightView.size() == level) rightView.add(root.val);
        printRightView(root.right, level+1, rightView);
        printRightView(root.left, level+1, rightView);
    }
}
