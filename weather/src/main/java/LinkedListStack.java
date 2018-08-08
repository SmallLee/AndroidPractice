import java.util.LinkedList;

/**
 * 描述：LinkedList实现的栈
 */
public class LinkedListStack<T> {

    private final LinkedList<T> mLinkedList;

    public LinkedListStack() {
        mLinkedList = new LinkedList<>();
    }

    public void push(T value) {
        mLinkedList.addFirst(value);
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return mLinkedList.getFirst();
    }

    public T pop() {
        T value = mLinkedList.getFirst();
        mLinkedList.removeFirst();
        return value;
    }

    public int size() {
        return mLinkedList.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printLinkedListStack() {
        if (isEmpty()) {
            System.out.print("LinkedListStack is empty");
            return;
        }
        System.out.printf("LinkedListStack size() = %d\n", size());
        for (T t : mLinkedList) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("A");
        linkedListStack.push("B");
        linkedListStack.push("C");
        System.out.println(linkedListStack.peek());
        linkedListStack.printLinkedListStack();
    }
}
