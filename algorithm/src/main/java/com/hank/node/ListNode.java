package com.hank.node;

/**
 * @author Hank
 * @date 2023-01-04 15:41
 * Definition for singly-linked list
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
