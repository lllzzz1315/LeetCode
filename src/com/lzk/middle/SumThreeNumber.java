package com.lzk.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/1 21:40
 */
public class SumThreeNumber {
    //三数之和
    //暴力法 （绝对超时）
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //边界值情况
        if (nums == null || nums.length < 3) {
            return result;
        }
        //先排序
        Arrays.sort(nums);
        //固定一个参数
        for (int i = 0 ; i < nums.length; i++) {

            if(nums[i] > 0) { // 该数字大于0，则循环可以直接结束
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //相同数字只遍历一次
                continue;
            }
            //校验另外两个
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]);
                } else if(sum < 0){
                    while (left < right && nums[left] == nums[++left]);
                } else {
                    List<Integer> integers = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(integers);
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return result;

    }
}
