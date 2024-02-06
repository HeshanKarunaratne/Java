package dsa.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heshan Karunaratne
 */
class DoublyListNode {
    int key;
    int value;
    DoublyListNode prev;
    DoublyListNode next;

    public DoublyListNode() {
    }

    public DoublyListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private DoublyListNode head;
    private DoublyListNode tail;
    private Map<Integer, DoublyListNode> cache = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoublyListNode();
        tail = new DoublyListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoublyListNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoublyListNode node = cache.get(key);

        if (node == null) {
            DoublyListNode newNode = new DoublyListNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNodeToHead(newNode);
            if (cache.size() > capacity) {
                DoublyListNode tail = removeTail();
                cache.remove(tail.key);
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public int getMapSize() {
        return cache.size();
    }

    public void addNodeToHead(DoublyListNode node) {
        DoublyListNode pre = head;
        DoublyListNode next = head.next;
        pre.next = node;
        node.prev = pre;

        next.prev = node;
        node.next = next;
    }

    public void removeNode(DoublyListNode node) {
        DoublyListNode previous = node.prev;
        DoublyListNode next = node.next;

        previous.next = next;
        next.prev = previous;

        node.next = null;
        node.prev = null;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.getMapSize());
        lruCache.put(1, 1);
    }

    private void moveToHead(DoublyListNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private DoublyListNode removeTail() {
        DoublyListNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
