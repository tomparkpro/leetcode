package pro.tompark.leetcode.days30.june;

/**
 * Invert Binary Tree
 *
 *
 * Solution
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class Day1InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        right.left = new TreeNode(6);
        right.right = new TreeNode(9);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = right;

        TreeNode invertTree = invertTree(root);
        System.out.println(invertTree.val);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static TreeNode invertTree1(TreeNode root) {
        invert(root);
        return root;
    }

    public static void invert(TreeNode node) {
        if (node != null) {
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            invert(node.left);
            invert(node.right);
        }
    }


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
