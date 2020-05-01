package pro.tompark.leetcode.days30.april;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class Day11DiameterOfBinaryTree {

    static int diameter = 0;

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree2(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int mLeft = diameterOfBinaryTree(root.left);
        int mRight = diameterOfBinaryTree(root.right);

        int mRoot = maxLength(root);

        return Math.max(mRoot, (Math.max(mLeft, mRight)));
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        dfs(root);
        return diameter;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        diameter = Math.max(diameter, l + r);

        return Math.max(l, r) + 1;
    }

    public static int maxLength(TreeNode root) {
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth + rightDepth;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
