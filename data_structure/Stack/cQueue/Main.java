package cQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/1 9:10
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        int value = 1;
        obj.appendTail(value);
        int param_2 = obj.deleteHead();
    }
}
class CQueue{
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        int res = -1;
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        res = stack2.pop();
        return res;
    }
}
