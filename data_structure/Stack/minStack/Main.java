package minStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/1 21:28
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

    }
}
class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x){
            stack2.push(x);
        }
    }

    public void pop() {
        int temp = stack1.pop();
        if (temp == stack2.peek()){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {

        return stack2.peek();

    }
}