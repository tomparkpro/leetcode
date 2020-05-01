package pro.tompark.leetcode.days30.april;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * Note:
 *
 * The number of nodes in the given list will be between 1 and 100.
 */
public class Day8MiddleOfTheLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        ListNode no1 = new ListNode(1);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(3);
        ListNode no4 = new ListNode(4);
        ListNode no5 = new ListNode(5);
        ListNode no6 = new ListNode(6);
        no1.next = no2;
        no2.next = no3;
        no3.next = no4;
        no4.next = no5;
        no5.next = no6;

        System.out.println(no1);
//        ListNode middleNode = middleNode(no1);
        ListNode middleNode = middleNode2(no1);
        System.out.println(middleNode);
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int nodeCount = 0;

        ListNode node = head;
        while (node != null) {
            nodeCount++;
            nodeMap.put(nodeCount, node);
            node = node.next;
        }

        return nodeMap.get(nodeCount / 2 + 1);
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            ListNode node = this;
            String toString = "[ ";
            while (node != null) {
                toString += node.val + " ";
                node = node.next;
            }
            toString += "]";
            return toString;
        }
    }
}
