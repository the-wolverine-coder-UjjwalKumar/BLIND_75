package striver_atoz_dsa.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParenthesisString_LC678 {
    public static void main(String[] args) {
        String s = "***)";
        String s1 = ")***)";
        boolean ans = checkValidString(s1);
        System.out.println("ans = "+ans);
    }

    public static boolean checkValidString(String s) {

        int starCount = 0;
        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    if (starCount > 0) {
                        stack.push(ch);
                    } else {
                        return false;
                    }
                }
            } else if (ch == '*') starCount++;
        }

        boolean ans = stack.isEmpty();

        if (ans) return true;

        while (!stack.isEmpty()) {
            starCount--;
            stack.pop();
        }

        return true;
    }

    public boolean checkValidString1(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        int scount = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') stk.push(c);
            else {
                if(c == ')' && !stk.isEmpty()) stk.pop();
                else if(c == ')' && scount > 0) scount--;
                else if(c  == ')') return false;
                else {
                    scount++;
                    if(!stk.isEmpty()) {
                        stk.pop();
                        scount++;
                    }
                }
            }
        }
        return stk.isEmpty();
    }
}
