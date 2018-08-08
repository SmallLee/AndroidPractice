import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 描述：
 */
public class TestRunable {
    static Callable<String> callable = new Callable<String>() {
        @Override
        public String call(){
            System.out.println(Thread.currentThread().getName());
            return "haha";
        }
    };

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.isDone());
            String result = futureTask.get();
            System.out.println(result);
            System.out.println(futureTask.isDone());
            Executors.newCachedThreadPool().submit(callable);
            Executors.newCachedThreadPool().execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
