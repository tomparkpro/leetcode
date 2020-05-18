package pro.tompark.leetcode.days30.may;

import java.util.Arrays;

/**
 *  Permutation in String
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 *
 * The length of both given strings is in range [1, 10,000].
 *    Hide Hint #1
 * Obviously, brute force will result in TLE. Think of something else.
 *    Hide Hint #2
 * How will you check whether one string is a permutation of another string?
 *    Hide Hint #3
 * One way is to sort the string and then compare. But, Is there a better way?
 *    Hide Hint #4
 * If one string is a permutation of another string then they must one common metric. What is that?
 *    Hide Hint #5
 * Both strings must have same character frequencies, if one is permutation of another. Which data structure should be used to store frequencies?
 *    Hide Hint #6
 * What about hash table? An array of size 26?
 */
public class Day18PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.print(checkInclusion(s1, s2));
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;
        boolean inclusion = false;

        int[] s1Chars = new int[26];
        int[] s2Chars = new int[26];
        for (char c : s1.toCharArray()) {
            s1Chars[c - 'a']++;
        }
        int  s1Len = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            s2Chars[s2.charAt(i) - 'a']++;

            if (i >= s1Len) {
                s2Chars[s2.charAt(i - s1Len) - 'a']--;
            }

            if (Arrays.equals(s1Chars, s2Chars)) {
                inclusion = true;
                break;
            }
        }

        return inclusion;
    }
}