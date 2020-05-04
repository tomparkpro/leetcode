package pro.tompark.leetcode.days30.may;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 *
 *
 * Example 2:
 *
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits),
 * and its complement is 0. So you need to output 0.
 *
 *
 * Note:
 *
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/Given
 */
public class Day4NumberComplement {

    public static void main(String[] args) {
        int num = 0;
        num = 1;
        num = 2;
        num = 3;
        num = 4;
        num = 5;
        num = 6;
        num = 9;

        System.out.println(findComplement(num));
    }

    public static int findComplement(int num) {
        if (num == 0) return 1;
        int numOfBits = (int) (Math.log(num) / Math.log(2)) + 1;
        int mask = (1 << numOfBits) - 1;

        return num ^ mask;
    }

    public static int findComplement1(int num) {
        if (num == 0) return 1;
        int copy = num;
        int ones = 0;

        while(copy > 0){
            ones = (ones << 1) + 1;
            copy >>= 1;
        }

        return num ^ ones;
    }

    public static int findComplement2(int num) {
        int allOne = 1;
        int num2 = num;
        for (int i = 1; num2 > 1; i++) {
            allOne += Math.pow(2, i);
            num2 /= 2;
        }

        return num ^ allOne;
    }
}