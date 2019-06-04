package multithreading.basic;

public class PrintMsgThread implements Runnable {
    private String message;
    private int numOfTimes;

    public PrintMsgThread(String message, int numOfTimes) {
        this.message = message;
        this.numOfTimes = numOfTimes;
    }

    @Override
    public void run() {
        for (int i=0; i<numOfTimes; i++) {
            System.out.format("%d: %s\n", i, message);
        }
    }
}
