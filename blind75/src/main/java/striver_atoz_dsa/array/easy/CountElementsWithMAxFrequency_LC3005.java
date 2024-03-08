package striver_atoz_dsa.array.easy;

import java.util.*;

public class CountElementsWithMAxFrequency_LC3005 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4};
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {10,12,11,9,6,19,11};
        int ans = maxFrequencyElements(arr2);
        System.out.println(ans);
    }

    public static int maxFrequencyElements1(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count+1);
        }

        int maxCount = -1;
        int elementsCount = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {

            int val = entry.getValue();
            if (maxCount == -1 || val > maxCount) {
                maxCount = val;
            }

            if (val == maxCount) {
                elementsCount+=val;
            }

        }

        return elementsCount;

    }

    public static int maxFrequencyElements(int[] nums) {
        int a[]=new int[101];
        for(int i:nums)
        {
            a[i]++;
        }
        int maxi=0;
        for(int i=0;i<=100;i++)
        {
            maxi=Math.max(maxi,a[i]);
        }
        int ans=0;
        for(int i=0;i<=100;i++)
        {
            if(a[i]==maxi)
            {
                ans+=maxi;
            }
        }
        return ans;
    }
}
