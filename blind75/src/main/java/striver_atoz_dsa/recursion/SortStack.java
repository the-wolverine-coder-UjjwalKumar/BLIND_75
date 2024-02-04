package striver_atoz_dsa.recursion;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();


        stack.push(10);
        stack.push(3);
        stack.push(11);
        stack.push(98);

        System.out.println("Stack before sorting :: "+stack);
        Stack<Integer> sortedStack = sortUsingRc(stack);
        System.out.println("Stack after sorting :: "+sortedStack);
    }

    private static Stack<Integer> sortUsingRc(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        int top = stack.pop();
        Stack<Integer> sortedStack = sortUsingRc(stack);

        if (sortedStack.isEmpty()) {
            sortedStack.push(top);
        } else {
            if (sortedStack.peek() <= top) {
                sortedStack.push(top);
            } else {
                int recentTop = sortedStack.pop();
                sortedStack.push(top);
                sortedStack.push(recentTop);
            }
        }

        return sortedStack;

    }

}
