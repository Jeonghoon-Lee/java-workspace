package multithreading;

public class TestThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PrintNumberThread("Thread 1"));
        Thread thread2 = new Thread(new PrintNumberThread("Thread 2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
