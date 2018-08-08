import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * 描述：数组实现的队列
 */
public class ArrayQueue<T> {
    private int count;
    private static final int DEFAULT_SIZE = 4;
    private T[] mArray;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue(Class<T> type) {
        this(type,DEFAULT_SIZE);
        count = 0;
        this.size = DEFAULT_SIZE;
    }
    @SuppressWarnings("unchecked")
    public ArrayQueue(Class<T> type,int size) {
        mArray = (T[]) Array.newInstance(type,size);
        count = 0;
        this.size = size;
    }

    // 向队列尾部添加元素，如果队列容量已满，抛出IllegalStateException
    public boolean add (T value) {
        if (offer(value)) {
            return true;
        } else {
            throw new IllegalStateException("ArrayQueue is full");
        }
    }

    // 向队列尾部添加元素，如果队列容量已满，直接返回false
    public boolean offer (T value) {
        if (isFull()) {
            return false;
        }
        mArray[count++] = value;
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 获取并删除队列头部元素，如果队列是空的，抛出异常
    public T remove() {
        T poll = poll();
        if (poll != null) {
            return poll;
        } else {
            throw new NoSuchElementException("ArrayQueue is empty,no such element");
        }
    }

    // 获取并删除队列头部元素
    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            T ret = mArray[0];
            count --;
//            for (int i = 1; i <= count; i++) {
//                mArray[i -1] = mArray[i];
//            }
            // 效率更高
            System.arraycopy(mArray,1,mArray,0,count);
            return ret;
        }
    }

    // 获取队头元素，如果队列为空，抛出异常
    public T element() {
        T peek = peek();
        if (peek != null) {
            return peek;
        } else {
            throw new NoSuchElementException("ArrayQueue is empty,no such element");
        }
    }

    // 获取队列头部元素
    public T peek() {
        if(isEmpty()) {
            return null;
        } else {
            return mArray[0];
        }
    }

    public boolean isFull() {
        return size() == this.size;
    }

    public int size() {
        return count;
    }

    public void printArrayQueue() {
        for (int i = 0; i < size(); i++) {
            System.out.println(mArray[i]);
        }
    }
}
