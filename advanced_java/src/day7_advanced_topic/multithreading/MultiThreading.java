package day7_advanced_topic.multithreading;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author rezamirsalari
 */
public class MultiThreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Starting Thread 1");
        Task taskRunner1 = new Task();
        taskRunner1.start();

        System.out.println("Starting Thread 2");
        Task taskRunner2 = new Task();
        taskRunner2.start();

    }

}
class Task extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("numer: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}