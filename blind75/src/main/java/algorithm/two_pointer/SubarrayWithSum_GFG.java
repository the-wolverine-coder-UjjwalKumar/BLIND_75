package algorithm.two_pointer;

import java.util.ArrayList;

public class SubarrayWithSum_GFG {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int s = 12;

        int[] arr1 = {0};
        int s1 = 0;

        int[] arr2 = {1,4,5,6,0};
        int s2 = 0;

        ArrayList<Integer> ans = subarraySum1(arr2, arr2.length, s2);
        if (!ans.isEmpty())
            System.out.println(ans);
        else
            System.out.println("-1");
    }
    static ArrayList<Integer> subarraySum1(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int start = 0, end = n, currSum = 0;
        int i = 0;

        while (start < end) {

            currSum += arr[start];

            if (currSum >= s) {
                int last = start;

                while (s < currSum && i < last) {
                    currSum -= arr[i];
                    ++i;
                }

                if (currSum == s) {
                    ans.add(i + 1);
                    ans.add(last + 1);
                    break;
                }
            }

            start++;

        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean isFound = false;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == s) {
                    ans.add(i+1);
                    ans.add(j+1);
                    isFound = true;
                    break;
                } else if (sum > s) {
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        if (!isFound) {
            ans.add(-1);
        }

        return ans;
    }
}
