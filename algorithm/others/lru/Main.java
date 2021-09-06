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
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        map = new HashMap<>();

        this.capacity = capacity;

        //初始化双向链表
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else {
            Node node = map.get(key);
            moveToTail(node, node.value);
            return node.value;
        }
    }


    public void put(int key, int value) {
        if (map.containsKey(key)){
            moveToTail(map.get(key), value);
        }else {
            if (map.size() == capacity){
                // 删除最少使用的节点
                Node lessUse = head.next;
                deleteNode(lessUse);
                map.remove(lessUse.key);
            }

            Node node = new Node(key, value);
            insertToTail(node);
            map.put(key, node);
        }
    }

    private void moveToTail(Node node, int value) {
        deleteNode(node);
        node.value = value;
        insertToTail(node);
    }

    private void insertToTail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int k, int v){
        this.key = k;
        this.value = v;
    }
}
