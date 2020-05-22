package pro.tompark.leetcode.days30.may;

import java.util.*;

/**
 * Sort Characters By Frequency
 *
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 *
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 *
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class Day22SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList(counts.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder result = new StringBuilder(list.size());
        for (Map.Entry<Character, Integer> es : list) {
            for (int i = 0; i < es.getValue(); i++) {
                result.append(es.getKey());
            }
        }

        return result.toString();
    }

    public static String frequencySort2(String s) {
        if (s == null || s.length() < 2) return s;

        int[] chars = new int[128];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        int[] counts = Arrays.copyOf(chars, chars.length);
        Arrays.sort(counts);

        StringBuilder builder = new StringBuilder();
        for (int i = counts.length - 1; i >= 0; i--) {
            int count = counts[i];
            if (count == 0) break;

            for (int j = 0; j < chars.length; j++) {
                if (count == chars[j]) {
                    for (int k = 0; k < count; k++) {
                        builder.append((char)(j));
                    }
                    chars[j] = 0;
                    break;
                }
            }
        }

        return builder.toString();
    }
}