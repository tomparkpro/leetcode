package pro.tompark.leetcode.days30.may;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * <p>
 * <p>
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 *
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * <p>
 * Hide Hint #1
 * Try to utilize the property of a BST.
 * Hide Hint #2
 * Try in-order traversal. (Credits to @chan13)
 * Hide Hint #3
 * What if you could modify the BST node's structure?
 * Hide Hint #4
 * The optimal runtime complexity is O(height of BST).
 */
public class Day20KthSmallestElementInABST {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(1);
        left.right = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        TreeNode root = new TreeNode(3);
        root.left = left;
        root.right = right;
        int k = 1;
        // Input: root = [3,1,4,null,2], k = 1

        System.out.println(kthSmallest(root, k));
    }

    public static int kthSmallest(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger();
        AtomicInteger result = new AtomicInteger();
        findKth(root, k, count, result);
        return result.get();
    }

    private static void findKth(TreeNode node, int k, AtomicInteger count, AtomicInteger result) {
        if (node.left != null) {
            findKth(node.left, k, count, result);
        }

        if (k == count.incrementAndGet()) {
            result.set(node.val);
            return;
        }

        if (node.right != null) {
            findKth(node.right, k, count, result);
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}