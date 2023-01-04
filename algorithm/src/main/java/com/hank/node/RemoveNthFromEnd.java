package com.hank.node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hank
 * @date 2023-01-04 15:55
 * 删除链表的倒数第N个节点
 * 题目：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 解答：常用的技巧是在头节点前添加一个哑节点（dummy node），dummy.next = head
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int size = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            ++size;
        }

        if (size == n) {
            head = head.next;
            return head;
        }

        int index = 1;
        ListNode cur = head;
        while (head.next != null) {
            if (index == size - n) {
                if (n == 1) {
                    cur.next = null;
                } else {
                    cur.next = cur.next.next;
                }
                break;
            }
            cur = cur.next;
            ++index;
        }

        return head;
    }

    /**
     * 官方解法：哑节点
     */
    public ListNode removeNthFromEndByDummy(ListNode head, int n) {
        int size = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            ++size;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i < size - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * 官方解法：栈
     */
    public ListNode removeNthFromEndByStack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    /**
     * 官方解法：双指针
     */
    public ListNode removeNthFromEndByDoublePointer(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        int index = 1;
        while (first != null) {
            first = first.next;
            if (index > n) {
                second = second.next;
            }
            index++;
        }

        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode listNode6 = new ListNode(6, null);
//        ListNode listNode5 = new ListNode(5, null);
//        ListNode listNode4 = new ListNode(4, listNode5);
//        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, null);
        ListNode head = new ListNode(1, listNode2);

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEndByDoublePointer(head, 1);
    }

}
