package pro.tompark.leetcode.days30.may;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class Day1FirstBadVersion {

    public static void main(String[] args) {

        System.out.println(firstBadVersion(3));
        System.out.println(firstBadVersion(4));
        System.out.println(firstBadVersion(5));
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        int start = 1, end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static int firstBadVersion2(int n) {
        if (n == 1) return n;
        return findBadVersion(1, n);
    }

    private static int findBadVersion(int start, int end) {
        int diff = end - start;
        if (diff == 0) {
            return start;
        } else if (diff == 1) {
            if (isBadVersion(start)) {
                return start;
            } else {
                return end;
            }
        }

        int mid = start + diff / 2;
        if (isBadVersion(mid)) {
            return findBadVersion(start, mid);
        } else {
            return findBadVersion(mid + 1, end);
        }
    }

    private static boolean isBadVersion(int n) {
        return n >= 3;
    }
}
