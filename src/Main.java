import com.lzk.easy.Easy70;
import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Easy70 easy70 = new Easy70();
//        System.out.println(easy70.climbStairs1(44) % 1000000007);

//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        String[] str = {"flower","flow","flight"};;
        System.out.println(longestCommonPrefix(str));

    }

    //删除链表及节点
    public ListNode deleteNode(ListNode head, int val) {
        //新建一个链表指针，将记录第一个指针的位置。
        ListNode result = new ListNode(-1);
        result.next = head;
        if (head == null) {
            return null;
        }
        //头节点情况下，需要单独处理
        if(head.val == val) {
            return head.next;
        }
        //头节点没问题情况下，他的next的值开始校验
        while (head.next.val != val) {
            head = head.next;
        }
        head.next = head.next.next;
        return result.next;
    }

    //求最长无重复子串（利用滑动窗口来进行处理）
    public static int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if(len == 0) {
            return 0;
        }
        if(len == 1) {
            return 1;
        }
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 1;
        set.add(s.charAt(i));
        while(i < len && j < len) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(j - i, max);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    //最长公共前缀
    public static String longestCommonPrefix(String[] strs) {

        int len = strs.length; //数组长度
        String result = "";

        if(len > 0) {
            result = strs[0];
        }

        for(int i = 0; i < len; i++) {  //遍历数组
            while(!strs[i].startsWith(result)) { //判断数组的前缀是否是该字符串
                result = result.substring(0, result.length() - 1);  //不是的情况下，对字符串后部进行-1处理
            }
        }
        return result;
    }

    //数组中两数之和
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target && (i != j)) {
                    int[] result = {i,j};
                    return result;
                }
            }
        }
        int[] result = new int[0];
        return result;
    }

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
    //超过半数的数字
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        int len = nums.length;
        for(int t : nums) {
            map.put(t, map.containsKey(t) ? map.get(t) + 1 : 1);
            if (map.get(t) > len / 2) {
                return t;
            }
        }
        return 0;
    }

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() > 1) {
            index = (index + m) % n;
            list.remove(index);
        }

        return list.get(0);
    }

}
