package com.lzk.easy;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;  //总次数

        Queue<Character> queue = new LinkedList<>();

        char[] tmp = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            while (queue.contains(tmp[i])) {
                queue.poll();
            }
            queue.offer(tmp[i]);
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public static boolean rotateString(String A, String B) {
        if(A.length() != B.length()) {
            return false;
        }

        if((A + A).contains(B)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }

}

class TreeNode {
    int val;
    com.lzk.TreeNode left;
    com.lzk.TreeNode right;
    TreeNode(int x) { val = x; }
}
