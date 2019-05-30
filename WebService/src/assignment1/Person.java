package assignment1;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private int id;
    private String name;
    private String family;

    Person() {
        this(0, "None", "None");
    }

    public Person(int id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(family, person.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, family);
    }

    @Override
    public int compareTo(Person o) {
        return this.getId() - o.getId();
    }

    // Inner class
    public static class SortById implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getId() - o2.getId();
        }
    }

    public static class SortByName implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class SortByFamily implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFamily().compareTo(o2.getFamily());
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }
}
