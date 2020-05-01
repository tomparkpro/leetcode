package pro.tompark.leetcode.days30.april;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Day4MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        nums = new int[]{0, 0, 1};
        nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println();
        moveZeroes2(nums);
    }

    /**
     * Input:  [0, 1, 0, 3, 12]
     * Output: [1, 3, 12, 0, 0]
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZeroes2(int[] nums) {
        int nonzeroNumIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonzeroNumIndex] = nums[i];
                nonzeroNumIndex++;
            }
        }

        for (int i = nonzeroNumIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
