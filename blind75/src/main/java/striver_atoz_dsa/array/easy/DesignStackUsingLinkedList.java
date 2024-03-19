package striver_atoz_dsa.array.easy;

public class DesignStackUsingLinkedList {

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int a) {
            data = a;
            next = null;
        }
    }

    static StackNode top;

    //Function to push an integer into the stack.
    static void push(int a) {
        // Add your code here
        StackNode temp = new StackNode(a);
        temp.next = top;
        top = temp;

    }

    //Function to remove an item from top of the stack.
    static int pop() {
        // Add your code here
        if (top == null) return -1;
        else {
            int poppedElement = top.data;
            top = top.next;
            return poppedElement;
        }
    }

    public static void main(String[] args) {
        System.out.println(pop());
        push(4);
        push(5);
        System.out.println(pop());
    }

}
