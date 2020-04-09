package pro.tompark.leetcode.days30;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class Day9BackspaceStringCompare {

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";

        S = "ab##";
        T = "c#d#";

        S = "a##c";
        T = "#a#c";

        S = "a#c";
        T = "b";

        System.out.println(backspaceCompare2(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        if (S == null || S.length() < 1 || S.length() > 200 ||
            T == null || T.length() < 1 || T.length() > 200) {
            return false;
        }

        int sLength = S.length();
        int tLength = T.length();
        int length = sLength > tLength ? sLength : tLength;

        char[] sArr = new char[sLength];
        char[] tArr = new char[tLength];

        int sIndex = 0;
        int tIndex = 0;
        for (int i = 0; i < length; i++) {
            if (i < sLength) {
                char ch = S.charAt(i);
                if (ch != '#') {
                    sArr[sIndex] = ch;
                    sIndex++;
                } else {
                    if (sIndex > 0) {
                        sIndex--;
                        sArr[sIndex] = 0;
                    }
                }
            }
            if (i < tLength) {
                char ch = T.charAt(i);
                if (ch != '#') {
                    tArr[tIndex] = ch;
                    tIndex++;
                } else {
                    if (tIndex > 0) {
                        tIndex--;
                        tArr[tIndex] = 0;
                    }
                }
            }
        }

        String newS = (new String(sArr)).trim();
        String newT = (new String(tArr)).trim();
        return newS.equals(newT);
    }

    public static boolean backspaceCompare2(String s, String t) {
        int cntS = 0;
        int cntT=  0;
        int indexS = s.length() - 1;
        int indexT = t.length() - 1;
        while(indexS >= 0 || indexT >= 0){
            //System.out.println(indexS + " " + indexT);
            while(indexS >= 0 && (s.charAt(indexS) == '#' || cntS > 0)){
                if(s.charAt(indexS) == '#')
                    cntS ++;
                else
                    cntS--;
                indexS--;
            }
            while(indexT >= 0 && (t.charAt(indexT) == '#' || cntT > 0)){
                if(t.charAt(indexT) == '#')
                    cntT ++;
                else
                    cntT--;
                indexT--;
            }
            if(indexS == -1 && indexT == -1)
                return true;
            if(indexS == -1 || indexT == -1)
                return false;
            if(s.charAt(indexS) != t.charAt(indexT))
                return false;
            indexS--;
            indexT--;

        }

        return true;
    }
}
