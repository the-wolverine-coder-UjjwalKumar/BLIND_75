package striver_atoz_dsa.array.medium;

import striver_atoz_dsa.linkedlist.ListNode;

import java.util.Stack;

public class ReorderLinkedList_LC143 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        int i = 2;
        ListNode cur = head;
        while (i <= 4) {
            cur.next = new ListNode(i);
            cur = cur.next;
            i++;
        }
        // 1-> 2-> 3 -> 4 -> 5
        printList(head);
        reorderList(head);
        printList(head);

    }

    private static void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<ListNode> stack = new Stack<>();
        slow = slow.next;
        while (slow!=null) {
            stack.push(slow);
            slow = slow.next;
        }


        ListNode cur = head;

        while (!stack.isEmpty()) {

            ListNode curNext = cur.next;
            cur.next = stack.pop();
            cur.next.next = curNext;

            cur = curNext;

        }
        cur.next = null; // ending this new list

    }

    public void reorderList1(ListNode head) {
        if(head.next != null && head != null) {

            ListNode slow = head;
            ListNode fast = head.next;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }


            if(fast.next != null){
                slow = slow.next;
            }

            ListNode temp = slow.next;
            ListNode newHead = temp;
            slow.next = null;

            newHead = reverse(newHead, null);

            ListNode curr = head;

            while(newHead != null){
                ListNode node = curr.next;
                curr.next = newHead;
                newHead = node;
                curr = curr.next;
            }
        }
    }
    public ListNode reverse(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode newHead = head.next;
        head.next = prev;
        return reverse(newHead, head);
    }

    public static void printList(ListNode head) {
        ListNode cur= head;
        while (cur!=null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
