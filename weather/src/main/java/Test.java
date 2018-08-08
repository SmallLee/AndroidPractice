/**
 * 描述：
 *
 * @author Create by zxy on 2018/7/12
 */
public class Test {
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private void set(){
        threadLocal.set(Thread.currentThread().getName());
    }

    private String get(){
        return threadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test test = new Test();
        test.set();
        System.out.println("main: " + test.get() + "3|4 " + (3|4));
        Thread t1 = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println("Thread: " + test.get());
            }
        };
        t1.start();
        // 调用join的线程执行完毕之后，才执行当前线程
        t1.join();
        System.out.println("main: " + test.get());
    }
}

