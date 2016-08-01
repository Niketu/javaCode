package ProblemSolving.Ch_11_Searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hmahant on 7/20/16.
 */
public class CompletionSearch {
    private static int lowerBound(List<Double> a, double val) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > val) {
                return i;
            }
        }
        return -1;
    }

    // @include
    public static double completionSearch(List<Double> A, double budget) {
        Collections.sort(A);
        // Calculates the prefix sum for A.
        List<Double> prefixSum = new ArrayList<>();
        double val = 0;
        for (Double a : A) {
            val += a;
            prefixSum.add(val);
        }
        // costs[i] represents the total payroll if the cap is A[i].
        List<Double> costs = new ArrayList<>();
        for (int i = 0; i < prefixSum.size(); ++i) {
            costs.add(prefixSum.get(i) + (A.size() - i - 1) * A.get(i));
        }

        int lower = lowerBound(costs, budget);

        if (lower == -1) {
            return -1.0; // No solution since budget is too large.
        }

        if (lower == 0) {
            return budget / A.size();
        }
        int idx = lower - 1;
        return A.get(idx) + (budget - costs.get(idx)) / (A.size() - idx - 1);
    }
}
