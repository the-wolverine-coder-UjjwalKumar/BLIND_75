package striver_atoz_dsa.tree.view;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;
import striver_atoz_dsa.tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
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

        List<List<Integer>> verticalOrder = new LinkedList<>();

        printVerticalOrderTraversal(root, verticalOrder);
        System.out.println("Vertical order of BT :: "+verticalOrder);
    }

    private static void printVerticalOrderTraversal(TreeNode root, List<List<Integer>> verticalOrder) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));

        // ds to collect the answer
        // map<vertical,map<level,pq<Int>>>
        TreeMap<Integer,TreeMap<Integer,PriorityQueue <Integer>>> map = new TreeMap <> ();

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            // fetching the values from tuple pooled from QUEUE
            TreeNode node = tuple.getNode();
            int vertical = tuple.getVertical();
            int level = tuple.getLevel();

            // initialization of map to hold answer
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap <> ());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue <> ());
            }

            // appending the node value
            map.get(vertical).get(level).offer(node.val);

            // adding tuple to queue with it's left and right value if exists
            if (node.left != null) {
                queue.offer(new Tuple(node.left, vertical - 1, level + 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, vertical + 1, level + 1));
            }

        }

        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            verticalOrder.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    verticalOrder.get(verticalOrder.size() - 1).add(nodes.poll());
                }
            }
        }

    }
}
