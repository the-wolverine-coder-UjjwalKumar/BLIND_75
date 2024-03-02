package striver_atoz_dsa.array.medium;

import java.util.Arrays;

public class MaximumOddBinaryNumber_LC2864 {
    public static void main(String[] args) {
        String s = "1010";
        String ans = maximumOddBinaryNumber(s);
        System.out.println(ans);
    }

    public static String maximumOddBinaryNumber(String s) {
        int n = s.length();
        String[] ch = new String[n];
        Arrays.fill(ch, "0");
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='1'){
                ch[j] = "1";
                j++;
            }
        }

        ch[j-1] = "0";
        ch[n-1] = "1";


        return String.join("", ch);


    }
}
