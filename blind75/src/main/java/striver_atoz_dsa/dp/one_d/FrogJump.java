package striver_atoz_dsa.dp.one_d;

public class FrogJump {
    public static void main(String[] args) {
        int n = 4;
        int[] heights = {10,20,30,10};
        int energyConsumed = Integer.MAX_VALUE;

        int ans = getEnergyReqToReachTarget(n, heights, energyConsumed);
        System.out.println(ans);
    }

    private static int getEnergyReqToReachTarget(int n, int[] heights, int energyConsumed) {
        if (n == 1) return heights[n];

        // pick one-step
        energyConsumed = Math.min(energyConsumed, Math.abs(heights[n] - heights[n-1]));
        // pick two-step
        energyConsumed = Math.min(energyConsumed, Math.abs(heights[n] - heights[n-2]));

        return energyConsumed;

    }
}
