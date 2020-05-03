package pro.tompark.leetcode.days30.may;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Day3RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        ransomNote = "a";
        magazine = "b";

        ransomNote = "aa";
        magazine = "bb";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;

        Map<Character, Integer> ransomMap = new HashMap<>();
        for(char ransom : ransomNote.toCharArray()) {
            Integer count = ransomMap.getOrDefault(ransom, 0);
            ransomMap.put(ransom, count + 1);
        }

        for(char mag : magazine.toCharArray()) {
            if(ransomMap.containsKey(mag)) {
                int count = ransomMap.get(mag) - 1;
                if (count == 0) {
                    ransomMap.remove(mag);
                } else {
                    ransomMap.put(mag, count);
                }
            }
        }

        return ransomMap.size() == 0;
    }
}