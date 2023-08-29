package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayWithGivenSum_GFG {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int s = 12;
        int n = arr.length;

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int s1 = 15;
        int n1 = arr1.length;

        int[] arr2 = {1,2,3,4};
        int s2 = 15;
        int n2 = arr2.length;

        int[] arr3 = {1,2,3,7,5};
        int s3 = 12;
        int n3 = arr3.length;

        ArrayList<Integer> ans = getSubarraySumEqualK(arr, n, s);
        System.out.println(ans);

        ArrayList<Integer> ans1 = getSubarraySumEqualK(arr1, n1, s1);
        System.out.println(ans1);

        ArrayList<Integer> ans2 = subarraySum(arr1, n1, s1);
        System.out.println(ans2);

        ArrayList<Integer> ans3 = subarraySum(arr2, n2, s2);
        System.out.println(ans3);

        ArrayList<Integer> ans4 = subarraySum(arr3, n3, s3);
        System.out.println(ans4);
    }

    // BruteForce : TC : O(N^2) & SC O(1)
    private static ArrayList<Integer> getSubarraySumEqualK(int[] arr, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i ; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                   ans.add(i+1);
                   ans.add(j+1);
                    return ans;
                }
            }
        }

        ans.add(-1);
        return ans;
    }

    // Better Approach : TC : O(n) SC : O(1)
    private static ArrayList<Integer> subarraySum(int[] arr, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        int currSum = arr[0];
        int left = 0, right = 0;
        boolean isFound = false;

        if (k == 0) {
            ans.add(-1);
            return ans;
        }

        while ( right < n) {
            if (currSum == k) {
                isFound = true;
                break;
            }

            if (currSum < k ) {
                right++;
                if (right < n) currSum += arr[right];
            } else {
                currSum -= arr[left];
                left++;
            }
        }

        if (isFound) {
            ans.add(left + 1);
            ans.add(right+1);
            return ans;
        } else {
            ans.add(-1);
        }

        return ans;
    }

}
