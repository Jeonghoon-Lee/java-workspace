package multithreading;

public class PrintNumberThread implements Runnable {
    private String msg;

    PrintNumberThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++)
            System.out.format("%02d: %s\n", i, msg);
    }
}
