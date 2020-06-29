package com.lzk.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/22 21:41
 */
public class huiwen {
    //重新排列后，是否是回文
    public static boolean canPermutePalindrome(String s) {
        int[] x = new int[256];
        for (char tmp : s.toCharArray()) {
            x[tmp]++;
        }
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println(1%2);
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0 ) return 0;
        int[] dp = new int[nums.length ];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
