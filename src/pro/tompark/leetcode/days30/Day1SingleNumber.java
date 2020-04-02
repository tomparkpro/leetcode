package pro.tompark.leetcode.days30;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Day1SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums2));
    }

    public static int singleNumber(int[] nums) {
        int a =0;
        for(int i:nums)
        {
            a^=i;
        }
        return a;
    }

    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        return iterator.next();
    }
}
