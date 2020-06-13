package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/13 17:43
 * 70.爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 斐波那切数列 --- 基本动态规划问题
 */
public class Easy70 {
    //暴力破解法-----容易超出时间限制
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }  else {
            return climbStairs(n - 2) + climbStairs(n - 1);
        }
    }
    //非暴力破解法，利用斐波那切数列前两项之和 = 第三项的特性
    public int climbStairs1(int n) {
        int[] x = new int[n + 1];
        x[0] = 1;
        x[1] = 1;
        for(int i = 2; i <= n; i++) {
            x[i] = x[i - 1] + x[i -2];
        }
        return x[n];
    }
}
