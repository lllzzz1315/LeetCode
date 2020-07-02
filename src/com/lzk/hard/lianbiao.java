package com.lzk.hard;

import com.lzk.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/30 22:54
 */
public class lianbiao {

    //K个一组的链表翻转
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        //定义一个空链表
        ListNode result = new ListNode(-1);
        //记录空链表的第一个节点指针
        ListNode tmp = result;

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (true) {
            ListNode last = head;
            while (head != null && i < k) {
                stack.push(head.val);
                head = head.next;
                i++;
            }
            if (i < k) {
                //剩余节点直接插入到最后
                result.next = last;
                break;
            }
            while (!stack.isEmpty()) {
                //节点插入参数必须要.next插入
                result.next = new ListNode(stack.pop());
                result = result.next;
                i--;
            }
        }
        return tmp.next;
    }

}
