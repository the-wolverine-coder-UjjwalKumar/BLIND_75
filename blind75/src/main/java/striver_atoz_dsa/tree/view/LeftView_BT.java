package striver_atoz_dsa.tree.view;

import striver_atoz_dsa.tree.TreeNode;
import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.LinkedList;
import java.util.List;

public class LeftView_BT {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();
        // we have 2 approach 1. level order (in worst case it will contain half of the nodes)
        // 2. recursive here TC O(n) but SC will be height of tree (logN)
        List<Integer> leftView = new LinkedList<>();
        printLeftView(root, 0, leftView);

        System.out.println("Left view :: "+leftView);
    }

    private static void printLeftView(TreeNode root, int level, List<Integer> leftView) {
        // here we will be using simple PreOrder -> (Root, Left, Right)
        if (root == null) return;

        if (leftView.size() == level) leftView.add(root.val);
        printLeftView(root.left, level+1, leftView);
        printLeftView(root.right, level+1, leftView);
    }
}
