package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.LinkedList;
import java.util.List;

public class PrintRootToNodePath {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        // somewhere we have given root itself or root's value
        int value = 6;
        List<TreeNode> ds = new LinkedList<TreeNode>();
        printRootToNodePath(root, value, ds);
        if (!ds.isEmpty()) {
            ds.forEach(node -> System.out.print(node.val+" "));
        } else {
            System.out.println("Node value "+value+" doesn't exists in Tree, hence no path exists");
        }
    }

    private static boolean printRootToNodePath(TreeNode root, int value, List<TreeNode> pathTillNode) {
        // we can use any traversal but Inorder will have simple code hence easy to explain in interview
        if (root == null) return false;

        pathTillNode.add(root);
        if (root.val == value) return true;


        boolean left = printRootToNodePath(root.left, value, pathTillNode);
        boolean right = printRootToNodePath(root.right, value, pathTillNode);

        if (left || right) return true;

        pathTillNode.remove(pathTillNode.size() - 1);
        return false;


    }
}
