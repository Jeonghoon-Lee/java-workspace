package oop_assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Object oriented design assignment including abstract class and interface
 */
public class Main {
    public static void main(String[] args) {
        try {
            Student s = new Student("James", "S1234");
            s.printInfo();
            s.speak(new ArrayList<>(Arrays.asList("English")));
            System.out.println(s);

            System.out.println();
            // Polymorphism testing
            Person t = new Teacher("Jackson", "Mathematics");
            t.printInfo();
            ((Teacher)t).speak(new ArrayList<>(Arrays.asList("English", "French")));
            System.out.println(t);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
