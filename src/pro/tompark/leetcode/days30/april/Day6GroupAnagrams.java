package pro.tompark.leetcode.days30.april;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Day6GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = groupAnagrams2(strs);
        lists.forEach(list -> {
            list.forEach(str -> {
                    System.out.print(str + " ");
            });
            System.out.println();
        });

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();

            List<Integer> chList = new ArrayList<>();
            for (char ch : chars) {
                chList.add(Integer.valueOf(ch));
            }
            Collections.sort(chList);
            String key = "";
            for (Integer ch : chList) {
                key = key + ch;
            }

            List<String> anagramList = anagramMap.get(key);
            if (anagramList == null) {
                anagramList = new ArrayList<>();
                anagramList.add(str);
                anagramMap.put(key, anagramList);
            } else {
                anagramList.add(str);
            }
        }

        anagramMap.forEach((k, v) -> groups.add(v));

        return groups;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (anagramMap.containsKey(key)) {
                List<String> anagramList = anagramMap.get(key);
                anagramList.add(str);
                anagramMap.put(key, anagramList);
            } else {
                List anagramList = new ArrayList<>();
                anagramList.add(str);
                anagramMap.put(key, anagramList);
            }
        }

        anagramMap.forEach((k, v) -> groups.add(v));

        return groups;
    }
}
