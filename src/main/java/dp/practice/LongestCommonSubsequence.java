package dp.practice;

public class LongestCommonSubsequence {

    private int max;

    public int longestCommonSubsequence(String text1, String text2) {
        backtraceHelper(text1.toCharArray(), text2.toCharArray(), 0, 0, 0);
        return max;
    }

    private void backtraceHelper(char[] text1Chars, char[] text2Chars, int t1Index, int t2Index, int lcsCount) {
        if (t1Index >= text1Chars.length || t2Index >= text2Chars.length) {
            max = Math.max(max, lcsCount);
            return;
        }
        if (text1Chars[t1Index] == text2Chars[t2Index]) {
            lcsCount++;
            backtraceHelper(text1Chars, text2Chars, t1Index + 1, t2Index + 1, lcsCount);
        } else {
            backtraceHelper(text1Chars, text2Chars, t1Index, t2Index + 1, lcsCount);
            backtraceHelper(text1Chars, text2Chars, t1Index + 1, t2Index, lcsCount);
        }
    }
}
