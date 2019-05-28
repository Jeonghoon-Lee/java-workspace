package assignment2;

import java.util.Scanner;

/**
 * 1- Write a recursive method to return the number of uppercase letters in a string.
 */
public class NumberOfUpperCase {
    /**
     * Return the number of uppercase letters in a string.
     * This is helper method for recursive method.
     *
     * @param str
     * @return  the number of uppercase letters
     */
    public static int countNumberOfUppercase(String str) {
        // call method
        return countNumberOfUppercase(str, 0);
    }

    /**
     * Return the number of uppercase letters in a string from curIndex argument.
     * This method calls itself recursively
     * until the curIndex argument is less than length of the str argument.
     *
     * @param str
     * @param curIndex  starting position to count letters
     * @return  the number of uppercase letters
     */
    private static int countNumberOfUppercase(String str, int curIndex) {
        if (curIndex < str.length()) {
           return (Character.isUpperCase(str.charAt(curIndex)) ? 1 : 0) + countNumberOfUppercase(str, ++curIndex);
        }
        return 0;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter a string: ");
            String userInput = sc.nextLine();

            System.out.printf("The number of uppercase is %d.\n", countNumberOfUppercase(userInput));
        }
    }
}
