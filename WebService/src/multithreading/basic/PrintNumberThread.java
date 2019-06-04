package multithreading.basic;

public class PrintNumberThread implements Runnable {
    private int maxNumber;

    public PrintNumberThread(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        Thread t = new Thread(new PrintMsgThread("Test join", 10));
        t.start();

        try {
            for (int i = 0; i < maxNumber; i++) {
                System.out.format("PrintNumberThread: %02d\n", i);
                if (i == 30)
                    t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
