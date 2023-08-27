package blind_75_questions.array;

import java.util.Arrays;

public class MajorityElement_LC169_03 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int[] arr1 = {3,2,3};
        int n = arr1.length;

        // gt majority element greater than n/2;
        int ans = getMajorityElement(arr1, n);
        int ans1 = getMajorityElementBetter(arr, arr.length);
        int ans2 = getMajorityElementMooresAlgo(arr, arr.length);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    // Brute force TC : O(n^2) & SC : O(1)
    private static int getMajorityElement(int[] arr, int n) {
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            ans = arr[i];
            for (int j = i+1 ; j< n ; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;

                    if (cnt > n/2)
                        return ans;
                }
            }
        }

        return ans;
    }

    // Better Approach TC : (NlogN + n/2) & SC : O(1)
    private static int getMajorityElementBetter(int[] arr, int n) {
        Arrays.sort(arr);

        int majority = arr[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == majority) {
                cnt++;
            } else {
                cnt = 1;
                majority = arr[i];
            }

            if (cnt > n/2)
                return majority;

        }

        return -1;
    }

    // Optimal approach : TC O(n + n/2) & SC O(1)
    private static int getMajorityElementMooresAlgo(int[] arr, int n) {
        // Apply Moore Voting algo to get the element
        // verify is it really a answer

        int majorityElement = -1;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                majorityElement = arr[i];
                cnt = 1;
            } else if (majorityElement == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }

        }

        int verifyCount = 0;
        for (int ele : arr) {
            if (ele == majorityElement)
                verifyCount++;

            if (verifyCount > n/2)
                return majorityElement;
        }

        return -1;
    }
}
