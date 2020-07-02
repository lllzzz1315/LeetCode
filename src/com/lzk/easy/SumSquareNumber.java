package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/1 22:31
 * 633.平方数据之和
 */
public class SumSquareNumber {
    public boolean judgeSquareSum(int c) {
        if(c < 3) {
            return true;
        }
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right) {
            int sum = left * left + right * right;

            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
