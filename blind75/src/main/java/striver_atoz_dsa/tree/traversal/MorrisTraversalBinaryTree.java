package striver_atoz_dsa.tree.traversal;

import striver_atoz_dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MorrisTraversalBinaryTree {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        // Morris Traversal : it uses te concept of binary threaded tree and do the traversal in O(n) TC nd O(1_ SC.
        List<Integer> inOrder = new LinkedList<>();
        List<Integer> ans = getInOrderUsingMorisTraversal(root, inOrder);
        System.out.println(ans);
        List<Integer> preOrder = getPreOrderViaMorisTraversal(root, new LinkedList<>());
        System.out.println("Preorder :: " + preOrder);


    }

    private static List<Integer> getInOrderUsingMorisTraversal(TreeNode root, List<Integer> inorder) {

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                // threading will be done at the rightmost node of left node
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                // making thread
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }

    private static List<Integer> getPreOrderViaMorisTraversal(TreeNode root, List<Integer> preOrder) {
        if (root == null) return preOrder;

        TreeNode curr = root;
        while (curr != null) {

            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right != null) {
                    prev.right = null;
                    curr = curr.right;
                } else {
                    prev.right = curr;
                    preOrder.add(curr.val);
                    curr = curr.left;
                }

            } else {
                preOrder.add(curr.val);
                curr = curr.right;
            }
        }
        return preOrder;
    }


}
