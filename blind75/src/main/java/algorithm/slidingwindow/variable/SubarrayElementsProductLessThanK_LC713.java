package algorithm.slidingwindow.variable;

public class SubarrayElementsProductLessThanK_LC713 {

    public static void main(String[] args) {
        int[] arr = {10,5,2,6};
        int k = 100;
        int ans = numSubarrayProductLessThanK(arr, k);
        System.out.println(ans);

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        // sliding window
        if(k<=1) return 0;
        int left = 0, right = 0, prod = 1, ans = 0;
        while(right<nums.length) {
            prod = prod * nums[right];
            while(prod >= k) {
                prod = prod/nums[left];
                left++;
            }
            ans = ans + (right - left + 1);
            right++;
        }
        return ans;
    }
}
