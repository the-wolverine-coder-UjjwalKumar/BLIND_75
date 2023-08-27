package striver_atoz_dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_LC1_01 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));


    }

    // Brute force TC : O(n^2) SC : Aux space O(2)
    public static int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);


        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((target - arr[j] == arr[i])) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    // Optimized one TC : O(n) , SC : O(n)
    public int[] twoSumHashMap(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }


}
