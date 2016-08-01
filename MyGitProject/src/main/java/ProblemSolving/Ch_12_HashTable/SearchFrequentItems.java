package ProblemSolving.Ch_12_HashTable;

import java.util.*;

/**
 * Created by hmahant on 7/21/16.
 */
public class SearchFrequentItems {
    public static List<String> searchFrequentTtems(List<String> in, int k) {
        // Finds the candidates which may occur >= n / k times.
        String buf = "";
        Map<String, Integer> hash = new HashMap<>();
        int n = 0; // Counts the number of strings.

        Iterator<String> sin = in.iterator();
        while (sin.hasNext()) {
            buf = sin.next();
            hash.put(buf, hash.containsKey(buf) ? hash.get(buf) + 1 : 1);
            ++n;
            // Detecting k + 1 items in hash, at least one of them must have exactly 1
            // in it. We will discard those k + 1 items by 1 for each.
            if (hash.size() == k + 1) {
                List<String> delKeys = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : hash.entrySet()) {
                    if (entry.getValue() - 1 == 0) {
                        delKeys.add(entry.getKey());
                    }
                }
                for (String s : delKeys) {
                    hash.remove(s);
                }

                for (Map.Entry<String, Integer> e : hash.entrySet()) {
                    hash.put(e.getKey(), e.getValue() - 1);
                }
            }
        }

        // Resets hash for the following counting.
        for (String it : hash.keySet()) {
            hash.put(it, 0);
        }

        // Counts the occurrence of each candidate word.
        sin = in.iterator();
        while (sin.hasNext()) {
            buf = sin.next();
            Integer it = hash.get(buf);
            if (it != null) {
                hash.put(buf, it + 1);
            }
        }

        // Selects the word which occurs >= n / k times.
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> it : hash.entrySet()) {
            if (n * 1.0 / k <= (double) it.getValue()) {
                ret.add(it.getKey());
            }
        }

        return ret;
    }

    public static void main(String... args) {

    }
}
