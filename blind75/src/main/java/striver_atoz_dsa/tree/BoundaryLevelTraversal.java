package striver_atoz_dsa.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BoundaryLevelTraversal {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();

        printBoundaryLevelTraversal(root);
    }

    private static void printBoundaryLevelTraversal(TreeNode root) {
        // Boundary traversal anti-clock wise
        // print root,
        // print left boundary excluding leaf nodes
        // print right boundary excluding leaf in reverse order
        List<Integer> boundaryTraversal = new LinkedList<>();

        if (root == null) {
            System.out.println(boundaryTraversal);
            return;
        }

        // add initial root
        boundaryTraversal.add(root.val);

        // collecting left most boundary (excluding leaf node & initial root)
        addLeftBoundary(root, boundaryTraversal);

        // collecting leaf node, inorder traversal
        addLeafNodes(root, boundaryTraversal);

        // collecting the right boundary node (excluding leaf nodes & initial root)
        addRightBoundary(root, boundaryTraversal);

       // printing the traversal
        System.out.println(boundaryTraversal);


    }

    private static void addLeftBoundary(TreeNode root, List<Integer> boundaryTraversal) {

        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) boundaryTraversal.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }

    }

    private static void addLeafNodes(TreeNode root, List<Integer> boundaryTraversal) {

        if (isLeaf(root)) {
            boundaryTraversal.add(root.val);
            return;
        }

        if (root.left!=null) addLeafNodes(root.left, boundaryTraversal);
        if (root.right!=null) addLeafNodes(root.right, boundaryTraversal);

    }

    private static void addRightBoundary(TreeNode root, List<Integer> boundaryTraversal) {
        // here we have to add the right boundary in reverse order hence we are using stack as it is LIFO.
        Stack<Integer> rightBoundary = new Stack<>();
        TreeNode curr = root.right;

        while (curr!=null) {
            if (!isLeaf(curr)) rightBoundary.push(curr.val);

            if (curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }

        while (!rightBoundary.isEmpty()) {
            boundaryTraversal.add(rightBoundary.pop());
        }
    }


    private static boolean isLeaf(TreeNode cur) {
        return cur!=null && cur.left==null && cur.right==null;
    }
}
