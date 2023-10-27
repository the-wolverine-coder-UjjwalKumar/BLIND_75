package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
//        TreeNode root = DFS_Traversal.getTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        // Maximum width of BT
        //  Width for a level is defined as the maximum number of nodes between the
        //  leftmost and rightmost node of the level(including the end nodes and the null nodes between the end nodes).

        int maxWidth = getMaximumWidth(root);
        System.out.println("Maximum width :: " + maxWidth);
    }

    private static int getMaximumWidth(TreeNode root) {
        // if we can do the indexing of all the nodes at each level then
        // we can find out the width = (right-left+1)
        // if we use 0 based indexing then root is at i,
        // then left child will be at 2i+1, right child will be at 2i+2
        // similarly if we go with 1 based indexing then root ia at i,
        // left will be at 2i and right will be at 2i+1
        // but here the above approach may lead to the bound of an integer
        // so we can do a smart hack, will try to allot the root node every time possibly 0
        // so root = currIndex - minIndex at that level.

        if(root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));


        while (!queue.isEmpty()) {
            int size = queue.size();
            int mmin = queue.peek().index;    //to make the id starting from zero
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int curRootIndex = queue.peek().index - mmin;
                TreeNode node = queue.peek().node;
                queue.poll();
                if (i == 0) first = curRootIndex;
                if (i == size - 1) last = curRootIndex;
                if (node.left != null)
                    queue.offer(new Pair(node.left, curRootIndex * 2 + 1));
                if (node.right != null)
                    queue.offer(new Pair(node.right, curRootIndex * 2 + 2));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;

    }

    static class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }

        TreeNode getNode() {
            return this.node;
        }

        int getIndex() {
            return this.index;
        }
    }
}
