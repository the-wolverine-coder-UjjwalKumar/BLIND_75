package striver_atoz_dsa.recursion;

public class StringSTOI_LC8 {
    public static void main(String[] args) {
        String s = "42";
        String s1 = "402";
        String s2 = "0402";
        String s3 = "- 0404";
        String s4 = "  -  23 1 hello ujjwal"; // -231 will be output
        String s5 = "words and 987";

        int ans4 = myAtoi(s5);
        System.out.println(ans4);


        int ans = getAtoI(s, s.length()-1, s.length(), 0);
        System.out.println(ans);
        int ans1 = getAtoI(s1, s1.length()-1, s1.length(), 0);
        System.out.println(ans1);
        int ans2 = getAtoI(s2, s2.length()-1, s2.length(), 0);
        System.out.println(ans2);
        int ans3 = getAtoI(s3, s3.length()-1, s3.length(), 0);
        System.out.println(ans3);
    }

    private static int aToI(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        String trimmedS = s.trim();
        int ans = 0;
        boolean isNegative = false;
        if (!trimmedS.isEmpty()) {
            isNegative = trimmedS.charAt(0) == '-';

            String processedDigits = "";
            if (isNegative) {
                processedDigits = getDigits(trimmedS, 1);
            } else {
                processedDigits = getDigits(trimmedS, 0);
            }

            ans = getAtoI(processedDigits, processedDigits.length() - 1, processedDigits.length(), 0);

        }

        return isNegative ? -ans : ans;

    }

    private static String getDigits(String trimmedS, int i) {
        StringBuilder sb = new StringBuilder();
        while (i < trimmedS.length()) {
            char currCh = trimmedS.charAt(i);
            boolean flag = false;
            int j = 0;
            if (currCh == ' ' || !Character.isDigit(currCh)) {
                i++;
                continue;
            } else {
                if (Character.isDigit(currCh)) {
                    // pick all value till next space encounter
                    j = i + 1;
                    sb.append(currCh);
                    while (j < trimmedS.length()) {
                        if (trimmedS.charAt(j) == ' ') {
                            flag = true;
                            break;
                        } else {
                            if (Character.isDigit(trimmedS.charAt(j))) {
                                sb.append(trimmedS.charAt(j));
                            } else {
                                flag = true;
                                break;
                            }
                        }
                        j++;
                    }
                }
            }

            if (flag || j == trimmedS.length())
                break;
            i++;
        }
        return sb.toString();
    }

    private static int getAtoI(String s, int index, int n, int tempAns) {
        // Base condition
        if (index < 0) {
            return tempAns;
        }

        // do rc call
        int temp = Integer.parseInt(String.valueOf(s.charAt(index))) * (int) Math.pow(10, (n - 1 - index));

        return getAtoI(s, index - 1, n, tempAns + temp);

    }

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty())
            return 0;

        s = s.trim();
        char firstChar = s.charAt(0);
        int sign = 1, start = 0, len = s.length();
        long sum = 0;

        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < len; i++) {
            if (!Character.isDigit(s.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + s.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }
}
