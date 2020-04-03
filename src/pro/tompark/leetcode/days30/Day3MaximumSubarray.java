package pro.tompark.leetcode.days30;

import java.util.HashSet;
import java.util.Set;

/**
 *  Given an integer array nums,
 *  find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *  Example:
 *
 *  Input: [-2,1,-3,4,-1,2,1,-5,4],
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 *  Follow up:
 *
 *  If you have figured out the O(n) solution,
 *  try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Day3MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    /**
     *
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int index = 0;
        // assume the first num is the largest
        int largest = nums[index];

        // Input: [-2,1,-3,4,-1,2,1,-5,4],
        // Output: 6
        // Explanation: [4,-1,2,1] has the largest sum = 6.
        do {
            int subSum = 0;
            int preLargest = largest;

            for (int i = index; i < nums.length; i++) {
                subSum += nums[i];
                if (subSum >= largest) {
                    largest = subSum;
                } else if (subSum < preLargest) {
                    break;
                }
            }

            index++;
        } while (index < nums.length);

        return largest;
    }

    public static int maxSubArray2(int[] nums) {
        int left = 0;
        int right = 1;
        int max = nums[left];
        int sum = nums[left];

        if (nums.length == 1)
            return nums[0];

        while (right < nums.length && left < nums.length) {
            if ((sum + nums[right]) < nums[right]) {
                left = right;
                sum = nums[right];
                if(nums[right] > max) {
                    max = nums[right];
                }
            } else {
                sum += nums[right];
                if(sum > max){
                    max = sum;
                }
            }
            right ++;
        }

        return max;
    }
}
