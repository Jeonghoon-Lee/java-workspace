package multithreading.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithSync {
    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i=0; i<100; i++) {
//            executor.execute(() -> {
//                synchronized (account) {
//                    account.deposit(1);
//                }
//            });
            executor.execute(new AddAPennyTask());
        }
        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) ;

        System.out.println("What is balance? " + account.getBalance());
    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            synchronized (account) {
                account.deposit(1);
            }
        }
    }

    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            int newBalance = balance + amount;

            // This delay is deliberately added to magnify the
            // data-corruption problem and make it easy to see.
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance = newBalance;
        }
    }
}
