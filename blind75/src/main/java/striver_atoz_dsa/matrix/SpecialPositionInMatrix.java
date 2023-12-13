package striver_atoz_dsa.matrix;

public class SpecialPositionInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] matrix1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] matrix2 = {{0, 1, 0}, {0, 0, 0}, {1, 0, 0}, {1, 0, 0}};
        int[][] matrix3 = {{0, 0}, {0, 0}, {1, 0}};
        int ans = getSpecialPositionCount(matrix2);
        System.out.println("ans :: " + ans);
    }

    private static int getSpecialPositionCount(int[][] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (isValidPosition(matrix, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isValidPosition(int[][] matrix, int row, int col) {
        boolean isValid = true;
        // Row wise check
        for (int i = 0; i < matrix[row].length; i++) {
            if (i != col && matrix[row][i] != 0) {
                isValid = false;
                break;
            }
        }

        // Col wise check
        if (isValid) {
            for (int j = 0; j < matrix.length; j++) {
                if (j != row && matrix[j][col] != 0) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0, col[] = new int[n], row[] = new int[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1) {
                    col[j]++;
                    row[i]++;
                }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) res++;
        return res;
    }
}
