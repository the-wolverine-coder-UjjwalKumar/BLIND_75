package blind_75_questions.array;

import java.util.Arrays;

public class ProductOfArrayExceptItself_LC238_07 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        int[] ans = getProductExceptItselfBruteForce(arr, n);
        System.out.println(Arrays.toString(ans));

        // Follow up -1 : please solve it without using division and O(n) space
        int[] ans1 = getProductExceptItself(arr, n);
        System.out.println(Arrays.toString(ans1));

        // Follow up -2: can we do it in constant space
        int[] ans2 = getProductExceptItselfOptimal(arr,n);
        System.out.println(Arrays.toString(ans2));

    }

    // do it in constant space
    private static int[] getProductExceptItselfOptimal(int[] arr, int n) {
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * arr[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * arr[i + 1];
            res[i] *= right;
        }
        return res;
    }

    // rute Force : TC -O(n) & SC : O(n) aux.space to store ans
    private static int[] getProductExceptItselfBruteForce(int[] arr, int n) {
        int[] ans = new int[n];
        int mul = 1;
        for (int i = 0; i< n;i++){
            mul *= arr[i];
        }

        for (int i = 0; i< n;i++){
           if (arr[i] != 0)
               ans[i] = mul / arr[i];
           else
               ans[i] = 0;
        }

        return ans;
    }

    // Brute force : TC : O(n^2) & SC : O(n)
    private static int[] getProductExceptItself(int[] arr, int n) {
        int[] ans = new int[n];
        for (int i = 0; i< n;i++){
            int tempMul = 1;
            for (int j = 0; j < n; j++) {
                if (i!=j)
                    tempMul *= arr[j];
            }
            ans[i] = tempMul;
        }
        return ans;
    }
}
