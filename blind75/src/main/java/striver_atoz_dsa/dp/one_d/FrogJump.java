package striver_atoz_dsa.dp.one_d;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10,20,30,10};

        int ans = getEnergyReqToReachTarget(n-1, heights);
        System.out.println(ans);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans1 = getEnergyReqToReachTargetMemoized(n-1, heights, dp);
        System.out.println(ans1);

        int ans2 = getEnergyReqToReachTargetTabulation(n-1, heights);
        System.out.println(ans2);

    }



    // RC solution
    private static int getEnergyReqToReachTarget(int n, int[] heights) {
        if (n == 0) return 0;

        int twoJumpEnergyReq = Integer.MAX_VALUE;
        int oneJumpEnergyReq = getEnergyReqToReachTarget(n-1, heights) + Math.abs(heights[n] - heights[n-1]);

        if (n > 1)
            twoJumpEnergyReq =  getEnergyReqToReachTarget(n-2, heights) + Math.abs(heights[n] - heights[n-2]);

        return Math.min(oneJumpEnergyReq, twoJumpEnergyReq);
    }

    // Memoized DP
    private static int getEnergyReqToReachTargetMemoized(int n, int[] heights, int[] dp) {

        if (dp[n]!= -1) return dp[n];

        int oneJumpEnergyReq = getEnergyReqToReachTargetMemoized(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int twoJumpEnergyReq = Integer.MAX_VALUE;
        if (n > 1)
            twoJumpEnergyReq = getEnergyReqToReachTargetMemoized(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);

        dp[n] = Math.min(oneJumpEnergyReq, twoJumpEnergyReq);
        return dp[n];

    }

    // DP Tabulation
    private static int getEnergyReqToReachTargetTabulation(int n, int[] heights) {
        int[] dp  = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++ ) {
            int oneJumpEnergyReq = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int twoJumpEnergyReq = Integer.MAX_VALUE;
            if (i > 1)
                twoJumpEnergyReq = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(oneJumpEnergyReq, twoJumpEnergyReq);
        }


        return dp[n-1];

    }


}
