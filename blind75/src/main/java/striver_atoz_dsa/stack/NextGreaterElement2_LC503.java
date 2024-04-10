package striver_atoz_dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2_LC503 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};

        int[] ans = nextGreaterElements(arr);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 2*n -1; i>=0; i--) {

            // maintaining the inc order in stack
            while (!stack.isEmpty() && nums[i%n] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                } else {
                    ans[i] = -1;
                }
            }

            stack.push(nums[i%n]);

        }

        return ans;
    }

}
