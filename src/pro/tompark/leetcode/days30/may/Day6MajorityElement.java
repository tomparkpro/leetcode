package pro.tompark.leetcode.days30.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Day6MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        nums = new int[] {2,2,1,1,1,2,2};
        nums = new int[] {3, 3, 4};

        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0 && i < nums.length - 1) {
                    majority = nums[i + 1];
                }
            }

            if (count > nums.length / 2) break;
        }

        return majority;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement3(int[] nums) {
        int majority = 0;
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > max) {
                majority = num;
                max = count;
            }
            map.put(num, count);
        }

        return majority;
    }

}