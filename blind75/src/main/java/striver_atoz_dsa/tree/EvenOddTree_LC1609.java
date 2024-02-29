package striver_atoz_dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree_LC1609 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(10);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);

        root.right.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(2);


        boolean ans = isEvenOddTree(root);
        System.out.println(ans);
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int val = level%2== 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode!=null) {
                    if (level%2==0) {
                        // even level , odd number & inc order
                        if (currNode.val%2==0 || val >= currNode.val) return false;

                    } else {
                        // odd level , even number & dec order
                        if (currNode.val%2!=0 || val <= currNode.val) return false;
                    }

                    val = currNode.val;

                    if (currNode.left!=null) queue.add(currNode.left);
                    if (currNode.right!=null) queue.add(currNode.right);
                }

            }
            level++;
        }

        return true;

    }
}
