package striver_atoz_dsa.tree.view;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;
import striver_atoz_dsa.tree.TreeNode;

import java.util.*;

public class TopView_BT {
    static class Tuple {
        TreeNode node;
        int vertical;
        int level;

        public Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }

        public TreeNode getNode() { return this.node; }
        public int getVertical() { return this.vertical; }
        public int getLevel() { return this.level; }

    }

    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        // Here we have to print the top view,
        // If node at same level overlaps then pick the value from left to right
        List<Integer> topView = new LinkedList<>();
        topView(root, topView);
        System.out.println("Top View :: "+topView);

    }

    private static void topView(TreeNode root, List<Integer> topView) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            // fetching the values from tuple pooled from QUEUE
            TreeNode node = tuple.getNode();
            int vertical = tuple.getVertical();
            int level = tuple.getLevel();

            if (!map.containsKey(vertical)) {
                map.put(vertical, node.val);
            }

            if (node.left!=null) {
                queue.offer(new Tuple(node.left, vertical - 1, level+1));
            }
            if (node.right!=null) {
                queue.offer(new Tuple(node.right, vertical +1, level+1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            topView.add(entry.getValue());
        }
    }
}
