package com.lzk.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
}
