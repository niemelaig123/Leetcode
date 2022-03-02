package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    public boolean hasCycle(ListNode head) {
        return hasCycle(head, new HashSet<>());
    }

    public boolean hasCycle(ListNode head, HashSet<Integer> passed) {
        if (head == null) {
            return false;
        }
        ListNode next = head.next;

        if (next == null) {
            return false;
        }
        int hashCode = next.hashCode();

        if (passed.contains(hashCode)) {
            return true;
        }
        passed.add(hashCode);

        return hasCycle(next, passed);
    }

}