package pro.tompark.leetcode.days30.june;

/**
 * Sort Colors
 *
 *
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 */
public class Day11SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    static void sortColors(int[] nums) {
        int p0 = 0, p = 0, p2 = nums.length - 1;

        while (p <= p2) {
            if (nums[p] == 2) {
                swap(nums, p, p2);
                p2--;
            } else if (nums[p] == 0) {
                swap(nums, p, p0);
                p0++;
                p++;
            } else {
                p++;
            }
        }
    }

    private static void swap(int[] nums, int p1, int p2) {
        int temp = nums[p2];
        nums[p2] = nums[p1];
        nums[p1] = temp;
    }

    static void sortColors2(int[] nums) {
        int r = 0, w = 0;

        for (int num : nums) {
            if (num == 0) r++;
            else if (num == 1) w++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < r) nums[i] = 0;
            else if(i < r + w) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
