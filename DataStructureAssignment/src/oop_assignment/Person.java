package oop_assignment;

import java.util.regex.Pattern;

public abstract class Person {
    private String name;

    Person () {
        System.out.println("Default constructor: Person was created");
    }

    Person (String name) {
        setName(name);
        System.out.println("Person was created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String pattern = "^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$";

        if (!Pattern.matches(pattern, name))
            throw new IllegalArgumentException("Illegal Name format: " + name);
        this.name = name;
    }

    // define abstract method
    public abstract void printInfo();
}
