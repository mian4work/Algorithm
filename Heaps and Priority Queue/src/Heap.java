/**
 * Heaps can be represented by an array.
 *
 * It is a binary tree.
 *
 * It can be max heap (parent value is always larger than children) or min heap (parent value is always smaller than children)
 *
 * It must be a complete tree (all occupied except leave level. right most leave is the last one in array)
 *
 * From a parent to two children 2i + 1 and 2i + 2
 * From a child to parent: floor((i - 1) / 2)
 *
 */
public class Heap {

    int[] heap;
    int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public boolean isFull(int index) {
        return index == heap.length;
    }

    public int getParent(int index) {
        if(isFull(index)) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        return (int)Math.floor((index - 1) / 2);
    }

    public void fixHeapAbove(int index) {
        int value = heap[index];
        while(index > 0 && heap[index] > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = value;
    }
}
