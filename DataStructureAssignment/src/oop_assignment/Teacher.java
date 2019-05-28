package oop_assignment;

import java.util.ArrayList;

public class Teacher extends Person implements Language {
    private String subject;

    Teacher() {
        System.out.println("Default constructor: Teacher created");
    }

    Teacher(String name, String subject) {
        super(name);
        setSubject(subject);
        System.out.println("Teacher created");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void printInfo() {
        System.out.format("%s teaches %s\n", getName(), subject);
    }

    @Override
    public void speak(ArrayList<String> languages) {
        System.out.format("%s can speak %s\n", getName(), languages);
    }

    @Override
    public String toString() {
        return String.format("Teacher{ %s, subject='%s' }", getName(), subject);
    }
}
