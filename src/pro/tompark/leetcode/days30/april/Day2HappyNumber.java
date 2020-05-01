package pro.tompark.leetcode.days30.april;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Day2HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        n = 2;
        System.out.println(isHappy(n));
    }

    /**
     * Input: 19
     * 1^2 + 9^2 = 82
     *
     * check the digits of 10^0 10^1 10^2 ...
     * squares the digits and get the sum
     * check the sum is 1 or repeat
     */
    public static boolean isHappy(int n) {
        if (n < 1) { // Starting with any positive integer
            return false;
        }

        boolean isHappy = false;
        int sum = 0;
        Set<Integer> sumHistory = new HashSet<>();

        while (true) {
            do {
                int lastDigit = n % 10;
                sum = sum + lastDigit * lastDigit;
                n = n / 10;
            } while (n != 0);

            if (sum == 1) {
                isHappy = true;
                break;
            } else if (sumHistory.contains(sum)) {
                break;
            } else {
                sumHistory.add(sum);
                n = sum;
                sum = 0;
            }
        }

        return isHappy;
    }
}
