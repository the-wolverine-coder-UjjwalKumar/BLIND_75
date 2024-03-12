package algorithm.two_pointer;

import java.util.*;

public class RemoveZeroSumConsecutiveNodeLinkedList_LC1171 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(1);

        ListNode ansHead = removeZeroSumSublists(head);

        while (ansHead!=null){
            System.out.println(ansHead.val);
            ansHead = ansHead.next;
        }
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode preHead = new ListNode(0), curr = preHead;
        preHead.next = head;
        int prefix = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (curr != null) {
            prefix += curr.val;
            if (map.containsKey(prefix)) {
                curr =  map.get(prefix).next;
                int p = prefix + curr.val;
                // removing all prefix entry from map who contributed here till next prefix sum is same
                while (p != prefix) {
                    map.remove(p);
                    curr = curr.next;
                    p += curr.val;
                }
                map.get(prefix).next = curr.next;
            } else {
                map.put(prefix, curr);
            }
            curr = curr.next;
        }
        return preHead.next;
    }
}
