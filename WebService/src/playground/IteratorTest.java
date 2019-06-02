package playground;

import assignment1.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();

        personList.add(new Person(4, "Marie", "France"));
        personList.add(new Person(5, "Mark", "Corry"));
        personList.add(new Person(1, "James", "Dean"));
        personList.add(new Person(3, "Michael", "Jackson"));
        personList.add(new Person(2, "Bill", "Smith"));

        Iterator<Person> it = personList.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == 1) {
                it.remove();
            }
        }
        personList.forEach(p -> System.out.println(p));

        // personList = personList.stream().filter(p -> p.getId() != 3).collect(Collectors.toCollection(ArrayList::new));

        personList.removeIf(p -> p.getId() == 2);
        personList.forEach(p -> System.out.println(p));
    }
}
