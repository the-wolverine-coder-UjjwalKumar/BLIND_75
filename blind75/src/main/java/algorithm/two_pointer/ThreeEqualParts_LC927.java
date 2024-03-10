package algorithm.two_pointer;

import java.util.Arrays;

public class ThreeEqualParts_LC927 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int[] ans = threeEqualParts(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] threeEqualParts(int[] arr) {
        int[] ans = {-1,-1};

        // when answer is not possible when total number of one is not a multiple of 1
        int numOf1s = 0;
        for (int i : arr) numOf1s+=i;

        if (numOf1s == 0) return new int[]{0,2};

        if (numOf1s%3 != 0) return ans;

        int totalOnesInEachPart = numOf1s / 3;
        int indexOf1InPart0 = -1;
        int indexOf1InPart1 = -1;
        int indexOf1InPart2 = -1;

        numOf1s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                numOf1s++;
                if (numOf1s == 1) {
                    indexOf1InPart0 = i;
                } else if (numOf1s == totalOnesInEachPart + 1) {
                    indexOf1InPart1 = i;
                } else if (numOf1s == 2 * totalOnesInEachPart + 1) {
                    indexOf1InPart2 = i;
                }
            }
        }


//        while (indexOf1InPart2 < arr.length) {
//            if (arr[indexOf1InPart2] == arr[indexOf1InPart1]
//                    && arr[indexOf1InPart1] == arr[indexOf1InPart0]) {
//                indexOf1InPart0++;
//                indexOf1InPart1++;
//                indexOf1InPart2++;
//            } else {
//                return ans;
//            }
//        }

        for (; indexOf1InPart2 < arr.length
                && arr[indexOf1InPart0] == arr[indexOf1InPart1]
                && arr[indexOf1InPart1] == arr[indexOf1InPart2];
        indexOf1InPart0++, indexOf1InPart1++, indexOf1InPart2++){}

        return indexOf1InPart2 == arr.length ? new int[]{indexOf1InPart0-1, indexOf1InPart1} : new int[] {-1,-1};

//        return new int[] {indexOf1InPart0-1, indexOf1InPart1};
    }
}
