package hashing;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LFU_Cache_LC_460 {
    public static void main(String[] args) {

    }
}

class LFUCache {
    int curSize, freqLFU;
    final int capacity;
    Map<Integer, DoublyLinkedList> freqMap;
    Map<Integer, DLL_Node> cache;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0; // initially it is 0
        this.freqLFU = 0; // initially it is 0
        this.freqMap = new HashMap<>();
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        DLL_Node currentNode = cache.get(key);
        if (currentNode == null) {
            return -1; // as the node does not exist
        }
        updateNode(currentNode);
        return currentNode.value;
    }

    public void put(int key, int value) {
        // edge case
        if (capacity == 0) {
            return; // as we cannot insert anything
        }
        if (cache.containsKey(key)) { // we need to update the new value and then insert it in a
                                        // new DLL with higher freq
            DLL_Node currentNode = cache.get(key);
            currentNode.value = value; // update the new value
            updateNode (currentNode);
        }
        else {
            curSize++; // whenever we call this method and !keyNode.containsKey(key), the size gets incremented
            if (curSize > capacity) {

                // get minFreq List and remove the LRU of the LFU
                DoublyLinkedList minFreqList = freqMap.get(freqLFU);
                cache.remove(minFreqList.tail.prev.key); // we remove the LRU of the LFU from keyNode hashMap
                DLL_Node nodeToRemove = cache.get(minFreqList.tail.prev);
                minFreqList.removeNode(nodeToRemove); // we remove the LRU of the LFU from the DLL of freqList

                curSize--; // we decrement the size as we removed one node
            }

            freqLFU = 1; // we reset the freqLFU to 1 as we will be adding a newNode
            DLL_Node newNode = new DLL_Node(key, value);

            // we need to insert the newNode right after the headNode of the DLL with freq = 1
            DoublyLinkedList curList = freqMap.getOrDefault(1, new DoublyLinkedList()); // we get the DLL with freq 1
                                                                                              // if it does not exist we create a new DLL
            curList.addNode(newNode);
            freqMap.put(1, curList); // we put it in the freqList
            cache.put(key, newNode);
        }
    }

    public void updateNode (@NotNull DLL_Node curNode) {
        int curFreq = curNode.freq;
        DoublyLinkedList curList = freqMap.get(curFreq);
        // we remove the curNode from the curList
        curList.removeNode(curNode);

        //if curList is the list which has freqLFU and is the only curNode is the only node in the list
        // we need to remove the entire list and increase freqLFU by 1
        if (curFreq == freqLFU && curList.listSize == 0) { // as after removal the listSize becomes 0
            freqLFU++;
        }

        // now we need to add the curNode to the next freqList
        int newFreq = curNode.freq++; // we increment the current freq
        DoublyLinkedList updatedList = freqMap.getOrDefault(newFreq, new DoublyLinkedList());
        updatedList.addNode(curNode);
        freqMap.put(newFreq, updatedList); // we put it in the freqMap
    }
}

class DLL_Node {
    DLL_Node prev, next;
    int key, value, freq;

    // constructor
    DLL_Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1; // it is initialize to 1
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    int listSize;
    DLL_Node head;
    DLL_Node tail;

    // constructor
    public DoublyLinkedList() {
        this.listSize = 0; // initialize it as 0;
        this.head = new DLL_Node(0, 0);
        this.tail = new DLL_Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // we remove the LRU node and decrease the listSize by 1
    public void removeNode (DLL_Node curNode) {
        DLL_Node prevNode = curNode.prev;
        DLL_Node nextNode = curNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        curNode.prev = null;
        curNode.next = null;
        listSize--;
    }

    // add node right next to the head and increase the listSize by 1
    public void addNode (DLL_Node curNode) {
        DLL_Node headFront = head.next;

        curNode.next = headFront;
        curNode.prev = head;
        head.next = curNode;
        headFront.prev = curNode;
        listSize++;
    }
}
