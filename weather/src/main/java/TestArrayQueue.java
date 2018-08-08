/**
 * 描述：数组实现的队列
 */
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(String.class);
        arrayQueue.add("A");
        arrayQueue.add("B");
        arrayQueue.add("C");
        arrayQueue.add("D");
        System.out.println(arrayQueue.remove());
        arrayQueue.printArrayQueue();
        System.out.println("===================");
        System.out.println(arrayQueue.remove());
        arrayQueue.printArrayQueue();
    }
}
