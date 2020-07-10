package pro.tompark.leetcode.days30.july;

import java.util.Stack;

/**
 * Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 *
 *
 *
 * After flattening the multilevel linked list it becomes:
 *
 *
 * Example 2:
 *
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * How multilevel linked list is represented in test case:
 *
 * We use the multilevel linked list from Example 1 above:
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * The serialization of each level is as follows:
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 *
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 *
 * Merging the serialization of each level and removing trailing nulls we obtain:
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 * Constraints:
 *
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */
public class Day10FlattenMultilevelDoublyLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        head.next = n2; n2.prev = head;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        n5.next = n6; n6.prev = n5;
        n3.child = n7;
        n7.next = n8; n8.prev = n7;
        n8.next = n9; n9.prev = n8;
        n9.next = n10; n10.prev = n9;
        n8.child = n11;
        n11.next = n12; n12.prev = n11;

        Node flatten = flatten(head);
        Node node = flatten;
        while (node != null) {
            System.out.print(node.val + " - ");
            if (node.child != null) {
                System.out.println(node.val + "has child " + node.child.val);
            }
            node = node.next;
        }
    }

    static Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                stack.push(curr.next);
                curr.child.prev = curr;
                curr.next = curr.child;
                curr.child = null;
            } else if (curr.next == null && !stack.empty()) {
                Node next = stack.pop();
                if (next != null) {
                    next.prev = curr;
                }
                curr.next = next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

}
