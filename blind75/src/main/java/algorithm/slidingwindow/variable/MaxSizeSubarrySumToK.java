package algorithm.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarrySumToK {
    public static void main(String[] args) {
        int[] arr = {4,1,1,1,2,3,5};
        int k = 5;

        int[] arr1 = {4,1,1,-2,1,3,5};
        int k1 = 5;


        // return the max length of subarray whose sum equals to K
        int ans = getSubarraySumK(arr, k);
        System.out.println(ans);
    }

    private static int getSubarraySumK(int[] arr, int k) {
        int ans = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;

        while (j < arr.length) {
            sum += arr[j];

            if (sum == k) {
                ans = Math.max(ans, j-i+1);
            } else if (sum > k) {
                while (sum > k && i < arr.length) {
                    sum -= arr[i];
                    i++;
                }
            }

            j++;

        }
        return ans;
    }

    // handle negative cases
    public static int maxSubarraySum(int[] nums, int k) {
        int maxLen = 0;
        int currSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (sumMap.containsKey(currSum - k)) {
                maxLen = Math.max(maxLen, i - sumMap.get(currSum - k));
            }

            // Store the first occurrence of the current cumulative sum
            if (!sumMap.containsKey(currSum)) {
                sumMap.put(currSum, i);
            }
        }

        return maxLen;
    }
}
