package algorithm.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_LC18 {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;

        int[] arr1 = {1000000000,1000000000,1000000000,1000000000};
        int target1 = -294967296;

        List<List<Integer>> ans = fourSum(arr1, target1);
        System.out.println(ans);
    }

    private static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        if (n < 4) return new ArrayList<>();
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n-3; i++) {

            // skip duplicates
            if (i!=0 && arr[i] == arr[i-1]) continue;

            for (int j = i+1; j < n-2; j++) {

                // skip duplicates
                if (j!=i+1 && arr[j] == arr[j-1]) continue;

                int left = j+1;
                int right = n-1;
                while (left < right) {

                    int currSum = arr[i]+arr[j]+arr[left]+arr[right];

                    if (currSum > target) {
                        right--;
                    } else if (currSum < target){
                        left++;
                    } else {
                        List<Integer> quadruplets = new ArrayList<>(List.of(arr[i],arr[j],arr[left],arr[right]));
                        ans.add(quadruplets);

                        // search for other combination
                        left++;
                        right--;

                        while (left < right && arr[left] == arr[left-1]) left++;
                        while (left < right && arr[right] == arr[right+1]) right--;
                    }
                }
            }
        }
        return ans;
    }
}
