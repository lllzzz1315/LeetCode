package com.lzk.toutiao.ArrayToSort;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/18 21:37
 * 搜索旋转排序数组
 */
public class ArrayToSort2 {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0; int mid; int end = nums.length - 1;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
