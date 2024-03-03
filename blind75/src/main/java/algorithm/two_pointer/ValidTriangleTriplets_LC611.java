package algorithm.two_pointer;

import java.util.Arrays;

public class ValidTriangleTriplets_LC611 {
    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        int ans = getCountOfTriangleTriplets(nums);
        System.out.println(ans);
    }

    private static int getCountOfTriangleTriplets(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int ans = 0;
        Arrays.sort(arr);
        for (int j = 2; j < n; j++) {
            int left = 0;
            int right = j - 1;

            while (left < right ) {
                if (arr[left] + arr[right] >= arr[j]) {
                    ans += (right-left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;

    }
}
