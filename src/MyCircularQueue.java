// used this ressource to help implement this code: https://www.javamadesoeasy.com/2015/01/queues.html
public class MyCircularQueue {

    private int[] data;
    private final int size;

    private int p_head;
    private int p_tail;
    private int queueSize;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        size = k;
        data = new int[size];
        p_head = -1;
        p_tail = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        ++p_tail;
        if(p_tail == size) p_tail=0;
        data[p_tail] = value;
        if(p_head == -1) p_head=0;
        queueSize++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }

        p_head++;
        if(p_head == size) p_head = 0;
        queueSize--;

        if(isEmpty()) {
            p_tail = -1;
            p_head = -1;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(p_head == -1) return -1;
        return data[p_head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(p_tail == -1) return -1;
        return data[p_tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return queueSize==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return queueSize == size;
    }

    public static void main(String[] args) {
        //Your MyCircularQueue object will be instantiated and called as such:
        MyCircularQueue obj = new MyCircularQueue(8);
        //System.out.println("Head: " + obj.Front());
        boolean param_1 = obj.enQueue(4);
        System.out.println("Tail: " + obj.Rear());
        boolean param_2 = obj.deQueue();
        obj.enQueue(5);
        obj.enQueue(7);
        int param_3 = obj.Front();
        System.out.println("Front : " + param_3);
        int param_4 = obj.Rear();
        System.out.println("Rear : " + param_4);
        boolean param_5 = obj.isEmpty();
        System.out.println("Empty : " + param_5);
        boolean param_6 = obj.isFull();
        System.out.println("Full : " + param_6);
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        obj.enQueue(6);
        System.out.println("Really full : " + obj.isFull());
        for(int i = 0; i<7; i++) {
            obj.deQueue();
        }
        System.out.println("Really empty : " + obj.isEmpty());

        // proposed test from LeetCode
        System.out.println("*****************************************************");

        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4

        System.out.println("*****************************************************");
        // test #3 (failed at first attempt)
        MyCircularQueue circularQueue2 = new MyCircularQueue(6); // set the size to be 6
        System.out.println(circularQueue2.enQueue(6));  // return true
        System.out.println(circularQueue2.Rear());  // return 6
        System.out.println(circularQueue2.Rear());  // return 6
        System.out.println(circularQueue2.deQueue());  // return true
        System.out.println(circularQueue2.enQueue(5));  // return true
        System.out.println(circularQueue2.Rear());  // return 5
        System.out.println(circularQueue2.deQueue());  // return true
        System.out.println(circularQueue2.Front());  // return -1
        System.out.println(circularQueue2.deQueue());  // return false
        System.out.println(circularQueue2.deQueue());  // return false
        System.out.println(circularQueue2.deQueue());  // return false

        System.out.println("*****************************************************");
        // test #3 (failed at first attempt)
        MyCircularQueue circularQueue3 = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue3.enQueue(2));  // return true
        System.out.println(circularQueue3.Rear());  // return 2
        System.out.println(circularQueue3.Front());  // return 2
        System.out.println(circularQueue3.deQueue());  // return true
        System.out.println(circularQueue3.Front());  // return -1
        System.out.println(circularQueue3.deQueue());  // return false
        System.out.println(circularQueue3.Front());  // return -1
        System.out.println(circularQueue3.enQueue(4));  // return true
        System.out.println(circularQueue3.enQueue(2));  // return true
        System.out.println(circularQueue3.enQueue(2));  // return true
        System.out.println(circularQueue3.enQueue(3));  // return false
    }
}