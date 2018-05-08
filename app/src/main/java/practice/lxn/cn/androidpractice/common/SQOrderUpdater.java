package practice.lxn.cn.androidpractice.common;

/**
 * 首汽约车定时轮询
 */

public class SQOrderUpdater {
    //刷新接口的时间10秒
    private int pollingNext = 10;

    private SQOrderUpdater.SQOrderUpdateListener listener;

    private SQOrderUpdater.RunLoopThread runLoopThread;

    private boolean isRunning = false;

    public interface SQOrderUpdateListener {
        void updateCurrentOrder();
    }

    public SQOrderUpdater.SQOrderUpdateListener getListener() {
        return listener;
    }

    public void setListener(SQOrderUpdater.SQOrderUpdateListener listener) {
        this.listener = listener;
    }

    public boolean isRunning() {
        return isRunning;
    }

    //sqyc/callBackStatus/pull
    public void startRefresh() {
        isRunning = true;
        pollingNext = 10;
        doRefresh();
        startTimer();
    }

    public void stopRefresh() {
        isRunning = false;
        endTimer();
    }

    private void startTimer() {

        endTimer();
        runLoopThread = new SQOrderUpdater.RunLoopThread();
        runLoopThread.start();
    }

    private void endTimer() {
        if (runLoopThread != null) {
            runLoopThread.setRunning(false);
            runLoopThread.interrupt();
            runLoopThread = null;
        }
    }

    private void onTimer() {
        if (pollingNext == 0) {
            doRefresh();
        }
        System.out.println("================poll" + pollingNext);
        pollingNext --;
    }

    private void doRefresh() {
        //轮询订单状态
        System.out.println("================请求网络");
        pollingNext = 10;
    }

    private class RunLoopThread extends Thread {
        private boolean running = true;

        boolean isRunning() {
            return running;
        }

        void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    if (isRunning()) {
                        onTimer();
                    }
                }
            };

            while (!isInterrupted() && isRunning()) {
                try {
                    Thread.sleep(1000);
//                    CustomApplication.getInstance().runOnMainThread(runnable);
                } catch (InterruptedException ignored) {

                }
            }
        }
    }
}
