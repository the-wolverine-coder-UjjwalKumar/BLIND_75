package striver_atoz_dsa.linkedlist;


import striver_atoz_dsa.array.medium.ReorderLinkedList_LC143;

import static striver_atoz_dsa.array.medium.ReorderLinkedList_LC143.printList;

public class DoubleNodeValue_LC2816 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        printList(head);
        ListNode reversedHead = reverseLink(head);
        printList(reversedHead);

    }

    public static ListNode reverseLink(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newHead = reverseLink(node.next);

        node.next.next = node;
        node.next = null;

        return newHead;
    }


}
