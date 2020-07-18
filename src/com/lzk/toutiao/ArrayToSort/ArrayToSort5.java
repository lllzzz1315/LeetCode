package com.lzk.toutiao.ArrayToSort;

import java.util.HashSet;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 22:17
 * 最长连续序列
 */
public class ArrayToSort5 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int tmp : nums) set.add(tmp);

        int max = 0;
        for(int num: nums) {
            if(!set.contains(num - 1)) {  //不存在的话，在计算，不然重复了
                int count = 0;
                while(set.contains(num)) {
                    count++;
                    num += 1;
                }
                max = Math.max(max, count);
            }

        }
        return max;
    }
}
