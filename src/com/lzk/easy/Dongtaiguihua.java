package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/27 19:24
 */
public class Dongtaiguihua {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //大于2的情况下（边界值），才可以执行斐波那切数列
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
    //爬梯子3阶段
    public int waysToStep(int n) {
        int[] dp = new int[n];
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else if(n==3){
            return 4;
        }
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i=3;i<n;i++){
            //取模逻辑略混乱
            dp[i] = (dp[i-1]+(dp[i-2]+dp[i-3])%1000000007)%1000000007;
            //也可以是  dp[i] = (dp[i-1]%1000000007+(dp[i-2]+dp[i-3])%1000000007)%1000000007;
            //注意这里是为了防止溢出
        }
        return dp[n-1];
    }

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        //1.定义dp数组
        int[] dp = new int[nums.length];
        //2.给出初始值
        dp[0] = nums[0];
        int max = dp[0];
        //3.定义边界 > 1情况
        for(int i = 1; i < nums.length; i++) {
            //转换方程 dp[i] = dp[i - 1] + x
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
