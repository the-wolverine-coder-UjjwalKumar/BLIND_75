package algorithm.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumCommonValue_LC2540 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {0, 6, 4};

        int ans = getCommon(arr1, arr2);
        System.out.println(ans);

    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        return -1;
    }

    private static int getCommon1(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        fillMap(arr1, map1);
        fillMap(arr2, map2);

        int l1 = arr1.length;
        int l2 = arr2.length;

        if (l1 >= l2) {
            // consider l2 as base array
            return getMinCommonElement(arr2, map1, map2);

        } else {
            // consider l1 as base array
            return getMinCommonElement(arr1, map1, map2);
        }
    }

    private static void fillMap(int[] arr, Map<Integer, Integer> map) {
        for (int i : arr) {
            int c = map.getOrDefault(i, 0);
            map.put(i, c + 1);
        }
    }

    private static int getMinCommonElement(int[] arr, Map<Integer, Integer> map1,
                                           Map<Integer, Integer> map2) {
        int minKey = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i : arr) {
            int map1Val = map1.getOrDefault(i, -1);
            int map2Val = map2.getOrDefault(i, -1);


            if (map1Val == -1 || map2Val == -1) {
                continue;
            }

            if (minValue > map1Val || minValue > map2Val) {
                minValue = Math.min(map1Val, map2Val);
                minKey = Math.max(i, minKey);
            }

        }
        return minKey == Integer.MIN_VALUE ? -1 : minKey;
    }


}
