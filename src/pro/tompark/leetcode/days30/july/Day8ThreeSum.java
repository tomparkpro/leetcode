package pro.tompark.leetcode.days30.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *    Hide Hint #1
 * So, we essentially need to find three numbers x, y, and z such that they add up to the given value.
 * If we fix one of the numbers say x, we are left with the two-sum problem at hand!
 *
 *    Hide Hint #2
 * For the two-sum problem, if we fix one of the numbers, say
 * x
 * , we have to scan the entire array to find the next number
 * y
 * which is
 * value - x
 * where value is the input parameter. Can we change our array somehow so that this search becomes faster?
 *
 *    Hide Hint #3
 * The second train of thought for two-sum is, without changing the array, can we use additional space somehow?
 * Like maybe a hash map to speed up the search?
 */
public class Day8ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> resultList = threeSum(nums);
        for (List<Integer> result : resultList) {
            for (Integer num : result) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int sum = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                }
            }
        }

        return result;
    }
}
