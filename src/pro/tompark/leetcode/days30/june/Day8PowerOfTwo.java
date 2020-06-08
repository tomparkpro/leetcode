package pro.tompark.leetcode.days30.june;

/**
 * Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class Day8PowerOfTwo {

    public static void main(String[] args) {
        int n = 1;

        System.out.println(isPowerOfTwo(n));
    }

    static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    static boolean isPowerOfTwo2(int n) {
        if (n < 1) return false;

        boolean isPowerOfTwo = true;
        while (n > 1) {
            int x = n >> 1;
            x = x << 1;
            if (x != n) {
                isPowerOfTwo = false;
                break;
            }
            n = n >> 1;
        }

        return isPowerOfTwo;
    }
}
