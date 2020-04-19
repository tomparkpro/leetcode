package pro.tompark.leetcode.days30;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class Day19SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        nums = new int[]{4, 5, 6, 7, 0, 1};
//        nums = new int[]{1, 3};
        nums = new int[]{3, 5, 1};
        int target = 0;
//        target = 3;
//        target = 4;
        target = 0;
        target = 3;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        return find(nums, target, 0, nums.length - 1);
    }

    private static int find(int[] nums, int target, int si, int ei) {
        if (si < 0 || ei < 0 || si >= nums.length || ei >= nums.length) return -1;

        // set middle index
        int mi = si + (ei - si) / 2;

        // found the target
        if (nums[mi] == target) return mi;

        // check left and right
        if (mi - 1 >= 0 && nums[mi - 1] == target) {
            return mi -1;
        }
        if (mi + 1 < nums.length && nums[mi + 1] == target) {
            return mi + 1;
        }

        // check left is sorted
        if (mi - 1 >= 0 && si < mi - 1 && nums[si] <= nums[mi - 1]) {
            if (nums[si] <= target && target < nums[mi - 1]) {
                // search left
                return find(nums, target, si, mi - 1);
            } else {
                // search right
                return find(nums, target, mi + 1, ei);
            }
        // check right is sorted
        } else if (mi + 1 < nums.length && mi + 1 < ei && nums[mi + 1] <= nums[ei]) {
            if (nums[mi + 1] < target && target <= nums[ei]) {
                // search right
                return find(nums, target, mi + 1, ei);
            } else {
                // search left
                return find(nums, target, si, mi - 1);
            }
        } else {
            return -1;
        }
    }
}
