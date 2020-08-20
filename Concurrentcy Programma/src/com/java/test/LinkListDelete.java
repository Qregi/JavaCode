package com.java.test;

import com.java.test.Entity.ListNode;

public class LinkListDelete {

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = head;
        ListNode currnetNode = headNode;
        while (currnetNode != null && currnetNode.next != null) {
            if (currnetNode.val == currnetNode.next.val) {
                currnetNode.next = currnetNode.next.next;
            } else {
                currnetNode = currnetNode.next;
            }
        }
        return headNode;
    }
}
