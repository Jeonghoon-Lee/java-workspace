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
        ArrayList<Person> personList = new ArrayList<>();

        // Initialize ArrayList
        personList.add(new Person(5, "Marie", "France"));
        personList.add(new Person(2, "Mark", "Corry"));
        personList.add(new Person(4, "James", "Dean"));
        personList.add(new Person(3, "Michael", "Jackson"));
        personList.add(new Person(1, "Bill", "Smith"));

        // Sort using Comparable
        Collections.sort(personList);
        printPersonList(personList, "\n--- Sort by id using Comparable ---");

        // Using Inner Class
        Collections.sort(personList, new Person.SortByName());
        printPersonList(personList, "\n--- Sort by Nams using Inner Class ---");

        Collections.sort(personList, new Person.SortByFamily());
        printPersonList(personList, "\n--- Sort by Family using Inner Class ---");

        Collections.sort(personList, new Person.SortById());
        printPersonList(personList, "\n--- Sort by Id using Inner Class ---");

        // Using Anonymous Class
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printPersonList(personList, "\n--- Sort by Nams using Anonymous Inner Class ---");

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFamily().compareTo(o2.getFamily());
            }
        });
        printPersonList(personList, "\n--- Sort by Family using Anonymous Inner Class ---");

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });
        printPersonList(personList, "\n--- Sort by Id using Anonymous Inner Class ---");

        // Using Lambda
        Collections.sort(personList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        // Collections.sort(personList, Comparator.comparing(person -> person.getName()));
        // Collections.sort(personList, Comparator.comparing(Person::getName));
        printPersonList(personList, "\n--- Sort by Nams using Lambda ---");

        // Collections.sort(personList, (o1, o2) -> o1.getFamily().compareTo(o2.getFamily()));
        Collections.sort(personList, Comparator.comparing(person -> person.getFamily()));
        printPersonList(personList, "\n--- Sort by Family using Lambda ---");

        // Collections.sort(personList, (o1, o2) -> o1.getId() - o2.getId());
        Collections.sort(personList, Comparator.comparingInt(Person::getId));
        printPersonList(personList, "\n--- Sort by Id using Lambda ---");
    }
}
