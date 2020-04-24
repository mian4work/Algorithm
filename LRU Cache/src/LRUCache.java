import java.util.HashMap;
import java.util.Map;

/*
    Design and implement a data structure for Least Recently Used (LRU) cache.
    It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
    it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?

    Example:

    LRUCache cache = new LRUCache( 2 )
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
*/

/**
 * This is a question being asked frequently.
 *
 * The solution is to use a HashMap (not an array) in which the key is index and value is a Node in doubly linked list.
 * Each element has a node in one data structure Map but at the same time, it is in another data structure linked list.
 * This is the beauty of the solution.
 *
 *      1. You don't have to loop a list to find the last recently visited, only need to remove the last Node
 *          (which contains the key), and remove the entry from Map. The operation time is O(1).
 *      2. Removing a Node takes O(1) because you can retrieve it via Map by key !!!
 *      3. Move a Node to head is also O(1)
 *
 * A good techniques learnt is to use two sudo Node head and tail so no need to check null value.
 *
 */
public class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        join(head, tail);
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToHead(node);
        } else {
            if(map.size() == size) {
                if(tail.prev != head) { // I missed this test cases!!!
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToHead(newNode);
        }
    }

    void join(Node front, Node end) {
        front.next = end;
        end.prev = front;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToHead(Node node) {
        Node next = head.next;
        join(head, node);
        join(node, next);
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
