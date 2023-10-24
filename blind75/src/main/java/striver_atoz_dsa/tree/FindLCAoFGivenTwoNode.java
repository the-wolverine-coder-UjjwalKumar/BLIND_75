package striver_atoz_dsa.tree;

import striver_atoz_dsa.tree.traversal.DFS_Traversal;

import java.util.LinkedList;
import java.util.List;

public class FindLCAoFGivenTwoNode {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        TreeNode root = DFS_Traversal.getTree();
        int node1 = 7;
        int node2 = 6;

        //getLCAUsingBruteForce(root, node1, node2);

        // optimized method
        TreeNode lca = getLCA(root, node1, node2);
        if (lca!=null)
            System.out.println("Ancestor :: "+lca.val);



    }

    private static TreeNode getLCA(TreeNode root, int node1, int node2) {
        //base case
        if (root == null || root.val == node1 || root.val == node2) {
            return root;
        }

        TreeNode left = getLCA(root.left, node1, node2);
        TreeNode right = getLCA(root.right, node1, node2);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }

    private static void getLCAUsingBruteForce(TreeNode root, int node1, int node2) {
        // BruteForce :
        // build the list from root to node for both the given node
        // start comparing the list values until the last values are not same.
        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();

        boolean isNode1Present = getPathFromRootToNode(root, node1, path1);
        boolean isNode2Present = getPathFromRootToNode(root, node2, path2);

        if (isNode1Present && isNode2Present) {
            int ancestor = -1;
            int i=0,j=0;
            while (i < path1.size() && j < path2.size()) {
                if (path1.get(i)!=path2.get(j)) {
                    ancestor = path1.get(i-1).val;
                    break;
                }
                i++;j++;
            }

            System.out.println("Ancestor :: "+ancestor);
        }
    }

    private static boolean getPathFromRootToNode(TreeNode root, int value, List<TreeNode> pathTillNode) {
        // we can use any traversal but Inorder will have simple code hence easy to explain in interview
        if (root == null) return false;

        pathTillNode.add(root);
        if (root.val == value) return true;


        boolean left = getPathFromRootToNode(root.left, value, pathTillNode);
        boolean right = getPathFromRootToNode(root.right, value, pathTillNode);

        if (left || right) return true;

        pathTillNode.remove(pathTillNode.size() - 1);
        return false;

    }
}
