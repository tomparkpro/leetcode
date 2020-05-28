package pro.tompark.leetcode.days30.may;

/**
 * Counting Bits
 *
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 *    Hide Hint #1
 * You should make use of what you have produced already.
 *    Hide Hint #2
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 *    Hide Hint #3
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 */
public class Day27CountingBits {

    public static void main(String[] args) {
        int num = 5;

        int[] counts = countBits(num);
        for (int count : counts) {
            System.out.print(count + " ");
        }
    }

    public static int[] countBits(int num) {
        int[] counts = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            counts[i] = counts[i >> 1] + i % 2;
        }

        return counts;
    }

    public static int[] countBits2(int num) {
        int[] counts = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            int count = 0;
            int x = i;
            while (x > 0) {
                int x2 = x >> 1;
                x2 = x2 << 1;
                if (x > x2) count++;
                x = x >> 1;
            }

            counts[i] = count;
        }

        return counts;
    }
}