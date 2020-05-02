package pro.tompark.leetcode.days30.may;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *    Hide Hint #1
 * For each stone, check if it is a jewel.
 */
public class Day2JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        J = "z";
        S = "ZZ";

        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;

        Set<Character> jewelSet = new HashSet<>();
        char[] jewels = J.toCharArray();
        for (char jewel : jewels) {
            jewelSet.add(jewel);
        }

        int num = 0;
        char[] stones = S.toCharArray();
        for (char stone : stones) {
            if (jewelSet.contains(stone)) {
                num++;
            }
        }

        return num;
    }
}
