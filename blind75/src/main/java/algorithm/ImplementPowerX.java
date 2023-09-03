package algorithm;

public class ImplementPowerX {
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        // op : pow(x,n) = pow(2,3) = 8, pow(2,10) = 1024

        int ans = getPow(x,n);
        System.out.println(ans);
        int ans1 = getPow1(x,n);
        System.out.println(ans1);

    }

    private static int getPow(int x, int n) {
        if (n==0) {
            return 1;
        }
        return x * getPow(x, n-1);
    }

    private static int getPow1(int x, int n) {
        if (n==0) {
            return 1;
        }

        int ans = getPow1(x, n/2);
        ans*=ans;
        if (n%2 == 1) {
            ans*=x;
        }

        return ans;
    }

    public double myPow(double x, int n) {
        if(n>=0)
            return positive(x,n);
        else
            return negative(x,n);
    }

    private double negative(double x, int n)
    {
        if(n==-1)
            return 1/x;

        double smallOutput=myPow(x,n/2);
        if(n%2==0)
            return smallOutput*smallOutput;
        else
            return (1/x)*smallOutput*smallOutput;
    }

    private double positive(double x, int n)
    {
        if(n==0)
            return 1;

        double smallOutput=myPow(x,n/2);
        if(n%2==0)
            return smallOutput*smallOutput;
        else
            return x*smallOutput*smallOutput;
    }
}
