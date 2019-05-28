package playground;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        // create a HashMap
        Map<Integer, Integer> hMap = new HashMap<>();

        // assign values.
        for (int i=0; i<10; i++) {
            int newKey = (int)(Math.random() * 10) + 1;     // 1 ~ 10
            if (hMap.containsKey(newKey)) {
                hMap.put(newKey, hMap.get(newKey) + 1);
            } else {
                hMap.put(newKey, 1);
            }
        }

        // using entrySet
        Iterator it = hMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
            System.out.format("%d, %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        // using keySet
        Iterator keyIt = hMap.keySet().iterator();
        while (keyIt.hasNext()) {
            Integer key = (Integer)keyIt.next();
            System.out.format("%d, %d\n", key, hMap.get(key));
        }
        System.out.println();

        hMap.forEach((key, value) -> System.out.format("%d, %d\n", key, value));
    }
}
