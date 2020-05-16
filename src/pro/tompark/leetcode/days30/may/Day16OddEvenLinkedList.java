package pro.tompark.leetcode.days30.may;

/**
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Day16OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode head = new ListNode(1, n2);

        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println(node);

        node = oddEvenList(head);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println(node);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode even = null;
        ListNode oddTail = head;
        ListNode evenTail = null;
        ListNode node = head.next;
        int idx = 2;
        while (node != null) {
            if (idx % 2 == 0) {
                if (even == null) {
                    even = node;
                } else {
                    evenTail.next = node;
                }
                evenTail = node;
            } else {
                oddTail.next = node;
                oddTail = node;
            }
            node = node.next;
            idx++;
        }

        evenTail.next = null;
        oddTail.next = even;

        return head;
    }

    static public class ListNode {
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
}