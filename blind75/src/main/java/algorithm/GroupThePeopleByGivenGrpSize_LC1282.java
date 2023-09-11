package algorithm;

import java.util.*;

public class GroupThePeopleByGivenGrpSize_LC1282 {
    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        int peoples = groupSizes.length - 1; // people start with 0 index
        List<List<Integer>> ans = groupThePeople(groupSizes);
        System.out.println(ans);

    }

    public static List<List<Integer>> groupThePeople(int[] arr) {

        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int curr = arr[i];
            List<Integer> temp = new ArrayList<>();
            if(map.containsKey(curr)) temp = map.get(curr);
            temp.add(i);
            map.put(curr, temp);
            if(temp.size() == curr){
                ans.add(temp);
                map.remove(curr);
            }
        }

        return ans;

    }
}
