import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new FileReader("xanadu.txt"));
                PrintWriter outputStream = new PrintWriter(new FileWriter("characteroutput.txt"))) {
            
            String str;
            while ((str = inputStream.readLine()) != null) {
                outputStream.println(str);
            }
        }
    }
}