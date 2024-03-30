package algorithm.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithAtmostKDistinctElements_LC992 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        int ans = subarraysWithKDistinct(arr, k);
        System.out.println(ans);
    }

    public static int subarraysWithKDistinct(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);

            // we expect the ans
            while (i <= j && map.size() > k) {
                map.put(arr[i], map.getOrDefault(arr[i], 0)-1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                i++;
            }

            ans += (j - i + 1);
            j++;
        }
        return ans;
    }

    public int subarraysWithKDistinct1(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }

    public int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            ans += right - left + 1; // Size of subarray
            right++;
        }

        return ans;
    }
}
