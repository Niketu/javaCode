package ProblemSolving.Ch_11_Searching;

import java.util.ArrayList;

/**
 * Created by hmahant on 7/20/16.
 */
public class FirstElementLargerK {

    public static int searchFirstLargerK(ArrayList<Integer> a, int k) {
        int l = 0, r = a.size() - 1, res = -1;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (a.get(m) > k) {
                // Records the solution and keep searching the left part.
                res = m;
                r = m - 1;
            } else { // A.get(m) <= k.
                l = m + 1;
            }
        }
        return res;
    }

    public static void main (String... args) {

    }
}
