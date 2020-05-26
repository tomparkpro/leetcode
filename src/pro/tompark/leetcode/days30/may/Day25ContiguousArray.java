package pro.tompark.leetcode.days30.may;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Day25ContiguousArray {

    public static void main(String[] args) {
        int[] nums = {0,1,0};

        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        counts.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (counts.containsKey(count)) {
                Integer idx = counts.get(count);
                maxLength = Math.max(maxLength, i - idx);
            } else {
                counts.put(count, i);
            }
        }

        return maxLength;
    }
}