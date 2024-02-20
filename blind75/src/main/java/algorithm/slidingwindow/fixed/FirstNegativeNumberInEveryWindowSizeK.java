package algorithm.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstNegativeNumberInEveryWindowSizeK {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        printFirstNegativeNumberInWindowK(arr, k);
    }

    private static void printFirstNegativeNumberInWindowK(int[] arr, int k) {
        int i = 0;
        int j = 0;

        List<Integer> ans = new ArrayList<>();
        List<Integer> negativeList = new LinkedList<>();

        while (j < arr.length) {
            if (arr[j] < 0)
                negativeList.add(arr[j]);

            if (j-i+1>=k) {
                if (!negativeList.isEmpty()) {
                    Integer firstNegative = negativeList.get(0);
                    ans.add(firstNegative);

                    if (arr[i] == firstNegative) {
                        negativeList.remove(0);
                    }
                } else {
                    ans.add(0);
                }

                i++;
            }

            j++;
        }

        System.out.println(ans);

    }
}
