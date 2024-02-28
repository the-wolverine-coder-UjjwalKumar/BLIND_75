package striver_atoz_dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftmostTreeValue_LC513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);

        int ans = findBottomLeftValue(root);
        System.out.println(ans);


    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = -1;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            ans = queue.peek().val;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }

        return ans;

    }

    public static int findBottomLeftValueOptimized(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = root;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return node.val;
    }

    public int findBottomLeftValueR(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        return res[0];
    }
}
