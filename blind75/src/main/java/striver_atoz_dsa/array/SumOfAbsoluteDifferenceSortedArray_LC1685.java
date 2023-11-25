package striver_atoz_dsa.array;

import java.util.Arrays;

public class SumOfAbsoluteDifferenceSortedArray_LC1685 {
    public static void main(String[] args) {
        int[] arr = {1,4,6,8,10};
        int[] ans = getSumAbsoluteDifferences(arr);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < n; ++i) {
            res[i] = i * nums[i] - prefixSum[i] + (prefixSum[n] -  prefixSum[i] - (n - i) * nums[i]);
        }
        return res;
    }

    public int[] getSumAbsoluteDifferences_LCEditorial(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[n - 1] - prefix[i];

            int leftCount = i;
            int rightCount = n - 1 - i;

            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];

            ans[i] = leftTotal + rightTotal;
        }

        return ans;
    }


    public static int[] getSumAbsoluteDifferencesBrute(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            int eleAns = 0;
            for (int j = 0; j < nums.length; j++) {
                eleAns += Math.abs(nums[i] - nums[j]);
            }
            ans[i] = eleAns;
        }

        return ans;
    }
}
