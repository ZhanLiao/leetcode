package minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/1 22:00
 * @Version: 1.0
 */
public class MinStack2 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack2() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()){
            stack2.push(x);
        }else {
            if (stack2.peek() >= x){
                stack2.push(x);
            }else {
                stack2.push(stack2.peek());
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */