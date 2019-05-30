package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void printPersonList(ArrayList<Person> people, String msg) {
        System.out.println(msg);
        people.forEach(p -> System.out.println(p));
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person(5, "Marie", "France"));
        people.add(new Person(2, "Michael", "Jordan"));
        people.add(new Person(4, "James", "Dean"));
        people.add(new Person(3, "Michael", "Jackson"));
        people.add(new Person(1, "Bill", "Smith"));

        Collections.sort(people);
        printPersonList(people, "\n--- Sort by id using Comparable ---");

        // Using Inner Class
        Collections.sort(people, new Person.SortByName());
        printPersonList(people, "\n--- Sort by Nams using Inner Class ---");

        Collections.sort(people, new Person.SortByFamily());
        printPersonList(people, "\n--- Sort by Family using Inner Class ---");

        Collections.sort(people, new Person.SortById());
        printPersonList(people, "\n--- Sort by Id using Inner Class ---");

        // Using Anonymous Inner Class
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printPersonList(people, "\n--- Sort by Nams using Anonymous Inner Class ---");

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFamily().compareTo(o2.getFamily());
            }
        });
        printPersonList(people, "\n--- Sort by Family using Anonymous Inner Class ---");

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });
        printPersonList(people, "\n--- Sort by Id using Anonymous Inner Class ---");

        // Using Lambda
        Collections.sort(people, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        printPersonList(people, "\n--- Sort by Nams using Lambda ---");

        Collections.sort(people, (o1, o2) -> o1.getFamily().compareTo(o2.getFamily()));
        printPersonList(people, "\n--- Sort by Family using Lambda ---");

        Collections.sort(people, (o1, o2) -> o1.getId() - o2.getId());
        printPersonList(people, "\n--- Sort by Id using Lambda ---");
    }
}
