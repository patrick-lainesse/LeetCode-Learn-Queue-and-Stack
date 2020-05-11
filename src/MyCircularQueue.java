import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {

    private final List<Integer> data;
    private final int size;
    private int p_head;
    private int p_tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new ArrayList<Integer>();
        size = k;
        p_head = -1;
        p_tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(p_head + p_tail == size-1) return false;

        if(p_head == -1 && p_tail == -1) {
            p_head = 0;
            p_tail = 0;
            data.set(p_tail, value);
        }
        if(p_tail == size-1) {
            p_tail = 0;
            data.set(p_tail, value);
        } else {
            data.set(++p_tail, value);
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(p_head == 0 && p_tail == 0) return false;    // ??? vérifier ça!!!

        if(p_head == p_tail) {
            p_head = -1;
            p_tail = -1;
            return true;
        }
        if(p_head == size -1) {
            p_head = 0;
        } else {
            p_head++;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return data.get(p_head);
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return data.get(p_tail);
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return p_head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return p_head + p_tail == size - 1;
    }
}

/*
  Your MyCircularQueue object will be instantiated and called as such:
  MyCircularQueue obj = new MyCircularQueue(k);
  boolean param_1 = obj.enQueue(value);
  boolean param_2 = obj.deQueue();
  int param_3 = obj.Front();
  int param_4 = obj.Rear();
  boolean param_5 = obj.isEmpty();
  boolean param_6 = obj.isFull();
 */