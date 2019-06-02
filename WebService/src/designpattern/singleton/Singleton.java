package designpattern.singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Singleton {
    private static Singleton uniqueInstance;

    private Collection<String> strList = new ArrayList<>();

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public Collection<String> getStrList() {
        return strList;
    }

    public boolean add(String str) {
        return strList.add(str);
    }

    public boolean remove(String str) {
        return strList.remove(str);
    }

    public void printList() {
        strList.forEach(System.out::println);
    }
}
