package oop_assignment;

import java.util.ArrayList;

public class Student extends Person implements Language{
    private String id;

    Student() {
        System.out.println("Default constructor: Student was created");
    }

    Student(String name, String id) {
        super(name);
        this.id = id;
        System.out.println("Student was created");
    }

    public String getId() { return id; }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void printInfo() {
        System.out.format("Student name is %s\n", getName());
    }

    @Override
    public void speak(ArrayList<String> languages) {
        System.out.format("%s can speak %s\n", getName(), languages);
    }

    @Override
    public String toString() {
        return String.format("Student{ %s, id='%s' }", getName(), id);
    }
}
