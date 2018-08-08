/**
 * 描述：
 *
 * @author Create by zxy on 2018/7/12
 */
public class ThreadFlag extends Thread {
    private volatile boolean exit = false;

    @Override
    public void run() {
        while (!exit){
            System.out.println("正在运行");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                // 捕获到中断异常时改变标记
                exit = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFlag tf = new ThreadFlag();
        tf.start();
        Thread.sleep(2000);
        tf.interrupt();
        System.out.println("线程结束");
    }
}
