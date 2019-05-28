import java.io.*;
import java.util.Scanner;

/**
 * ScanXan
 */
public class ScanXan {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader("xanadu.txt")))) {
            //sc.useDelimiter(",");
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        }
    }
}