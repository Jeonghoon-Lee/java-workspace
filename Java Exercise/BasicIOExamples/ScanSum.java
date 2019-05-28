import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 * ScanSum
 */
public class ScanSum {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")))) {
            double sum = 0;
            sc.useLocale(Locale.US);

            while (sc.hasNext()) {
                if (sc.hasNextDouble()) {
                    sum += sc.nextDouble();
                } else {
                    sc.next();
                }
            }
            System.out.println(sum);
        }
    }    
}