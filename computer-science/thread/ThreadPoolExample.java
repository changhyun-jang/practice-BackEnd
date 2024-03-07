package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(7);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,5,3,SECONDS,queue);

        for (int i = 0; i < 10 ; i++) {
            executor.execute(new Task());
        }

        executor.awaitTermination(5,SECONDS);
        executor.shutdown();
    }
    private static class Task implements Runnable {

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName());
                SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }

}
