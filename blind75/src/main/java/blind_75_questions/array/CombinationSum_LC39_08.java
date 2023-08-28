package blind_75_questions.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39_08 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(candidates, target);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // here ds is passed by reference and changes
                // will affect the original one hence make new one and add to ans
                //ans.add(ds); not this.
            }
            return;
        }

        //when picked
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }

        // when not picked
        findCombinations(ind + 1, arr, target, ans, ds);
        return;
    }
}
