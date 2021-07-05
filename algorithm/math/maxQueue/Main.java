package maxQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/29 9:51
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

    }
}
class MaxQueue{
    Deque<Integer> d;
    Queue<Integer> q;

    public MaxQueue(){
        d = new LinkedList<>();
        q = new LinkedList<>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return  d.peekFirst();
    }

    public void push_back(int value) {
        // 若新进来的值较大，则需要将之前的小值都要删除掉
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
