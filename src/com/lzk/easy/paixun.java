package com.lzk.easy;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/29 22:49
 */
public class paixun {
    public static void main(String[] args) {
        sortArray(new int[]{5,1,1,2,0,0});
    }


    public static int[] sortArray(int[] nums) {
        if(nums.length < 2) {
            return nums;
        }

        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int left, int right) {

        if (left <right) {
            int mid = getMid(nums, left, right);
            //mid不需要排序
            sort(nums, left, mid - 1);
            sort(nums, mid + 1, right);
        }
    }


    private static int getMid(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (right > left) {
            while (right > left &&nums[right] >= tmp) {
                right--;
            }
            nums[left] = nums[right];
            while (right > left && nums[left] <= tmp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = tmp;
        return right;
    }
}
