package striver_atoz_dsa.tree;

public class BalancedBT_LC110 {
    public static void main(String[] args) {
        //       1
        //      / \
        //    2     3
        //   / \   / \
        //  4   5 7   8
        //     /     / \
        //     6    9  10
        Node root = DFS_Traversal.getTree();

        int balancedTree = checkIfBalanced(root);
        if (balancedTree!=-1)
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static int checkIfBalanced(Node root) {
        if (root == null) return  0;

        int leftH = checkIfBalanced(root.left);
        int rightH = checkIfBalanced(root.right);

        if (Math.abs(leftH - rightH) <= 1)
            return 1 + Math.max(leftH, rightH);
        else
            return -1;
    }
}
