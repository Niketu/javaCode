package ProblemSolving.Ch_12_HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hmahant on 7/21/16.
 */
public class NearestRepitition {
    public static int findNearestRepetition(List<String> s) {
        Map<String, Integer> stringToLocation = new HashMap<>();
        int closestDis = Integer.MAX_VALUE;
        for (int i = 0; i < s.size(); ++i) {
            if (stringToLocation.containsKey(s.get(i))) {
                closestDis = Math.min(closestDis, i - stringToLocation.get(s.get(i)));
            }
            stringToLocation.put(s.get(i), i);
        }
        return closestDis;
    }
}
