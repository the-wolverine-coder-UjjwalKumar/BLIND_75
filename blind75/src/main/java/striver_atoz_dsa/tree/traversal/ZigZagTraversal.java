package striver_atoz_dsa.tree.traversal;

import striver_atoz_dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();
        List<List<Integer>> traversal = new LinkedList<>();

        zigZagTraversal(root, traversal);
        System.out.println(traversal);
    }

    private static void zigZagTraversal(TreeNode root, List<List<Integer>> traversal) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;

        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int n = queue.size();
            Integer[] tmp = new Integer[n];

            for (int i = 0; i < n; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left!=null) queue.offer(currNode.left);
                if (currNode.right!=null) queue.offer(currNode.right);

                // insert in specific index
                int index = (!flag) ? i : n - i -1 ;
                tmp[index] = currNode.val;
            }

            // flip the flag & append answer
            flag = !flag;
            traversal.add(List.of(tmp));
        }
    }
}
