package pro.tompark.leetcode.days30.july;

import java.util.LinkedList;

/**
 * Maximum Width of Binary Tree
 *
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class Day9MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        TreeNode right = new TreeNode(2, null, new TreeNode(9));
        TreeNode root = new TreeNode(1, left, right);

        System.out.println(widthOfBinaryTree(root));
    }

    static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int result = 1;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.getFirst().position;
            int end = queue.getLast().position;
            result = Math.max(result, end - start + 1);
            for (int i = 0; i < size; i++) {
                Node p = queue.poll();
                int idx = p.position - start;
                if (p.node.left != null) queue.add(new Node(p.node.left, 2 * idx + 1));
                if (p.node.right != null) queue.add(new Node(p.node.right, 2 * idx + 2));
            }
        }

        return result;
    }

    public static class Node {
        TreeNode node;
        int position;

        public Node(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    // Definition for a binary tree node.
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
