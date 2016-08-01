package ProblemSolving.Ch_12_HashTable;

import java.util.*;

/**
 * Created by hmahant on 7/21/16.
 */
public class FindAnagrams {
    public static void findAnagrams(List<String> dictionary) {
        // Gets the sorted string and then insert into hash table.
        Map<String, List<String>> hash = new HashMap<>();
        for (String s : dictionary) {
            char[] sortedCa = s.toCharArray();
            // Uses sorted string as the hash code.
            Arrays.sort(sortedCa);
            String sortedStr = new String(sortedCa);
            if (!hash.containsKey(sortedStr)) {
                hash.put(sortedStr, new ArrayList<String>());
            }
            hash.get(sortedStr).add(s);
        }

        for (Map.Entry<String, List<String>> p : hash.entrySet()) {
            // Multiple strings with the same hash code => anagrams.
            if (p.getValue().size() >= 2) {
                // Output all strings.
                System.out.println(Arrays.toString(p.getValue().toArray()));
            }
        }
    }
}
