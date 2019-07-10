package mid_exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        System.out.println("\n--- 1. Read text from words.txt");

        // try-with-resource statement
        try (Scanner inputStream = new Scanner(new FileInputStream("words.txt"))) {
            System.out.println("\n--- 2. Create a linked list using each tokens of input file");
            inputStream.tokens().forEach(token -> {
                // use Regular expression for excluding string containing vowel
                if (token.toLowerCase().matches("^[^aeiou]+$")) {
                    // add token to table
                    hashTable.put(token);
                }
            });

            System.out.printf("\nHash table %s string 'SQL'\n",
                    hashTable.containsString("SQL") ? "contains" : "doesn't contain");
            System.out.printf("\nHash table %s string 'RVSP'\n",
                    hashTable.containsString("RVSP") ? "contains" : "doesn't contain");
            System.out.printf("\nHash table %s string 'NYC'\n",
                    hashTable.containsString("NYC") ? "contains" : "doesn't contain");

            // for performance testing
            hashTable.printSizeOfTable();

        } catch (FileNotFoundException e) {
            System.out.println("File words.txt was not found or could not be opened.");
        }
    }
}
