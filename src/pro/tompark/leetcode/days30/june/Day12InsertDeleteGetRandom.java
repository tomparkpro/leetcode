package pro.tompark.leetcode.days30.june;

import java.util.*;

/**
 * Insert Delete GetRandom O(1)
 *
 * Solution
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 */
public class Day12InsertDeleteGetRandom {

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }

    static class RandomizedSet {
        List<Integer> list;
        Map<Integer, Integer> dict;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            dict = new HashMap<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;
            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;
            int idx = dict.get(val);
            int lastElement = list.get(list.size() - 1);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    static class RandomizedSet2 {
        Set<Integer> set;
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet2() {
            set = new HashSet<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            } else {
                set.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                return true;
            } else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = random.nextInt(set.size());
            Object[] objects = set.toArray();
            return (int)objects[idx];
        }
    }
}
