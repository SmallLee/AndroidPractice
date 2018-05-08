package practice.lxn.cn.androidpractice.test;

import java.util.concurrent.Semaphore;

/**
 * 描述：
 * 作者：Create by lixiaoniu on 2018/5/4
 */
public class ThreadDemo {
    static Semaphore semaphore = new Semaphore(3);
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();
        t1.start();
        t2.start();
        t3.start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程一执行完毕");
            semaphore.release();
            checkFinish(semaphore.availablePermits());
        }
    }
    static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程二执行完毕");
            semaphore.release();
            checkFinish(semaphore.availablePermits());
        }
    }
    static class Thread3 extends Thread{
        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3执行完毕");
            semaphore.release();
            checkFinish(semaphore.availablePermits());
        }
    }

    static void checkFinish(int count){
        if (count == 3) {
            System.out.println("所有线程执行完毕");
        }
    }
}
