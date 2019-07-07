package assignment2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFileDemo {
    public static void main(String[] args) {
        LinkedList tokenList = new LinkedList();

        System.out.println("\n--- 1. Read text from let_it_be.txt");

        // try-with-resource statement
        try (Scanner inputStream = new Scanner(new FileInputStream("let_it_be.txt"))) {
            System.out.println("\n--- 2. Create a linked list using each tokens of input file");
            inputStream.tokens().forEach(token -> tokenList.addToTail(token));

            // print list size
            System.out.println("\n--- 3. Linked list was created. Size of linked list is " + tokenList.size());

            System.out.println("\n--- 4. Output the linked list");
            tokenList.outputList();
        } catch (FileNotFoundException e) {
            System.out.println("File let_it_be.txt was not found or could not be opened.");
        }
    }
}
