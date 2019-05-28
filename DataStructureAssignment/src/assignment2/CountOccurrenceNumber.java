package assignment2;

import java.util.*;

/**
 * 3-Write a program that reads the integers between 1 and 100 and counts the occurrences of each.
 */
public class CountOccurrenceNumber {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String USER_MSG = "Please enter a number between 1 and 100 (to exit type 0).";

            // create HashMap to keep count of number
            Map<Integer, Integer> myMap = new HashMap<>();

            System.out.println(USER_MSG);
            while (true) {
                try {
                    int inputNumber = sc.nextInt();
                    if (inputNumber == 0) {
                        break;
                    } else if (1 <= inputNumber && inputNumber <= 100) {
                        if (myMap.containsKey(inputNumber)) {
                            // if key exists,
                            myMap.put(inputNumber, myMap.get(inputNumber) + 1);
                        } else {
                            // create key and set initial value
                            myMap.put(inputNumber, 1);
                        }
                    } else {
                        System.err.println("[Error] Out of range");
                        System.out.println(USER_MSG);
                    }
                } catch (InputMismatchException ex) {
                    // handling exception
                    System.err.println("[Error] Invalid number format");
                    sc.nextLine();      // clear the buffer
                    System.out.println(USER_MSG);
                }
            }

            // print result
            System.out.println("---------- RESULT ----------");

            // using forEach method and lambda expression
            myMap.forEach((key, value) -> System.out.format("Count of %d: %d\n", key, value));

            // using Iterator
//            Iterator<Map.Entry<Integer, Integer>> it = myMap.entrySet().iterator();
//            while (it.hasNext()) {
//                HashMap.Entry<Integer, Integer> pair = it.next();
//                System.out.format("Count of %d: %d\n", pair.getKey(), pair.getValue());
//            }

            // using foreach loop
//            for (Map.Entry<Integer, Integer> pair : myMap.entrySet()) {
//                System.out.format("Count of %d: %d\n", pair.getKey(), pair.getValue());
//            }

            // using Iterator only key
//            Iterator<Integer> it = myMap.keySet().iterator();
//            while (it.hasNext()) {
//                Integer key = it.next();
//                System.out.format("Count of %d: %d\n", key, myMap.get(key));
//            }
        }
    }
}
