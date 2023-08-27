package blind_75_questions.array;

import java.util.*;

public class ThreeSum_LC15_06 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr2 = {0,1,1};
        List<List<Integer>> ans = threeSum(arr, arr.length);
        System.out.println(ans.toString());
        List<List<Integer>> ansBetter = threeSumBetter(arr, arr.length);
        System.out.println(ansBetter.toString());
        List<List<Integer>> ans1 = threeSumOptimal(arr, arr.length);
        System.out.println(ans1.toString());
    }

    // Brute Force : TC : O(N^3 + log n) & SC : O(Number of triplets to store in answer)
    private static List<List<Integer>> threeSum(int[] arr, int n) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1 ; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> currTriplet = new ArrayList<>(List.of(arr[i],arr[j],arr[k]));
                        Collections.sort(currTriplet);
                        ans.add(currTriplet);
                    }
                }
            }
        }

        return ans.stream().toList();
    }

    // Better approach : TC O(n^2 + log(n)) & SC : O(n)
    private static List<List<Integer>> threeSumBetter(int[] arr, int n) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                int valueToLook = -(arr[i]+arr[j]);

                if (set.contains(valueToLook)) {
                    List<Integer> tList = new ArrayList<>(List.of(arr[i],arr[j],valueToLook));
                    Collections.sort(tList);
                    ans.add(tList);
                }

                set.add(arr[j]);

            }
        }

        return ans.stream().toList();
    }

    // Optimal approach : TC O(nlog(n) + n^2) & SC : O(n)
    private static List<List<Integer>> threeSumOptimal(int[] arr, int n) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(arr);
        int i =  0;
        while (i < n-2) {
            int j = i+1, k = n-1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> tAns = new ArrayList<>(List.of(arr[i],arr[j],arr[k]));
                    ans.add(tAns);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
            i++;
            while (i < n-2 && arr[i] == arr[i-1]) i++;
        }

        return ans.stream().toList();
    }
}
