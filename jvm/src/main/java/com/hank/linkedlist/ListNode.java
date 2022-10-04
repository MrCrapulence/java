package com.hank.linkedlist;

/**
 * @author Hank
 * @date 2022-09-30 17:13
 */
public class ListNode {
    /**
     * 单链表定义
     */
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 删除链表中的节点：https://leetcode.cn/problems/delete-node-in-a-linked-list/
     * 官方解法：和下一个节点交换
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除倒数第n个节点
     * 方法1：计算链表长度
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        // 添加一个哑结点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i <= length - n + 1; i++) {
            // 待删除的上一个节点
            if (i == length - n + 1) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 删除倒数第n个节点
     * 方法2：栈
     */

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, null);
        ListNode head = new ListNode(1, listNode2);
        System.out.println(listNode.removeNthFromEnd(head, 1));
    }


}

