import java.lang.reflect.Array;

import pojo.Customer;

/**
 * 描述：环形队列
 *
 * 普通队列存在假溢出的现象，浪费内存空间
 * 环形队列可以充分利用内存空间
 */
public class CycleQueue<T> {
    private static final int DEFAULT_SIZE = 8;
    // 头指针
    private int mFont = 0;
    // 尾指针
    private int mRear = 0;
    // 队列长度
    private int mQueueLength = 0;
    private T[] mArray;
    // 容量
    private int mCapacity;
    @SuppressWarnings("unchecked")
    public CycleQueue(Class<T> type) {
        mArray = (T[]) Array.newInstance(type, DEFAULT_SIZE);
        this.mCapacity = DEFAULT_SIZE;
        clearCycleQueue();
    }

    @SuppressWarnings("unchecked")
    public CycleQueue(Class<T> type,int capacity) {
        mArray = (T[]) Array.newInstance(type, capacity);
        mCapacity = capacity;
        clearCycleQueue();
    }

    // 清除队列
    public void clearCycleQueue() {
        // 头指针
        mFont = 0;
        // 尾指针
        mRear = 0;
        // 队列长度
        mQueueLength = 0;
    }

    public boolean enQueue(T value) {
        if (isFull()) {
            return false;
        }
        mArray[mRear++] = value;
        mRear = mRear % mCapacity;
        mQueueLength++;
        return true;
    }

    // 出队操作
    public T deQueue(){
        if (isEmpty()) {
            return null;
        }
        T value = mArray[mFont++];
        mFont = mFont % mCapacity;
        mQueueLength--;
        return value;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    // 队列是否满，用长度和容量比较
    public boolean isFull() {
        return mQueueLength == mCapacity;
    }

    public int size() {
        return mQueueLength;
    }

    public void printQueue() {
        int count = 0;
        // 加mFont是为了保证无论头部如何增长，都能保证循环次数不出错
        for (int i = mFont; i < mQueueLength + mFont; i++) {
            T value = mArray[i % mCapacity];
            if (value instanceof Customer) {
                Customer customer = (Customer) value;
                if (customer.getName().equals("lxn")) {
                    if (count > 0) {
                        System.out.println(customer.getName() + "前有" + count +"人");
                    } else {
                        System.out.println("轮到" + customer.getName());
                    }
                    break;
                } else{
                    count++;
                }
            }
        }
    }
}
