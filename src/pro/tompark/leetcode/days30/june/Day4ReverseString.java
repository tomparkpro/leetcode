package pro.tompark.leetcode.days30.june;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Reverse String
 *
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *    Hide Hint #1
 * The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
 */
public class Day4ReverseString {

    public static void main(String[] args) {
        String s = "hello";

        reverseString(s.toCharArray());
    }

    public static void reverseString(char[] s) {
        for(int st = 0, ed = s.length - 1; st < ed; st++, ed--) {
            char temp = s[st];
            s[st] = s[ed];
            s[ed] = temp;
        }

        System.out.println(s);
    }

}
