package pro.tompark.leetcode.days30.may;

/**
 * Remove K Digits
 *
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 *
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Day13RemoveKDigits {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        num = "10200";
        k = 1;

        System.out.print(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        int i = 0;
        while (k > 0) {
            i = (i > 0) ? (i -1) : 0;
            while (i < num.length() - 1 && num.charAt(i) <= num.charAt(i + 1)) {
                i++;
            }
            num = num.substring(0, i) + num.substring(i + 1);
            k--;
        }

        i = 0;
        while (i < num.length() && num.charAt(i) == '0')
            i++;
        if (i > 0 && num.length() > 1) {
            num = num.substring(i);
        }

        if (num.length() == 0) {
            return "0";
        } else {
            return num;
        }
    }
}