package com.lzk.hard;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/28 20:59
 */

public class zifuchuan {
    //dp 最长回文字符串
    public String longestPalindrome(String s) {
        //1.给出边界值
        int len = s.length();
        if (len == 0) {
            return null;
        } else if(len == 1) {
            return s;
        }

        int maxLen = 1; //回文长度
        int begin = 0; //开始索引


        //2.定义dp数组--第i到第j个子串是回文子串
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;//单个字符必然是子串
        }



        //3.给出dp方程
        for(int j =0 ;j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;//2个数的情况且相同
                    } else {
                        //不是2个数的情况----看他的子串是否是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //dp[i][j] = true表示回文成立， j - i + 1 则表示最新的回文长度，取最场的那个
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        //最终裁剪一下
        return s.substring(begin, begin + maxLen);
    }
}
