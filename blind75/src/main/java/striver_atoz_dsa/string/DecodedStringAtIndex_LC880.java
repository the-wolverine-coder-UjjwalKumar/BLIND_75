package striver_atoz_dsa.string;

public class DecodedStringAtIndex_LC880 {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        String ans = decodeAtIndex(s,k);
        System.out.println(ans);

        String s1 = "ha22";
        int k1 = 5;
        System.out.println(decodeAtIndex(s1,k1));

//        String s2 = "a2345678999999999999999";
//        int k2 = 1;
//        System.out.println(decodeAtIndex(s2,k2));

    }

    // Brute force but this will give TLE
    private static String decodeAtIndexBruteForce(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i<s.length()) {
            Character ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                int d = (ch - '1');
                String lastAppended = sb.toString();
                while (d!=0) {
                    sb.append(lastAppended);
                    d--;
                }
            }
            i++;
        }
        System.out.println(sb.toString());
        return String.valueOf(sb.toString().charAt(k-1));
    }

    // Optimized
    public static String decodeAtIndex(String S, int K) {
        for (int len = 0, i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                int num = S.charAt(i) - '0', count = 0;
                for (; count < num - 1 && K > len; count++) {
                    K -= len;
                }
                if (count != num - 1) {
                    return decodeAtIndex(S, K);
                } else {
                    len *= num;
                }
            } else {
                len++;
                K--;
                if (K == 0) {
                    return String.valueOf(S.charAt(i));
                }
            }
        }
        return "";
    }
}
