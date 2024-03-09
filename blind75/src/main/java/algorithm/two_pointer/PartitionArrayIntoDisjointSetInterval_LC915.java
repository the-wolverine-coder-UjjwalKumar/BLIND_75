package algorithm.two_pointer;

public class PartitionArrayIntoDisjointSetInterval_LC915 {
    public static void main(String[] args) {
        int[] arr = {5,0,3,8,6};
        int[] arr2 = {1,1,1,0,6,12};
        int ans = partitionDisjointSet(arr2);
        System.out.println(ans);
    }

    // idea is to find the index where max of left array is smaller than min of right array
    public int partitionDisjoint(int[] arr) {

        int maxElementLeftPart = arr[0];
        int max = maxElementLeftPart;
        int partitionIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (maxElementLeftPart > arr[i]) {
                maxElementLeftPart = max;
                partitionIndex = i;
            } else {
                max =  Math.max(arr[i], max);
            }

        }
        return partitionIndex+1;
    }

    private static int partitionDisjointSet(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = n-1; i>0; i--) {
            boolean isFound = true;
            for (int j = i-1; j >= 0; j--) {
                 if (arr[i] < arr[j]) {
                     isFound = false;
                     break;
                 }
            }

            if (isFound) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
