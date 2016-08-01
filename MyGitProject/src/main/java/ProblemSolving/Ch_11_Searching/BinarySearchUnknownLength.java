package ProblemSolving.Ch_11_Searching;

import java.util.List;

import static java.lang.Math.max;

/**
 * Created by hmahant on 7/20/16.
 */
public class BinarySearchUnknownLength {
    public static int binarySearchUnknownLength(List<Integer> A, int k) {
        // Find the possible range where k exists.
        int p = 0;
        while (true) {
            try {
                int val = A.get((1 << p) - 1);
                if (val == k) {
                    return (1 << p) - 1;
                } else if (val > k) {
                    break;
                }
            } catch (Exception e) {
                break;
            }
            ++p;
        }

        // Binary search between indices 2^(p - 1) and 2^p - 2.
        // Need max below in case k is smaller than all entries
        // in A, since p becomes 0.
        int left = max(0, 1 << (p - 1)), right = (1 << p) - 2;
        while (left <= right) {
            int m = left + ((right - left) / 2);
            try {
                int val = A.get(m);
                if (val == k) {
                    return m;
                } else if (val > k) {
                    right = m - 1;
                } else { // A[m] < k
                    left = m + 1;
                }
            } catch (Exception e) {
                right = m - 1; // Search the left part if out of boundary.
            }
        }
        return -1; // Nothing matched k.
    }
}
