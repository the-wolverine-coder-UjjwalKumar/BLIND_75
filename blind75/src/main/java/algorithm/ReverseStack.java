package algorithm;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Stack before reverse : "+stack);
        reverseStack(stack);
        System.out.println("Stack after reverse : "+stack);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return;
        }

        int currElement = stack.pop();
        reverseStack(stack);
        insertInReverseFashion(stack, currElement);
    }

    private static void insertInReverseFashion(Stack<Integer> stack, int currElement) {
        if (stack.isEmpty()) {
            stack.push(currElement);
            return;
        }

        int topEle = stack.pop();
        insertInReverseFashion(stack, currElement);
        stack.push(topEle);
    }
}
