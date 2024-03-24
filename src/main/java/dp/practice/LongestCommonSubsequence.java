package dp.practice;

public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {
        int[][] mem = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                mem[i][j] = -1;
            }
        }
        return backtraceHelper(text1.toCharArray(), text2.toCharArray(), 0, 0, mem);
    }

    private int backtraceHelper(char[] text1Chars, char[] text2Chars, int t1Index, int t2Index, int[][] mem) {
        if (t1Index >= text1Chars.length || t2Index >= text2Chars.length) {
            return 0;
        }
        if (mem[t1Index][t2Index] != -1) {
            return mem[t1Index][t2Index];
        }
        if (text1Chars[t1Index] == text2Chars[t2Index]) {
            return 1 + backtraceHelper(text1Chars, text2Chars, t1Index + 1, t2Index + 1, mem);
        } else {
            int option1 = backtraceHelper(text1Chars, text2Chars, t1Index, t2Index + 1, mem);
            int option2 = backtraceHelper(text1Chars, text2Chars, t1Index + 1, t2Index, mem);
            return Math.max(option1, option2);
        }
    }
}
