package striver_atoz_dsa.string;

import java.util.Arrays;

public class MaxScoreAfterSpillitingString_LC1422 {

    public static void main(String[] args) {
//        String s = "011101";
        String s = "01001";
        int ans = maxScore(s);

        System.out.println(ans);
    }

    private static int maxScore(String s) {
        // here constraints is 2 <= len(s) <= 500
        if (s.length() == 2) {
            return (s.charAt(0) == '0' ? 1 : 0) + (s.charAt(1) == '1' ? 1 : 0);
        }

        int[] prefixRightToLeft = new int[s.length()];
        for (int i = s.length()-1; i >= 0; i--) {

            if (i == s.length() - 1) {
                prefixRightToLeft[i]  = 0;
                continue;
            }

            if (s.charAt(i+1) == '1') {
                prefixRightToLeft[i] = prefixRightToLeft[i+1] + 1;
            } else {
                prefixRightToLeft[i] = prefixRightToLeft[i+1];
            }
        }

        System.out.println("Array Prefix :: "+Arrays.toString(prefixRightToLeft));
        int ans = Integer.MIN_VALUE;
        int leftScore = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftScore++;
            }
            ans = Math.max(ans, leftScore+prefixRightToLeft[i]);
        }
        return ans;
    }

    public int maxScoreOptimal(String s) {

        //Logic behind this -
        //Result = Max of (ZerosOnLeft + OnesOnRight)
        //= Max of (ZerosOnLeft + (TotalOnes - OnesOnLeft))
        //= Max of (ZerosOnLeft - OnesOnLeft) + TotalOnes (as TotalOnes is constant)

        int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') zeros++; else ones++;
            if(i != s.length()-1) max = Math.max(zeros - ones, max);
        }
        return max + ones;
    }
}
