/**
 * 描述：
 */
public class TestLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.add("A");
        linkedListQueue.add("B");
        linkedListQueue.add("C");
        linkedListQueue.printLinkedListQueue();
        System.out.println("=================");
        System.out.println(linkedListQueue.remove());
        linkedListQueue.printLinkedListQueue();
    }
}
