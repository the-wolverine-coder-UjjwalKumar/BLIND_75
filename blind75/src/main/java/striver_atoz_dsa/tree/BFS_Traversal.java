package striver_atoz_dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {
    public static void main(String[] args) {
        TreeNode root = DFS_Traversal.getTree();

        printBFSTraversal(root);
    }

    private static void printBFSTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentTreeNode = queue.poll();
            System.out.print(currentTreeNode.val +" ");

            if (currentTreeNode.left != null)
                queue.add(currentTreeNode.left);

            if (currentTreeNode.right != null)
                queue.add(currentTreeNode.right);
        }

    }
}
