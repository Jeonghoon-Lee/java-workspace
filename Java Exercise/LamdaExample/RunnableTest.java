import java.lang.*;

public class RunnableTest {
    public static void main(String[] args) {
        System.out.println("-------- Runable Test ---------");

        // Anonymous Runable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world one!");
            }
        };

        // Lambda Runnable
        Runnable r2 = () -> System.out.println("Hello world two!");

        // Run!
        r1.run();
        r2.run();
    }
}