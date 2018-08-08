import java.lang.reflect.Array;

/**
 * 描述：数组实现的栈
 */
public class ArrayStack<T> {
    private T[] mArray;
    private int count;
    private int size;
    private static final int DEFAULT_SIZE = 16;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<T> type) {
        mArray = (T[]) Array.newInstance(type, DEFAULT_SIZE);
        this.size = DEFAULT_SIZE;
        count = 0;
    }
    @SuppressWarnings("unchecked")
    public ArrayStack(Class<T> type, int size) {
        mArray = (T[]) Array.newInstance(type, size);
        this.size = size;
        count = 0;
    }

    // 添加元素
    public void push(T value) {
        mArray[count ++] = value;
    }

    // 返回栈顶元素
    public T peek() {
        return mArray[count - 1];
    }

    // 获取并删除栈顶元素
    public T pop() {
        T value = mArray[count - 1];
        count--;
        return value;
    }

    // 栈是否为空
    public boolean isEmpty() {
        return size() == 0;
    }

    // 栈是否已满
    public boolean isFull(){
        return size() == size;
    }

    public void clearStack() {
        count = 0;
        size = 0;;
    }

    public int size() {
        return count;
    }

    public void printArrayStack(boolean isFromBottom) {
        if (isEmpty()) {
            System.out.print("ArrayStack is Empty\n");
            return;
        }
        System.out.printf("ArrayStack size() = %d\n",size());
        int i;
        if (isFromBottom) {
             i = 0;
             while(i <= size - 1) {
                 System.out.println(mArray[i]);
                 i ++;
             }
        } else {
            i = size() - 1;
            while (i >= 0) {
                System.out.println(mArray[i]);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>(String.class);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        arrayStack.printArrayStack(false);
        arrayStack.push("C");
        System.out.println(arrayStack.isFull());
        arrayStack.printArrayStack(false);
        System.out.println(arrayStack.isFull());
    }
}
