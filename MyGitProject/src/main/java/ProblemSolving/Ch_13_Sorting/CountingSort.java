package ProblemSolving.Ch_13_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hmahant on 7/21/16.
 */
public class CountingSort {
    // @include
    class Person implements Comparable<Person> {
        public Integer key;
        public String name;

        public Person(Integer k, String n) {
            key = k;
            name = n;
        }

        // Hash function for Person.
        @Override
        public int hashCode() {
            return key.hashCode() ^ name.hashCode();
        }

        @Override
        public int compareTo(Person p) {
            return key.compareTo(p.key);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Person && ((Person) o).key.equals(key)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void countingSort(ArrayList<Person> people) {
        Map<Integer, Integer> keyToCount = new HashMap<>();
        for (Person p : people) {
            if (keyToCount.containsKey(p.key)) {
                keyToCount.put(p.key, keyToCount.get(p.key) + 1);
            } else {
                keyToCount.put(p.key, 1);
            }
        }
        Map<Integer, Integer> keyToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> kc : keyToCount.entrySet()) {
            keyToOffset.put(kc.getKey(), offset);
            offset += kc.getValue();
        }

        while (!keyToOffset.isEmpty()) {
            Map.Entry<Integer, Integer> from = keyToOffset.entrySet().iterator()
                    .next();
            Integer toKey = people.get(from.getValue()).key;
            Integer toValue = keyToOffset.get(toKey);
            Collections.swap(people, from.getValue(), toValue);
            // Use key_to_count to see when we are finished with a particular key.
            Integer count = keyToCount.get(toKey) - 1;
            keyToCount.put(toKey, count);
            if (count > 0) {
                keyToOffset.put(toKey, toValue + 1);
            } else {
                keyToOffset.remove(toKey);
            }
        }
    }
}
