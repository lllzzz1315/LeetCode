package com.lzk.toutiao.ArrayToSort;

import java.util.PriorityQueue;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 21:58
 */
public class ArrayToSort4 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int tmp : nums) {
            queue.add(tmp);
            if(queue.size() > k) {
                queue.poll();
            }

        }
        return queue.peek();
    }
}
