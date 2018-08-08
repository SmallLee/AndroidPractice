import pojo.Customer;

/**
 * 描述：测试环形队列
 */
public class TestCycleQueue {
    public static void main(String[] args) {
//        CycleQueue<Integer> cycleQueue = new CycleQueue<>(Integer.class,4);
//        cycleQueue.enQueue(12);
//        cycleQueue.enQueue(14);
//        cycleQueue.printQueue();
//        System.out.println("=========="+cycleQueue.deQueue());
//        cycleQueue.printQueue();
//        cycleQueue.enQueue(16);
//        cycleQueue.enQueue(18);
//        System.out.println("==========" + cycleQueue.isFull());
//        cycleQueue.printQueue();
        CycleQueue<Customer> queue = new CycleQueue<>(Customer.class,4);
        queue.enQueue(new Customer("A",0));
        queue.enQueue(new Customer("B",1));
        queue.enQueue(new Customer("C",2));
        queue.enQueue(new Customer("lxn",2));
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.printQueue();
    }
}
