package pro.tompark.leetcode.days30.april;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 *
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 *
 *
 * Example 2:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 *
 *
 * Example 3:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 *    Hide Hint #1
 * Depth-first search (DFS) with the parameters: current node in the binary tree and current position in the array of integers.
 *    Hide Hint #2
 * When reaching at final position check if it is a leaf node.
 */
public class Day30ValidSequenceFromBTree {

    public static void main(String[] args) {
        // [0,1,0,0,1,0,null,null,1,0,0]
        TreeNode cleft = new TreeNode(0);
        cleft.right =  new TreeNode(1);
        TreeNode cright = new TreeNode(1);
        cright.left = new TreeNode(0);
        cright.right = new TreeNode(0);

        TreeNode left = new TreeNode(1);
        left.left = cleft;
        left.right = cright;

        TreeNode right = new TreeNode(0);
        right.left = new TreeNode(0);

        TreeNode root = new TreeNode(0);
        root.left = left;
        root.right = right;

        int[] arr = {0, 1, 0, 1};

        System.out.println(isValidSequence(root, arr));
    }

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    private static boolean isValid(TreeNode node, int[] arr, int idx) {
        if (idx >= arr.length || node == null) return false;

        // current node
        if (arr[idx] != node.val) {
            return false;
        }

        // if it is last node
        if (idx == arr.length - 1) {
            if (node.left == null && node.right == null) {
                return true;
            } else {
                return false;
            }
        }

        // child node
        boolean left = isValid(node.left, arr, idx + 1);
        boolean right = isValid(node.right, arr, idx + 1);
        return left || right;
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