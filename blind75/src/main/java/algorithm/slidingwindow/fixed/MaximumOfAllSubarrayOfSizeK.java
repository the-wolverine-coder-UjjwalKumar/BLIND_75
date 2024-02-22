package algorithm.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaximumOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3, 5,3,6,7};
        int k = 3;

        List<Integer> ans = getMaxOfSubarrayK(arr, k);
        System.out.println(ans);
    }

    private static List<Integer> getMaxOfSubarrayK(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        if (arr.length==0 || k > arr.length)
            return ans;

        int i = 0;
        int j = 0;
        int maxTillNow = Integer.MIN_VALUE;
        while (j < arr.length) {

            maxTillNow = Math.max(maxTillNow, arr[j]);

            if (j-i+1 >= k) {
                ans.add(maxTillNow);
                i++;
            }


            j++;
        }

        return ans;

    }
}
