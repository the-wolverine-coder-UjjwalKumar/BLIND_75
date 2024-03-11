package algorithm.two_pointer;

public class LongestTurbulentArray_LC978 {
    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        int ans = maxTurbulentSize(arr);
        System.out.println(ans);
    }

    public static int maxTurbulentSize(int[] arr) {

        if (arr.length < 2) return arr.length;

        // we have to identify the max contiguous dip and up
        int ans = 1;

        int start = 0;
        int end = start;
        int n = arr.length;

        while (start+1 < n) {
            if (arr[start] == arr[start+1]) {
                start++; // handle duplicates
                continue;
            }

            end = start+1;
            while (end+1 < n && isTurbulentIndex(arr, end)) end++;

            ans = Math.max(ans, end-start+1);
            start = end;
        }

        return ans;
    }

    private static boolean isTurbulentIndex(int[] arr, int k) {
        return (arr[k] > arr[k+1] && arr[k] > arr[k-1]) || (arr[k] < arr[k+1] && arr[k] < arr[k-1]);
    }
}
