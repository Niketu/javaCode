package ProblemSolving.Ch_13_Sorting;

import java.util.List;

/**
 * Created by hmahant on 7/21/16.
 */
public class RemoveDupsFromSortedArray {
    public static int removeDuplicates(List<Integer> a) {
        if (a.isEmpty()) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < a.size(); ++i) {
            if (!a.get(index).equals(a.get(i))) {
                a.set(++index, a.get(i));
            }
        }
        return index + 1;
    }
}
