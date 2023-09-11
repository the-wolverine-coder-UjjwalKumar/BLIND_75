package algorithm;

public class CountAllValidDelivery_LC1359 {
    public static void main(String[] args) {
        int n = 3;
        // we have P1, P2, P3 & D1, D2, D3
        // we have to count all possible arrangement such that delivery(i) should happen after pickup(i)
        int ans = countOrders(n);
        System.out.println(ans);

    }

    public static int countOrders(int n) {
        long res = 1, mod = (long)1e9 + 7;
        for (int i = 1; i <= n; ++i)
            res = res * (i * 2 - 1) * i % mod;
        return (int)res;
    }
}
