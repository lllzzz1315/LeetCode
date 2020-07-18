package com.lzk.toutiao.ArrayToSort;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 21:49
 * 最长连续递增序列
 */
public class ArrayToSort3 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int max = 0;
        int tmp = 1; //需要一个临时变量记录
        for(int i = 1; i < len; i++) {
            if(nums[i - 1] >= nums[i]) {
                max = Math.max(max, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        return Math.max(tmp, max);

    }
}
