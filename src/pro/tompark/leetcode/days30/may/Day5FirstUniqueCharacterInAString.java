package pro.tompark.leetcode.days30.may;

import java.util.HashMap;
import java.util.Map;

/**
 * First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class Day5FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "leetcode";
        s = "loveleetcode";

        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] arr = new int[26];
        int idx = -1;

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            arr[ch-'a'] = arr[ch-'a'] + 1;
        }

        for (int i = 0; i < chars.length ; i++) {
            if (arr[chars[i]-'a'] == 1) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    public static int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Node> map = new HashMap<>();
        Node head = null;
        Node tail = null;
        int idx = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                Node node = map.get(ch);
                node.count = node.count + 1;
            } else {
                Node node = new Node(i);
                map.put(ch, node);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
        }

        while (head != null) {
            if (head.count == 1) {
                idx = head.idx;
                break;
            } else {
                head = head.next;
            }
        }

        return idx;
    }

    static class Node {
        int idx;
        int count;
        Node next;

        public Node(int idx) {
            this.idx = idx;
            this.count = 1;
        }
    }
}