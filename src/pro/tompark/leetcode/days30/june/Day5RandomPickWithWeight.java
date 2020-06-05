package pro.tompark.leetcode.days30.june;

/**
 * Random Pick with Weight
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument,
 * the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Day5RandomPickWithWeight {

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        Solution obj = new Solution(w);
        for (int i = 0; i < 50; i++) {
            System.out.println(obj.pickIndex());
        }
    }

    static class Solution {
        int[] sumArr;

        public Solution(int[] w) {
            sumArr = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                sumArr[i] = sum;
            }
        }

        public int pickIndex() {
            double num = sumArr[sumArr.length - 1] * Math.random();
            int res = -1;
            int si = 0, ei = sumArr.length - 1;

            while (si <= ei) {
                int mi = si + (ei - si) / 2;
                if (num < sumArr[mi]) {
                    res = mi;
                    ei = mi - 1;
                } else {
                    si = mi + 1;
                }
            }

            return res;
        }

        public int pickIndex2() {
            double num = sumArr[sumArr.length - 1] * Math.random();
            for (int i = 0; i < sumArr.length; i++) {
                if (num < sumArr[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
}
