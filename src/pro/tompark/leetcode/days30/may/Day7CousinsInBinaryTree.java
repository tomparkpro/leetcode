package pro.tompark.leetcode.days30.may;

/**
 * Cousins in Binary Tree
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class Day7CousinsInBinaryTree {

    public static void main(String[] args) {
//        TreeNode left = new TreeNode(2);
//        left.right = new TreeNode(4);
//        TreeNode right = new TreeNode(3);
//        right.right = new TreeNode(5);
//        TreeNode root = new TreeNode(1);
//        root.left = left;
//        root.right = right;
//        int x = 5, y = 4;

        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = new TreeNode(3);;
        int x = 4, y = 3;

        System.out.println(isCousins(root, x, y));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int xDepth = findDepth(null, root, x, y, 0);
        int yDepth = findDepth(null, root, y, x, 0);

        return xDepth == yDepth && xDepth != -1;
    }

    private static int findDepth(TreeNode parent, TreeNode node, int target, int cousin, int depth) {
        if (node == null) return 0;

        if (node.val == target) {
            if (parent != null) {
                if (parent.left == node) {
                    if (parent.right != null && parent.right.val == cousin) {
                        depth =  -1;
                    }
                } else {
                    if (parent.left != null && parent.left.val == cousin) {
                        depth =  -1;
                    }
                }
            }
            return depth;
        }  else {
            int left = findDepth(node, node.left, target, cousin, depth + 1);
            int right = findDepth(node, node.right, target, cousin, depth + 1);
            return left + right;
        }
    }

    /**
     * Definition for a binary tree node.
     */
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