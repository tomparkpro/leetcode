package pro.tompark.leetcode.days30;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that
 * the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Day15ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(result, 1);

        for (int i = 0; i < nums.length; i++) {
            left[i] = (i == 0) ? 1 : left[i -1] * nums[i - 1];
            right[len - i - 1] = (i == 0) ? 1 : right[len - i] * nums[len - i];

            result[i] *= left[i];
            result[len - i - 1] *= right[len - i - 1];
        }

        return result;
    }

    /**
     * Time Limit Exceeded
     */
    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    result[i] *= nums[j];
                }
            }
        }

        return result;
    }
}
