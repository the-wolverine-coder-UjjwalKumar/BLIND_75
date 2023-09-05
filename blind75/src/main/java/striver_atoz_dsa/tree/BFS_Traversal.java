package striver_atoz_dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {
    public static void main(String[] args) {
        Node root = DFS_Traversal.getTree();

        printBFSTraversal(root);
    }

    private static void printBFSTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data+" ");

            if (currentNode.left != null)
                queue.add(currentNode.left);

            if (currentNode.right != null)
                queue.add(currentNode.right);
        }

    }
}
