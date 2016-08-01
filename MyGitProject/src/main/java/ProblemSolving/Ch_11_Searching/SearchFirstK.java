package ProblemSolving.Ch_11_Searching;

import java.util.ArrayList;

/**
 * Created by hmahant on 7/20/16.
 *
 * Given an array A and the key k and returns the first occurrence of k in A.
 * Return -1 if it does not appear in A.
 *
 * Binary search approach (Iterative)
 */
public class SearchFirstK {
    public static int searchFirst(ArrayList<Integer> A, int k) {
        int l = 0, r = A.size() - 1, res = -1;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (A.get(m) > k) {
                r = m - 1;
            } else if (A.get(m) == k) {
                // Records the solution and keep searching the left part.
                res = m;
                r = m - 1;
            } else { // A.get(m) < k
                l = m + 1;
            }
        }
        return res;
    }

    public static void main(String... args) {

    }
}
