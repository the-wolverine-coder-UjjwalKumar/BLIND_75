package striver_atoz_dsa.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_LC496 {
    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        int[] num3 = {3,10,4,2,1,2,6,1,7,2,9};

        int[] ans = nextGreaterElement(num1, num2);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        int[] ans = new int[nums1.length];

        for (int i = n -  1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    map.put(nums2[i], stack.peek());
                } else {
                    map.put(nums2[i], -1);
                }

            } else {
                stack.push(nums2[i]);
                map.put(nums2[i], -1);
            }

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
