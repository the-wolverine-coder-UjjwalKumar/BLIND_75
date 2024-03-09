package algorithm.two_pointer;

import java.util.Arrays;

public class Three3SumClosest_LC16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        int[] nums1 = {0,0,0,0};
        int target1 = 1;

        int ans = threeSumClosest(nums, target);
        System.out.println(ans);
    }

    public static int threeSumClosest(int[] num, int target) {
        int closestSumSoFar = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int currSum = num[i] + num[start] + num[end];
                if (currSum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(currSum - target) < Math.abs(closestSumSoFar - target)) {
                    closestSumSoFar = currSum;
                }
            }
        }
        return closestSumSoFar;
    }
}
