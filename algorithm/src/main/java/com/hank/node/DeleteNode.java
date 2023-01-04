package com.hank.node;

/**
 * @author Hank
 * @date 2023-01-04 15:41
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        System.out.println(node);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(listNode3);
    }
}
