package pro.tompark.leetcode.days30;

import java.util.Arrays;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 *
 * Example 1:
 * Input: "()"
 * Output: True
 *
 * Example 2:
 * Input: "(*)"
 * Output: True
 *
 * Example 3:
 * Input: "(*))"
 * Output: True
 *
 * Note:
 * The string size will be in the range [1, 100].
 */
public class Day16ValidParenthesisString {

    public static void main(String[] args) {
        String s = "()";
        s = "(*)"; // t
        s = "(*))"; // t
        s = ")("; // f
        s = "()()"; // t

        System.out.print(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        if (s == null || s.length() < 1 || s.length() > 100) return false;
        boolean isValid = true;

        char[] prs = s.toCharArray();
        int len = prs.length;
        int limit = (len % 2 == 0) ? len/2 : len/2 + 1;

        for (int i = 0; i < limit; i++) {
            char start = prs[i];
            char end = prs[len - i -1];
            if (start == '(') {
                if (end == '(') {
                    isValid = false;
                    break;
                }
            } else if (start == ')') {
                isValid = false;
            } else if (start == '*') {
            }
        }

        return isValid;
    }
}
