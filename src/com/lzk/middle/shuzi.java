package com.lzk.middle;

import java.util.*;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/28 21:38
 */
public class shuzi {


    //数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> integers = new PriorityQueue<>();
        for (int tmp : nums) {
            integers.add(tmp);
            if (integers.size() > k) {
                //将队列首个元素弹出
                integers.poll();
            }
        }
        //查看首个元素是什么
        return integers.peek();
    }

    /*
    * 给出一个区间的集合，请合并所有重叠的区间。
    */
    //合并区间
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }
        //对数组按照首数字排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();
        //遍历List
        for (int i = 0; i < intervals.length; i++) {
            //右边大于左边
            int left = intervals[i][0];
            int right = intervals[i][1];
            //        i的取值范围                     右边大于下一个左边
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[0][]);
    }
}
