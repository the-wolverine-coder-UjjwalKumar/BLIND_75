package algorithm.slidingwindow.fixed;

import java.util.Stack;

public class RemoveKDigits_LC402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        String num1 = "10200";
        int k1 = 1;

        String num2 = "10";
        int k2 = 2;
        String ans = removeKdigits(num2, k2);
        System.out.println(ans);

    }

    public static String removeKdigits1(String num, int k) {

        if (num.length() <= k) return "0";

        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while (j<num.length()) {
            if (j-i+1 == k) {
                // 0 ...i ... j....
                String temp = num.substring(0, i) + num.substring(i+k);

                ans = Integer.min(ans, Integer.parseInt(temp));
                i++;

            }
            j++;
        }

        return String.valueOf(ans);
    }

    private static String removeKdigits11(String num, int k) {
        while (k > 0) {
            int n = num.length();
            int i = 0;
            while (i+1<n && num.charAt(i)<=num.charAt(i+1))  i++;
            num = num.substring(0, i) + num.substring(i+1);
            k--;
        }
        // trim leading zeros
        int s = 0;
        while (s<num.length()-1 && num.charAt(s)=='0')  s++;
        num = num.substring(s);

        return num == "" ? "0" : num;
    }

    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0)  return num;
        if(k == len) return "0";

        Stack<Character> stack = new Stack<>();
        int index = 0;

        while(index < len){
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        while(k-- > 0) stack.pop();

        String smallest = "";
        while(!stack.isEmpty()) smallest = stack.pop() + smallest;

        // delete leading zeros
        while(smallest.length() > 1 && smallest.charAt(0) == '0')
            smallest = smallest.substring(1);

        return smallest;
    }
}
