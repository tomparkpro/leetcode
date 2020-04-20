package pro.tompark.leetcode.days30;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node,
 * any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first,
 * then traverses node.left, then traverses node.right.)
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * image : Day20ConstructBinarySearchTree.png
 *
 *
 * Note:
 *
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class Day20ConstructBinarySearchTree {

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
//        preorder = new int[]{4, 2};
//        preorder = new int[]{4, 5};
//        preorder = new int[]{5, 2, 3};

        TreeNode treeNode = bstFromPreorder(preorder);
        System.out.println(treeNode.val);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        return bts(preorder, 0, preorder.length - 1);
    }

    private static TreeNode bts(int[] preorder, int si, int ei) {
        if (si > ei || si >= preorder.length || ei >= preorder.length) {
            return null;
        } else if (si == ei) {
            return new TreeNode(preorder[si]);
        }

        int rootVal = preorder[si];
        int rIdx = -1;
        for (int i = si; i <= ei; i++) {
            if (preorder[i] > rootVal) {
                rIdx = i;
                break;
            }
        }

        TreeNode node = new TreeNode(rootVal);
        if (rIdx == -1) {
            node.left = bts(preorder, si + 1, ei);
            node.right = null;
        } else {
            node.left = bts(preorder, si + 1, rIdx - 1);
            node.right = bts(preorder, rIdx, ei);
        }

        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
