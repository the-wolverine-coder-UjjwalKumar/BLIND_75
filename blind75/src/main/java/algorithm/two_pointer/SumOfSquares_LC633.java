package algorithm.two_pointer;

public class SumOfSquares_LC633 {
    public static void main(String[] args) {
        int c = 89;
        boolean ans = judgeSumSquare(c);
        System.out.println(ans);
    }

    private static boolean judgeSumSquare(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int sq = left * left + right * right;
            if (sq == c) {
                System.out.println(left+", "+right);
                return true;
            } else if (sq > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
