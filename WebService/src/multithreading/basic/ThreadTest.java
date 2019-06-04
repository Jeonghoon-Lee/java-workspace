package multithreading.basic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        // Join test
//        Thread thread = new Thread(new PrintNumberThread(100));
//        thread.start();

        // Executor testing
        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(new PrintNumberThread(200));
        executor.execute(new PrintMsgThread("Executor test", 1000));

        ((ExecutorService) executor).shutdown();
    }
}
