package src;

import java.util.HashMap;

class Node{
    public int key,value;
    public Node prev,next;
    public Node(int _key, int _val){this.key = _key; this.value =_val;}
}
class DoubleList{
    private Node head,tail;
    private int size;
    public DoubleList(){
        head = new Node(0,0); //头节点
        tail = new Node(0,0);//尾节点
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    public Node removeFirst(){
        if(head.next == tail)
            return null;
        Node first = head.next;
        remove(first);
        return first;
    }
    public int size(){return size;}
}
class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        //没找到
        if (!map.containsKey(key)) {
            return -1;
        }
        //找到，回到队尾：1. 删除链表中的Node 2.将其Node放置队尾
        cache.remove(map.get(key));
        cache.addLast(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int val){
        //如果put的key已经存在，1. 更新其value 2. 让其到队尾
        if(map.containsKey(key))
        {
            //更新map的value
            map.get(key).value = val;
            cache.remove(map.get(key));
            cache.addLast(map.get(key));
            return;
        }
        //put的key不存在 1. 创建Node节点 2.查看缓存容量 3更新
        if(cache.size() >= this.cap){
            map.remove(cache.removeFirst().key);
        }
        Node x = new Node(key, val);
        map.put(key,x);
        cache.addLast(x);
    }
}
public class leetcode146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}

//题解。https://github.com/labuladong/fucking-algorithm/blob/master/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/LRU%E7%AE%97%E6%B3%95.md
