package pro.tompark.leetcode.days30;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 *    Hide Hint #1
 * Will Brute force work here? Try to optimize it.
 *    Hide Hint #2
 * Can we optimize it by using some extra space?
 *    Hide Hint #3
 * What about storing sum frequencies in a hash table? Will it be useful?
 *    Hide Hint #4
 * sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
 * Can we use this property to optimize it.
 */
public class Day22SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        nums = new int[]{1, 2, 3};
//        nums = new int[]{28,54,7,-70,22,65,-6};
//        nums = new int[]{0,0,0,0,0,0,0,0,0,0};
        int k = 2;
        k = 3;
//        k = 100;
//        k = 0;

        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(sum, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
