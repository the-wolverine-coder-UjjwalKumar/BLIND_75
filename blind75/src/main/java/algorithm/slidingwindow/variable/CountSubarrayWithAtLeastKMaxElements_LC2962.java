package algorithm.slidingwindow.variable;

import java.util.Arrays;

public class CountSubarrayWithAtLeastKMaxElements_LC2962 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,3};
        int k = 2;

        long ans = countSubarrays(arr, k);
        System.out.println(ans);

    }

    public static long countSubarrays1(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int maxC = 0;

        for (int value : arr) {
            if (max <= value) {

                if (max == value) {
                    maxC += 1;
                } else {
                    maxC = 1;
                }

                max = value;
            }
        }

        System.out.println(max);
        System.out.println(maxC);

        long ans = 0;
        int i = 0;
        int j = 0;

        return ans;

    }

    public static long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int l = 0,r=0,n=nums.length;

        while (r < n) {
            k -= nums[r] == mx ? 1 : 0;
            r++;
            while (k == 0) {
                k += nums[l] == mx ? 1 : 0;
                l++;
            }
            ans += l;
        }

        return ans;
    }

    public static long countSubarrays2(int[] nums, int k) {
        long res = 0;
        int max = 0, count = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                if (nums[l++] == max)
                    count--;
            }
            res += l;
        }
        return res;
    }

}
