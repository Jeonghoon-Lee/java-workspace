package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    static ArrayList<Person> personList = new ArrayList<>();

    public static void printPersonList(String msg) {
        System.out.println(msg);
        personList.forEach(p -> System.out.println(p));
    }

    public static void InitializeArray() {
        // Initialize ArrayList
        personList.add(new Person(5, "Marie", "France"));
        personList.add(new Person(2, "Mark", "Corry"));
        personList.add(new Person(4, "James", "Dean"));
        personList.add(new Person(3, "Michael", "Jackson"));
        personList.add(new Person(1, "Bill", "Smith"));
        printPersonList("\n--- Not sorted ---");
    }

    public static void sortUsingComparable() {
        Collections.sort(personList);
        printPersonList("\n--- Sort by id using Comparable ---");
    }

    public static void sortUsingInnerClass() {
        Collections.sort(personList, new Person.SortByName());
        printPersonList("\n--- Sort by Nams using Inner Class ---");

        Collections.sort(personList, new Person.SortByFamily());
        printPersonList("\n--- Sort by Family using Inner Class ---");

        Collections.sort(personList, new Person.SortById());
        printPersonList("\n--- Sort by Id using Inner Class ---");
    }

    public static void sortUsingAnonymousInnerClass() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printPersonList("\n--- Sort by Nams using Anonymous Inner Class ---");

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFamily().compareTo(o2.getFamily());
            }
        });
        printPersonList("\n--- Sort by Family using Anonymous Inner Class ---");

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });
        printPersonList("\n--- Sort by Id using Anonymous Inner Class ---");
    }

    public static void sortUsingLambda() {
        Collections.sort(personList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        // for testing
        // Collections.sort(personList, Comparator.comparing(person -> person.getName()));
        // Collections.sort(personList, Comparator.comparing(Person::getName));
        printPersonList("\n--- Sort by Nams using Lambda ---");

        // Collections.sort(personList, (o1, o2) -> o1.getFamily().compareTo(o2.getFamily()));
        Collections.sort(personList, Comparator.comparing(person -> person.getFamily()));
        printPersonList("\n--- Sort by Family using Lambda ---");

        // Collections.sort(personList, (o1, o2) -> o1.getId() - o2.getId());
        Collections.sort(personList, Comparator.comparingInt(Person::getId));
        printPersonList("\n--- Sort by Id using Lambda ---");
    }

    public static void main(String[] args) {
        // Initialize Array
        InitializeArray();

        // Sort using Comparable
        sortUsingComparable();

        // Using Inner Class
        sortUsingInnerClass();

        // Using Anonymous Class
        sortUsingAnonymousInnerClass();

        // Using Lambda
        sortUsingLambda();
    }
}
