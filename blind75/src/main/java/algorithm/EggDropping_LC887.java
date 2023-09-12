package algorithm;

public class EggDropping_LC887 {
    public static void main(String[] args) {
        int k = 2; // number of eggs
        int n = 6; // number of floors
        // find out the min no. of attempts in worst case to get the threshold floor
        int ans = getMinAttempts(n, k);
        System.out.println("Min. attempts : "+ans);
    }

    private static int getMinAttempts(int f, int e) {

        if (f <=1 || e <= 1) return f;

        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int tempAns = 1 + Math.max(getMinAttempts(k-1, e-1), getMinAttempts(f-k, e));
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }
}
