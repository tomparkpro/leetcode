package pro.tompark.leetcode.days30.april;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class Day23BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        int m = 5;
        int n = 7;

//        m = 0;
//        n = 1;

//        m = 0;
//        n = 2147483647;

        System.out.println(rangeBitwiseAnd(m, n));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int count = 0;

        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            count ++;
        }

        return m << count;
    }

    public static int rangeBitwiseAnd2(int m, int n) {
        int num = m;
        for (int i = m + 1; i <= n ; i++) {
            num = num & i;
        }
        return num;
    }
}