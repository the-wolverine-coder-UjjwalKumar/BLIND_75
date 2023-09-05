package striver_atoz_dsa.recursion;

import java.util.Stack;

public class SortStackUsingRC {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.push(0);
        stack.push(5);

        // sort the stack using recursion
        System.out.println("Stack before sorting ; "+stack);
        sortStack(stack);
        System.out.println("Stack after sorting :"+stack);

    }

    private static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty() || stack.size()==1) {
            return;
        }

        int currentElement = stack.pop();
        sortStack(stack);
        // insert the currentElement in correct sorted position
        insertIntoStack(stack, currentElement);

    }

    private static void insertIntoStack(Stack<Integer> stack, int currentElement) {
        if (stack.isEmpty() || stack.peek() <= currentElement) {
            stack.push(currentElement);
            return;
        }

        int currentTopElement = stack.pop();
        insertIntoStack(stack, currentElement);
        stack.push(currentTopElement);
    }
}
