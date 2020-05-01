package pro.tompark.leetcode.days30.april;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class Day25JumpGame {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3,2,1,0,4};
//        int[] nums = {3,0,4,2,1,0,4};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
            if (i == maxReach) {
                break;
            }
        }

        return maxReach >= nums.length - 1;
    }

    public static boolean canJump2(int[] nums) {
        if (nums.length == 1) return true;
        boolean result = false;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                result = true;
                break;
            }
            int len = nums[i];
            if (len == 0) break;
            for (int j = 1; j <= len; j++) {
                if (canJump(nums, i + j)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public static boolean canJump(int[] nums, int idx) {
        boolean result = false;

        for (int i = idx; i < nums.length; i++) {
            if (i == nums.length - 1) {
                result = true;
                break;
            }
            int len = nums[i];
            if (len == 0) break;
            for (int j = 1; j <= len; j++) {
                if (canJump(nums, i + j)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}