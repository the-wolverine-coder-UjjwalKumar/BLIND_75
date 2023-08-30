package blind_75_questions.array;

import java.util.Arrays;

public class SortColors_LC75_10 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};

        // Brute force is to use any sorting algo.
        // Merge sort : TC O(nlogn) & SC O (n)

        // Better one : count the occurrence of 0,1,2 and
        // manually write the occurrence of 0,1,2 in original array.

        // Optimal Approach: Use Dutch National Flag algorithm
        sortZeroOneTwos(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // Optimal Approach : TC ; O(n) & SC O(1)
    private static void sortZeroOneTwos(int[] arr, int n) {

        // Dutch National Flag algorithm says we have 3 pinter low, mid, high
        // array portion
        // from 0 to low-1 -> contains 0 (sorted)
        // from low to mid-1 ->  contains 1s (sorted)
        // from mid to high-1 -> contains randomly unsorted elements contains (0,1,2) which needs to be sorted
        // from high to n-1 -> contains 2s (sorted)

        // now our task is to sort the portion from mid to high-1.
        // if arr[mid] == 0 -> swap(arr[mid], arr[low]), low++
        // if arr[mid] == 1 -> just inc mid -> mid++
        // if arr[mid] == 2 -> swap(arr[mid],arr[high]), high--, mid++
        // perform this till mid is less than high

        int low = 0, high = n - 1, mid = 0;

        while (mid < high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            } else {
                mid++;
            }
        }

    }
}
