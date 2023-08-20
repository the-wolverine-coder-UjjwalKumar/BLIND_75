package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementNBy3_LC229_04 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,2,2,2};
        int n = arr.length;

        int[] ans = getMajorityElementNBy3(arr, n);
        System.out.println(Arrays.toString(ans));

        int[] ans2 = getMajorityElementBetterApp(arr,n);
        System.out.println(Arrays.toString(ans2));

        int[] ans3 = getMajorityElementByBoyerMooreAlgo(arr,n);
        System.out.println(Arrays.toString(ans3));
    }

    // Brute Force TC : O(N^2) & SC O(1)
    private static int[] getMajorityElementNBy3(int[] arr, int n) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int minOccur = (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i]==arr[j]) {
                    cnt++;
                }

                if (cnt >= minOccur ) {
                    if (ans[0]==-1)
                        ans[0] = arr[i];
                    if (ans[1]==-1 && ans[0]!=arr[i])
                        ans[1] = arr[i];
                }

            }
        }
        Arrays.sort(ans);
        return ans;
    }

    // Better Approach : TC : O(n) & SC : O(n)
    private static int[] getMajorityElementBetterApp(int[] arr, int n) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int minOccur = (n/3)+1;

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cnt = map.getOrDefault(arr[i], 0);
            cnt++;
            map.put(arr[i],cnt);

            // check if cnt is equal to minOccur put it in ans
            if (cnt >= minOccur) {
                if (ans[0]==-1) {
                    ans[0] = arr[i];
                } else if (ans[1]==-1) {
                    ans[1] = arr[i];
                }
            }
        }

        Arrays.sort(ans);
        return ans;

    }

    // Optimal Approach
    private static int[] getMajorityElementByBoyerMooreAlgo(int[] arr, int n) {
         int ele1 = -1;
         int ele2 = -1;
         int cnt1 = 0;
         int cnt2 = 0;


         for (int i = 0; i < n; i++) {
             if (cnt1 == 0 && ele2 != arr[i]) {
                 ele1 = arr[i];
                 cnt1 = 1;
             } else if (cnt2 == 0 && ele1 != arr[i]) {
                 ele2 = arr[i];
                 cnt2 = 1;
             } else if (ele1 == arr[i]) {
                 cnt1++;
             } else if (ele2 == arr[i]) {
                 cnt2++;
             } else {
                 cnt1--;
                 cnt2--;
             }
         }

        int actualCnt1 = 0, actualCnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele1) actualCnt1++;
            if (arr[i] == ele2) actualCnt2++;
        }

        int[] ans = new int[2];
        int mini = (int)(n / 3) + 1;
        if (actualCnt1 >= mini ) ans[0] = ele1;
        if (actualCnt2 >= mini) ans[1] = ele2;

        Arrays.sort(ans);

         return ans;
    }
}
