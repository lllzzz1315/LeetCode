package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/22 21:17
 * 位运算
 */
public class weiyunsuan {

    /*
    * 相关概念：
    *  & 按位与
    * >> 表示右移，如果为正数，高位补0，如果为负数，高位补1
    * >>> 表示无符号右移，无论什么情况下，都高位补0
    * */
    //n的二进制中，有都少个1

    // 0&0=0; 0&1=0; 1&0=0; 1&1=1;
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //n & 1 = n % 2
            count += n & 1;
            n >>>= 1;
            System.out.println(n);
        }
        return count;
    }



}
