package pro.tompark.leetcode.days30.july;

/**
 * Plus One
 *
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Day6PlusOne {

    public static void main(String[] args) {
//        int[] digits = {1, 2, 3};
        int[] digits = {9, 9, 9};
//        int[] digits = {8, 9, 9};

        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static int[] plusOne(int[] digits) {
        // plus one the digits in reverse order
        for (int i = digits.length - 1; i >= 0; i--) {
            // check if the digit is 9
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        // in this case, all digits are 9
        int[] result = new int[digits.length + 1];
        // rest of values are 0s
        result[0] = 1;
        return result;
    }
}
