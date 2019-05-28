package playground;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestHashSet {
    public static void main(String[] args) {
//        HashSet<String> hSet = new HashSet<>();
        TreeSet<String> hSet = new TreeSet<>();

        hSet.add("London");
        hSet.add("Paris");
        hSet.add("New York");
        hSet.add("San Francisco");
        hSet.add("Beijing");
        hSet.add("New York");

        for (String str : hSet) {
            System.out.format("%s ", str);
        }
        System.out.println();

        hSet.forEach(str -> System.out.format("%s ", str));
        System.out.println();

        Iterator it = hSet.iterator();
        while (it.hasNext()) {
            String key = (String)it.next();
            System.out.format("%s ", key);
        }

    }
}
