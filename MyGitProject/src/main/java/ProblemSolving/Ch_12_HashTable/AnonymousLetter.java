package ProblemSolving.Ch_12_HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hmahant on 7/21/16.
 */
public class AnonymousLetter {
    public static boolean anonymousLetter(String L, String M) {
        Map<Character, Integer> hash = new HashMap<>();
        // Inserts all chars in L into a hash table.
        for (char c : L.toCharArray()) {
            if (!hash.containsKey(c)) {
                hash.put(c, 1);
            } else {
                hash.put(c, hash.get(c) + 1);
            }
        }

        // Checks characters in M that could cover characters in a hash table.
        for (char c : M.toCharArray()) {
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) - 1);
                if (hash.get(c) == 0) {
                    hash.remove(c);
                    if (hash.isEmpty()) {
                        return true;
                    }
                }
            }
        }
        // No entry in hash means L can be covered by M.
        return hash.isEmpty();
    }
}
