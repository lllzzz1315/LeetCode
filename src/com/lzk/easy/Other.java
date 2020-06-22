package com.lzk.easy;

import java.text.DecimalFormat;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/22 21:46
 */
public class Other{
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 2;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}
