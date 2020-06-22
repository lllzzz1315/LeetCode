package com.lzk.easy;

import com.lzk.ListNode;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/22 23:05
 */
public class lianbiao {

    //两个链表相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = new ListNode(-1);
        //存储头结点
        ListNode result = l3;

        int num = 0; //进位符
        while(l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int subSum = num1 + num2 + num;
            if(subSum >= 10) {
                num = 1;
                l3.next = new ListNode(subSum % 10);
            } else {
                num = 0;
                l3.next = new ListNode(subSum);
            }
            //注意不要用l1.next去判断，容易空指针
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            //组合链表需要往后移动一位
            l3 = l3.next;
        }
        if (num == 1) {
            l3.next = new ListNode(1);
        }

        //头结点输出整个列表
        return result.next;
    }
}
