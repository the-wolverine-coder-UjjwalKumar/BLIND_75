package striver_atoz_dsa.tree;

public class CountNodeEqualToAverageValueOfSubtree {
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        solve(root, 0);
        return ans;
    }

    int ans = 0;

    private int[] solve(TreeNode root, int count) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int left[] = solve(root.left, count);
        int right[] = solve(root.right, count);
        int temp = root.val;
        root.val += (left[0] + right[0]);
        count = (left[1] + right[1]) + 1;
        if (temp == (root.val / count)) ans++;
        return new int[]{root.val, count};
    }
}
