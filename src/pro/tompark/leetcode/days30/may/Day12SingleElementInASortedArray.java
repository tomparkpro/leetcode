package pro.tompark.leetcode.days30.may;

/**
 * Single Element in a Sorted Array
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once. Find this single element that appears only once.
 *
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Day12SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        nums = new int[]{3, 3, 7, 7, 10, 11, 11};

        System.out.print(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        return findSingle(nums, 0, nums.length - 1);
    }

    private static int findSingle(int[] nums, int s, int e) {
        if (s == e) return nums[s];

        int m = s + (e - s) / 2;

        // single is in the middle
        if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
            return nums[m];
        }

        // check single is in the left or right
        if (m % 2 == 0) {
            if (nums[m] == nums[m - 1]) {
                return findSingle(nums, s, m - 2);
            } else {
                return findSingle(nums, m + 2, e);
            }
        } else {
            if (nums[m] == nums[m - 1]) {
                return findSingle(nums, m + 1, e);
            } else {
                return findSingle(nums, s, m - 1);
            }
        }
    }
}