package lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/9/5 17:29
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

    }
}
class LRUCache {
    HashMap<Integer, Integer> map;
    Deque<Node> deque;
    public LRUCache(int capacity) {
        deque = new LinkedList<>();
    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }
    class Node{
        int key;
        int value;
        public node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
}
