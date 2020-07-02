package com.lzk.hard;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/30 21:24
 */
public class dongtaiguihua {


    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        if (t1.length == 0 || t2.length == 0) {
            return 0;
        }

        int[][] dp = new int[t1.length + 1][t2.length + 1];

        for (int i = 1 ; i < t1.length; i++) {
            for (int j = 1 ; j < t2.length; j++) {
                if (t1[i] == t2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}
