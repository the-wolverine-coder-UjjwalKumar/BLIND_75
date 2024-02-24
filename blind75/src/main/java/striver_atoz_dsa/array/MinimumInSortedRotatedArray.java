package striver_atoz_dsa.array;

public class MinimumInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        int[] arr1 = {4,5,6,7,0,1,4};
        int[] arr2 = {2,2,2,0,1};
        int[] arr3 = {3,1};

        int ans = getMin(arr1);
        System.out.println(ans);
    }

    private static int getMin1(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = end - (end-start) / 2;

            if (arr[mid] < arr[end]) {
                // right part sorted
                end = mid;
            } else if (arr[mid] > arr[end]) {
                // left part sorted
                start = mid+1;
            } else {
                // arr[start] == arr[mid] == arr[end]
                end = end-1;
            }

        }
        return arr[start];
    }

    private static int getMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        // array never rotated
        if (nums[start] < nums[end]) return nums[start];

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                // min value lies in right side and left part is sorted
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                // min value lies in left side and right part is sorted
                end = mid;
            } else {
                // duplicates then reducing search space from right
                end--;
            }
        }

        return nums[start];
    }
}
