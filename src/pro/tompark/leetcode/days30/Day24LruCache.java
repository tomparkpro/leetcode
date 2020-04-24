package pro.tompark.leetcode.days30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 ); // capacity
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class Day24LruCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 10 /* capacity */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

//        cache.put(2, 1);
//        cache.put(1, 1);
//        cache.put(2, 3);
//        cache.put(4, 1);
//        System.out.println(cache.get(1));       //
//        System.out.println(cache.get(2));       //

        cache.put(7, 28);
        cache.put(7, 1);
        cache.put(7, 15);
        cache.get(6);
        cache.put(10, 27);
        cache.put(8, 10);
        cache.get(8);
        cache.put(6, 29);
        cache.put(1, 9);
        cache.get(6);
        cache.put(10, 7);
        cache.get(1);
        cache.get(2);
        cache.get(13);
        cache.put(8, 30);
        cache.put(1, 5);
        cache.get(1);
        cache.put(1, 13);
        cache.get(12);
    }

    public static class LRUCache {

        int capacity;
        Map<Integer, Node> map;
        // head is old and tail is new one.
        Node head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;

            if (node != tail) {
                if (node == head) {
                    head = node.next;
                    head.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }

            return  node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                // add new node
                node = new Node(key, value);
                if (capacity == 0) {
                    map.remove(head.key);
                    head = head.next;
                    capacity++;
                }
                if (head == null) {
                    head = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                }
                tail = node;
                map.put(key, node);
                capacity--;
            } else {
                node.val = value;
                if (node != tail) {
                    if (node == head) {
                        head = head.next;
                        head.prev = null;
                    } else {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    }
                    tail.next = node;
                    node.prev = tail;
                    node.next = null;
                    tail = node;
                }
            }
        }

        class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static class LRUCache2 {

        Map<Integer, Integer> cache = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();
        int capacity;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int keyIdx = 0;
                for (int i = 0; i < keyList.size(); i++) {
                    if (key == keyList.get(i)) {
                        keyIdx = i;
                        break;
                    }
                }
                keyList.remove(keyIdx);
                keyList.add(key);
                return cache.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                get(key);
            } else {
                if (cache.size() >= capacity && keyList.size() > 0) {
                    int oldKey = keyList.get(0);
                    cache.remove(oldKey);
                    keyList.remove(0);
                }
                cache.put(key, value);
                keyList.add(key);
            }
        }
    }
}