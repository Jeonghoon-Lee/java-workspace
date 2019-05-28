package assignment2;

import java.util.Scanner;

/**
 * 2- Write a recursive method that finds the number of occurrences of a specified letter in a
 * string
 */
public class NumberOfLetter {
    /**
     * Return the number of occurrence of the a argument in a specified string.
     * This is helper method for recursive method.
     *
     * @param str
     * @param a    letter to search
     * @return  the number of uppercase letters
     */
    public static int count(String str, char a) {
        // call method
        return countNumberOfLetters(str, a, 0);
    }

    /**
     * Return the number of occurrence of the ch argument in a string from curIndex argument.
     * This method calls itself recursively
     * until the curIndex argument is less than the length of the str argument.
     *
     * @param str
     * @param ch    letter to search
     * @param curIndex  starting position to count letters
     * @return  the number of occurrence of the ch argument
     */
    private static int countNumberOfLetters(String str, char ch, int curIndex) {
        if (curIndex < str.length()) {
            return ((str.charAt(curIndex) == ch) ? 1 : 0) + countNumberOfLetters(str, ch, ++curIndex);
        }
        return 0;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please enter a string: ");
            String userInput = sc.nextLine();

            System.out.print("Please enter a char to count: ");
            char keyChar = sc.next().charAt(0);     // read char from string input

            System.out.printf("The number of occurrences of '%c' is %d.\n", keyChar, count(userInput, keyChar));
        }
    }
}
