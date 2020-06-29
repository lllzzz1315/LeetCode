package com.lzk.middle;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/29 21:14
 */
public class zifuchuan {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    //最长回文子串
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (s.length() < 2) {
            return s;
        }

        String result = "";
        //最长长度
        int maxLen = 1;

        //1.定义dp函数--从i-j是回文串
        boolean[][] dp = new boolean[len][len];

        //对角线是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //3.给出dp方程
        for(int j =0 ;j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 2) {
                        dp[i][j] = true;//2个数的情况且相同
                    } else {
                        //不是2个数的情况----看他的子串是否是回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //dp[i][j] = true表示回文成立， j - i + 1 则表示最新的回文长度，取最场的那个
                if(dp[i][j]) {
                    maxLen = i - j + 1;
                    result = s.substring(i, maxLen);
                    System.out.println(result);
//                    if(j - i + 1 > maxLen) {
//                        maxLen = j - i + 1;
//                        result = s.substring(i, maxLen);
//                    }
                }
            }
        }
        return result;

    }


    //无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        //利用滑动窗口来实现---队列
        int max = 0;

        int len = s.length();
        if (len < 2) {
            return len;
        }

        Queue<Character> queue = new LinkedList<>();
        for (char tmp: s.toCharArray()) {
            while (queue.contains(tmp)) {
                queue.poll();
            }
            queue.offer(tmp);
            max = Math.max(max, queue.size());
        }
        return max;
    }


}
