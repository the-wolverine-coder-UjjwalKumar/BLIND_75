package striver_atoz_dsa.tree;

public class SymmetricalTree {
    public static void main(String[] args) {

        //       1
        //      / \
        //     2   2
        //    /\   /\
        //   3  4 4  3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean isSymmetrical = checkSymmetrical(root);
        System.out.println("Tree 1 isSymmetrical : "+isSymmetrical);


        //      1
        //     /  \
        //    2    2
        //     \    \
        //      3    3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);

        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);

        boolean isSymmetrical1 = checkSymmetrical(root1);
        System.out.println("Tree 2 isSymmetrical : "+isSymmetrical1);
    }

    private static boolean checkSymmetrical(TreeNode root) {
        if (root==null) return false;

        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode root1, TreeNode root2) {
        // we can use any traversal here using InOrder
        // root left right -> <- root right left (in terms of mirror by root view)
        if (root1 == null || root2 == null) return root1 == root2;

        if (root1.val != root2.val) return false;
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);

    }
}
