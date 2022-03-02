package com.company;

public class Main {

    public static void main(String[] args) {
    }
}



public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode head, ListNode current) {
        if (l1 == null && l2 == null) {
            return head;
        }
        if (l1 == null) {
            return head;
        }
        if (l2 == null) {
            return head;
        }

        //TODO consider adding range if difference is 2 > to reduce steps
        // if one has a value and the other doesnt, handle edgecase
        int firstValue = l1.val;

        int secondValue = l2.val;

        if (firstValue <= secondValue) {
            ListNode remainder = l1.next;

            l1.next = null;

            if (current == null) {
                current = l1;
                head = l1;
            } else {
                current.next = l1;
                current = l1;
            }
            return mergeTwoLists(remainder, l2, head, current);
        } else {
            ListNode remainder = l2.next;

            l2.next = null;

            if (current == null) {
                current = l2;
                head = l2;
            } else {
                current.next = l2;
                current = l2;
            }
            return mergeTwoLists(l1, remainder, head, current);
        }
    }
}