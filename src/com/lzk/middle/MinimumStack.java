package com.lzk.middle;

import java.util.Stack;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/7/1 21:32
 */
public class MinimumStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinimumStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            if (x <= top) {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
