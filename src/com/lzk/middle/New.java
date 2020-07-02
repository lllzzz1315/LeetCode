package com.lzk.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/30 23:25
 */
public class New {

    //无重复的最长子串
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0 ;i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.offer(s.charAt(i));
            max = Math.max(max, queue.size());
        }
        return max;
    }




}
