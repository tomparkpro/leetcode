package pro.tompark.leetcode.days30.may;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Day14ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    static class Trie {
        Set<String> set;

        /** Initialize your data structure here. */
        public Trie() {
            set = new HashSet<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            set.add(word);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return set.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            boolean found = false;

            for (String word : set) {
                if (word.startsWith(prefix)) {
                    found = true;
                    break;
                }
            }

            return found;
        }
    }
}