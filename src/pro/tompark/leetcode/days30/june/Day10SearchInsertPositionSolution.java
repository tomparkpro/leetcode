package pro.tompark.leetcode.days30.june;

/**
 * Search Insert Position
 *
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0Is Subsequence
 *
 */
public class Day10SearchInsertPositionSolution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 5;

        System.out.println(searchInsert(nums, target));
    }

    static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return l;
    }

    static int searchInsert2(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }

    private static int bs(int[] nums, int st, int en, int target) {
        if (st < 0) return 0;
        if (en > nums.length - 1) return en;
        if (st > en) return st;

        int mi = st + (en - st) / 2;
        if (nums[mi] == target) {
            return mi;
        } else if (nums[mi] < target){
            return bs(nums, mi + 1, en, target);
        } else {
            return bs(nums, st, mi - 1, target);
        }
    }
}
