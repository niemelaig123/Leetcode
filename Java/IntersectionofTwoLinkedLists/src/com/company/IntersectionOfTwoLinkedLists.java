package com.company;

public class IntersectionOfTwoLinkedLists {

    public static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoLists(l1, l2, null, null);
    }

    /**
     * Reminder: Current issue is that the trailing/last node/value isn't being transferred/considered.
     *              i.e from 1, 2, 4 and 1, 3, 4; one of the trailing 4's is not being added to 'current'.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode head, ListNode current) {
        if (l1 == null && l2 == null) {
            return head;
        }
        ListNode from = l1 == null ? l2
                : l2 == null ? l1
                : l1.val < l2.val ? l1 : l2;

        ListNode unchanged = from == l1 ? l2 : l1;

        ListNode remainder = from.next;

        from.next = null;

        if (current == null) {
            current = from;
            head = from;
        } else {
            current.next = from;
            current = from;
        }
        return mergeTwoLists(remainder, unchanged, head, current);
    }

}
