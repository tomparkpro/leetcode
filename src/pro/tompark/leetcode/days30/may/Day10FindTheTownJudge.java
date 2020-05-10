package pro.tompark.leetcode.days30.may;

/**
 * Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class Day9ValidPerfectSquare {

    public static void main(String[] args) {
        int num = 16; // true
//        num = 14; // false
//        num = 808201; // true
        num = 2147395600; // true

        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        if (num == 1) return true;

        boolean isPerfectSquare = false;
        long lo = 1;
        long hi = num;

        while (lo <= hi) {
            long mi = lo + (hi - lo) / 2;
            long result = mi * mi;
            if (result == num) {
                isPerfectSquare = true;
                break;
            } else if (result < num) {
                lo = (int)mi + 1;
            } else {
                hi = (int)mi - 1;
            }
        }

        return isPerfectSquare;
    }

}