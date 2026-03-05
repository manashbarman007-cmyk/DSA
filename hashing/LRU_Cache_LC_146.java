package hashing;

import java.util.*;

public class LRU_Cache_LC_146 {
    public static void main(String[] args) {

    }
}

class LRUCache {
    NodeLRU head = new NodeLRU(0, 0), tail = new NodeLRU(0, 0);
    Map<Integer, NodeLRU> map = new HashMap<>();
    int capacity;

    // constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            NodeLRU currentNode = map.get(key);
            remove(currentNode);
            insert(currentNode);
            return currentNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        NodeLRU newNode = new NodeLRU(key, value);
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev); // we remove the LRU
        }
        insert(newNode); // regardless we insert the newNode
    }

    private void remove(NodeLRU node) {
        map.remove(node.key);
        NodeLRU nextNode = node.next;
        NodeLRU prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;
    }

    private void insert(NodeLRU node) {
        map.put(node.key, node);
        NodeLRU nextHead = head.next;
        node.next = nextHead;
        nextHead.prev = node;
        head.next = node;
        node.prev = head;
    }
}

class NodeLRU {
    NodeLRU prev, next;
    int key, value;
    NodeLRU(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
