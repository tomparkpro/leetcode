package pro.tompark.leetcode.days30.april;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Day13ContiguousArray {

    public static void main(String[] args) {
        int[] nums = {0, 1}; // 2
        nums = new int[]{1, 0}; // 2
        nums = new int[]{0, 1, 0}; // 2
        nums = new int[]{0, 0, 0, 1, 1, 1, 0}; // 6
        nums = new int[]{0, 1, 1, 0, 1, 1, 1, 0}; // 4

        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 1 || nums.length > 50000) {
            return 0;
        }

        int maxLen = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLen;
    }
}
