package com.lzk.easy;

import com.lzk.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/22 23:05
 */
public class lianbiao {


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l3 = new ListNode(-1);

        //存储头结点
        ListNode yyz = l3;

        int flag = 0;//进位符
        while(l1 != null || l2 != null) {
            //判断链表中值的大小
            int num1 = l1 == null ? 0 :l1.val;
            int num2 = l2 == null ? 0 :l2.val;
            int sum = num1 + num2 + flag; //计算三个值大小
            if (sum >= 10) {
                flag = 1;
                l3.next = new ListNode(sum % 10);
            } else {
                l3.next = new ListNode(sum);
                flag = 0;
            }
            //链表遍历操作
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            l3 = l3.next;
        }

        if (flag == 1) {
            l3.next = new ListNode(1);
        }
        return yyz.next;

    }



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

    //反转链表
    public ListNode reverseList(ListNode head) {
        //预先节点指向null
        ListNode pre = null;
        //首节点指向head本体
        ListNode cur = head;
        while (cur != null) {
            //把cur.next先存起来
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
