package algorithm.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class ContiguousBinarySubArray_LC525 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 1, 0, 0};
        int[] arr1 = {0, 1, 1, 1, 1, 0, 0};
        int ans = findMaxLength(arr1);
        System.out.println(ans);
    }

    public static int findMaxLength(int[] nums) {
        if (nums.length <= 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return ans;
    }

    public int findMaxLength1(int[] nums) {
        Map<Integer, Integer> stateToFirstIndex = new HashMap<>();
        int state = 0;
        int maxLength = 0;
        stateToFirstIndex.put(state, -1);
        for (int i = 0; i < nums.length; i++) {
            state += (nums[i] == 0 ? -1 : 1);

            Integer firstIndex = stateToFirstIndex.get(state);
            if (firstIndex != null) {
                // found one subarray [firstIndex...i]
                maxLength = Math.max(maxLength, i - firstIndex);
            } else {
                stateToFirstIndex.put(state, i);
            }
        }

        return maxLength;
    }
}
