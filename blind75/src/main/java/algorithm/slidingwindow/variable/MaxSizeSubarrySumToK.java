package algorithm.slidingwindow.variable;

public class MaxSizeSubarrySumToK {
    public static void main(String[] args) {
        int[] arr = {4,1,1,1,2,3,5};
        int k = 5;

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
                sum -= arr[i];
                i++;
            }

            j++;
        }
        return ans;
    }
}
