package algorithm.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithKFrequencyElement_LC2958 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3,1,2};
        int k = 2;

        int[] arr1 = {1,2,1,2,1,2,1,2};
        int k1 = 1;

        int ans = maxSubarrayLength(arr1, k1);
        System.out.println(ans);
    }

    public static int maxSubarrayLength(int[] arr, int k) {
        int ans = 0;
        int i = 0;
        int j = 0;

        Map<Integer,Integer> map = new HashMap<>();

        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            while (map.get(arr[j]) > k) {
                map.put(arr[i], map.get(arr[j])-1);
                i++;
            }
            ans = Math.max(j-i+1, ans);
            j++;
        }
        return ans;
    }
}
