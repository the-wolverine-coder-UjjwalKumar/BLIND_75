package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_LC217_05 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        boolean ans = isContainsDuplicates(arr, arr.length);
        System.out.println(ans);

        boolean ans2 = isContainsDuplicatesBetter(arr, arr.length);
        System.out.println(ans2);

        int ans3 = findDuplicatesOptimal(arr,arr.length);
        System.out.println(ans3);
    }

    // Brute Force : TC O(N^2) & SC O(1)
    private static boolean isContainsDuplicates(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j])
                    cnt++;

                if (cnt >= 2)
                    return true;
            }
        }

        return false;
    }

    // Better Appoach : TC O(N) & SC O(N)
    private static boolean isContainsDuplicatesBetter(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                return true;
            }

        }

        return false;
    }

    // Optimal Approach : TC O(N) & SC O(N)
    private static int findDuplicatesOptimal(int[] arr, int n) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast  = arr[arr[fast]];
        } while (slow != fast);

        fast = arr[0];

        while (fast != slow) {
            slow = arr[slow];
            fast = arr[fast];
        }

      return slow;
    }
}
