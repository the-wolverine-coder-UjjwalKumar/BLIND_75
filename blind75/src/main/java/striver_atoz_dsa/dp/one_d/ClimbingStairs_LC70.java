package striver_atoz_dsa.dp.one_d;

import java.util.Arrays;

public class ClimbingStairs_LC70 {
    public static void main(String[] args) {
        int n = 5; // steps to climb
        int ans = getNumOfWaysToClimb(n);
        System.out.println(ans);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        int ans1 = getNumOfWaysToClimbMemoized(n, dp);
        System.out.println(ans1);

        int[] dp1 = new int[n+1];
        Arrays.fill(dp1, -1);
        dp1[0] = 1;
        dp1[1] = 1;

        int ans3 = getNumOfWaysToClimbTopDown(n);
        System.out.println(ans3);

    }

    // RC code
    private static int getNumOfWaysToClimb(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        return getNumOfWaysToClimb(n-1)+getNumOfWaysToClimb(n-2);
    }

    // DP memoized code
    private static int getNumOfWaysToClimbMemoized(int n, int[] dp) {
        if (n == 0 || n == 1) return dp[n];

        if (dp[n]!= -1) return dp[n];

        int ans = getNumOfWaysToClimbMemoized(n-1, dp) + getNumOfWaysToClimbMemoized(n-2, dp);
        dp[n] = ans;
        return dp[n];
    }

    // DP top-down
    private static int getNumOfWaysToClimbTopDown(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

}
