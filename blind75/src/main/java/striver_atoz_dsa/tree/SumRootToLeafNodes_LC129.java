package striver_atoz_dsa.tree;

public class SumRootToLeafNodes_LC129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

//        TreeNode root = new TreeNode(1);
//        root.right  = new TreeNode(2);

        int ans = sumNumbers(root);
        System.out.println(ans);
    }


    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;

//        return helper(root, new StringBuilder(), 0);
        return helper(root, 0, 0);
    }

    public static int helper(TreeNode root, int sum, int total) {
        if (root == null) return 0;

        sum = sum*10 + root.val;

        if (root.left == null && root.right == null) {
            total += sum;
            return total;
        }

        return helper(root.left, sum, total) + helper(root.right, sum, total);


    }

    public static int helper(TreeNode node, StringBuilder sb, int sum) {

        if (node == null) return sum;

        sb.append(node.val);

        if (node.left==null && node.right==null) {
            sum += Integer.parseInt(sb.toString());
            System.out.println(sb);
            return sum;
        }

        int left = 0;
        int right = 0;

        if (node.left!=null) {
            left = helper(node.left, sb, sum);
            sb.deleteCharAt(sb.length()-1);
        }

        if (node.right!=null) {
            right = helper(node.right, sb, sum);
            sb.deleteCharAt(sb.length()-1);
        }

        sum += left;
        sum += right;

        return sum;

    }

}
