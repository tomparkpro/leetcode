package pro.tompark.leetcode.days30.june;

/**
 * Is Subsequence
 *
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * Both strings consists only of lowercase characters.
 */
public class Day9IsSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
//        String s = "axc";
//        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        if (s.charAt(0) == t.charAt(0)) return isSubsequence(s.substring(1),t.substring(1));
        return isSubsequence(s, t.substring(1));
    }

    static boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length()) return false;

        char[] tArr = t.toCharArray();
        int tIdx = 0;
        int count = 0;
        for (char cs : s.toCharArray()) {
            for (int i = tIdx; i < tArr.length; i++) {
                if (cs == tArr[i]) {
                    tIdx = i + 1;
                    count++;
                    break;
                }
            }
        }

        return s.length() == count;
    }
}
