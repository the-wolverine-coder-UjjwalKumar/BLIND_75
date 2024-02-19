package algorithm.slidingwindow.fixed;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2,5,1,8,2,9,1};
        int k = 3;

        // find out the max sum of subarray of size k
        int ans = getMaxSumSubarrayBruteForce(arr, k);
        System.out.println("Simple Call "+ans);

        int ans1 = getMaxSumSubarraySlidingWindow(arr, k);
        System.out.println("Impl using for "+ans1);

        int ans2 = getMaxSumSubarraySlidingWindowImpl1(arr, k);
        System.out.println("Impl using while "+ans2);
    }

    private static int getMaxSumSubarraySlidingWindowImpl1(int[] arr, int k) {
        int ans = Integer.MIN_VALUE;
        int windowSum = 0;

        int i = 0; // window start
        int j = 0; // window end

        while ( j < arr.length) {
            windowSum += arr[j];

            if (j - i + 1 >= k) {
                // window size hits
                ans = Math.max(ans, windowSum);
                windowSum -= arr[i];
                i++;
            }
            j++;
        }

        return ans;

    }

    private static int getMaxSumSubarraySlidingWindow(int[] arr, int k) {
        int ans = 0;
        int windowSum = 0;

        // set up first window of size k
        for (int i = 0; i < k; i++)
            windowSum += arr[i];


        for (int i = 1; i <= arr.length - k; i++) {
            windowSum = windowSum - arr[i - 1] + arr[i+k-1];
            ans = Math.max(ans, windowSum);
        }

        return ans;

    }

    private static int getMaxSumSubarrayBruteForce(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < arr.length - k; i++) {
            int temp = 0;
            for (int j = i; j < i+k; j++) {
                temp += arr[j];
            }
            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
