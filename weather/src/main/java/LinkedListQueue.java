import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 描述：LinkedList实现的队列
 */
public class LinkedListQueue<T> {
    private LinkedList<T> mLinkedList;
    private int size;
    private int count;
    private static final int DEFAULT__SIZE = 8;

    public LinkedListQueue(){
        mLinkedList = new LinkedList<>();
        this.size = DEFAULT__SIZE;
    }

    public LinkedListQueue(int size){
        mLinkedList = new LinkedList<>();
        this.size = size;
    }

    // 向队列尾部添加一个元素
    public boolean add(T value) {
        if (offer(value)) {
            return true;
        } else {
            throw new IllegalStateException("LinedListQueue is full");
        }
    }

    public boolean offer(T value) {
        if (isFull()) {
            return false;
        } else {
            mLinkedList.addLast(value);
            count ++;
            return true;
        }
    }

    public T remove() {
        T poll = poll();
        if (poll == null) {
            throw new NoSuchElementException("");
        } else {
            return poll;
        }
    }

    // 删除队列头部元素
    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            return mLinkedList.removeFirst();
        }
    }

    public T element() {
        T peek = peek();
        if (peek() == null) {
            throw new NoSuchElementException("");
        } else {
            return peek;
        }
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return mLinkedList.getLast();
        }
    }

    public int size () {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return size() == this.size;
    }

    public void printLinkedListQueue() {
        System.out.println(mLinkedList.size());
        for (T t : mLinkedList) {
            System.out.println(t);
        }
    }
}
