package pro.tompark.leetcode.days30.april;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Day29 Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class Day29BTreeMaximumPathSum {

    public static void main(String[] args) {
        // [-10,9,20,null,null,15,7]
//        TreeNode right = new TreeNode(20);
//        right.left = new TreeNode(15);
//        right.right = new TreeNode(7);
//
//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = right;

        // [-3]
//        TreeNode root = new TreeNode(-3);

        // [0,1,1]
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(1);

        // [-1,null,6,null,-4]
        TreeNode right = new TreeNode(6);
        right.right = new TreeNode(-4);
        TreeNode root = new TreeNode(-1);
        root.right = right;

        System.out.println(new Day29BTreeMaximumPathSum().maxPathSum(root));
    }

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxPathSum;
    }

    public int maxPathSumUtil(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumUtil(node.left));
        int right = Math.max(0, maxPathSumUtil(node.right));
        maxPathSum = Math.max(left + right + node.val, maxPathSum);
        return Math.max(left, right) + node.val;
    }

    public static int maxPathSum2(TreeNode root) {
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE);
        int rootSum = helper(root, maxSum);
        return Math.max(maxSum.get(), rootSum);
    }

    public static Integer helper(TreeNode node, AtomicInteger maxSum) {
        if (node == null) return null;

        Integer left = helper(node.left, maxSum);
        Integer right = helper(node.right, maxSum);
        Integer maxChild = null;
        if (left != null && right != null) {
            maxChild = Math.max(left, right);
        } else if (left != null) {
            maxChild = left;
        } else if (right != null) {
            maxChild = right;
        }

        int childSum = 0;
        if (maxChild != null) {
            if (left != null && right != null) {
                childSum = Math.max(maxChild, left + right);
            } else {
                childSum = maxChild;
            }
        }
        maxSum.set(Math.max(maxSum.get(), Math.max(node.val, node.val + childSum)));

        if (maxChild != null) {
            return Math.max(node.val, node.val + maxChild);
        } else {
            return node.val;
        }
    }

    public static class TreeNode {
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