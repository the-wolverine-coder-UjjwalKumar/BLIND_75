package striver_atoz_dsa.matrix;

import java.util.Arrays;

public class LargestLocalValuesInMatrix_LC2373 {
    public static void main(String[] args) {
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};

        int[][] grid1 = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};

        int[][] ans = largestLocal(grid1);
        System.out.println(Arrays.deepToString(ans));
    }

    public static int[][] largestLocal(int[][] grid) {
        // 3 <= n <= 100
        // n == grid.length == grid[i].length
        int n = grid.length;

        int[][] ans = new int[n-2][n-2];

        for (int row = 0; row < n-2; row++) {
            for (int col = 0; col < n-2; col++) {

                // make a 3x3 grid starting from row,col
                int localMax = Integer.MIN_VALUE;
                localMax = Math.max(localMax, grid[row][col]);
                localMax = Math.max(localMax, grid[row][col+1]);
                localMax = Math.max(localMax, grid[row][col+2]);

                localMax = Math.max(localMax, grid[row+1][col]);
                localMax = Math.max(localMax, grid[row+1][col+1]);
                localMax = Math.max(localMax, grid[row+1][col+2]);

                localMax = Math.max(localMax, grid[row+2][col]);
                localMax = Math.max(localMax, grid[row+2][col+1]);
                localMax = Math.max(localMax, grid[row+2][col+2]);

                ans[row][col] = localMax;

            }

        }

        return ans;
    }
}
