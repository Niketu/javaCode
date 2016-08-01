package ProblemSolving.Ch_13_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hmahant on 7/21/16.
 */
public class IntersectArrays {
    public static List<Integer> intersect1(List<Integer> A, List<Integer> B) {
        List<Integer> intersect = new ArrayList<>();
        for (int i = 0; i < A.size(); ++i) {
            if (i == 0 || !A.get(i).equals(A.get(i - 1))) {
                for (Integer b : B) {
                    if (A.get(i).equals(b)) {
                        intersect.add(A.get(i));
                        break;
                    }
                }
            }
        }
        return intersect;
    }

    //2
    public static List<Integer> intersect2(List<Integer> A, List<Integer> B) {
        List<Integer> intersect = new ArrayList<>();
        for (int i = 0; i < A.size(); ++i) {
            if ((i == 0 || !A.get(i).equals(A.get(i - 1)))
                    && Collections.binarySearch(B, A.get(i)) >= 0) {
                intersect.add(A.get(i));
            }
        }
        return intersect;
    }

    //3
    public static List<Integer> intersect3(List<Integer> A, List<Integer> B) {
        List<Integer> intersect = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j)) && (i == 0 || !A.get(i).equals(A.get(i - 1)))) {
                intersect.add(A.get(i));
                ++i;
                ++j;
            } else if (A.get(i) < B.get(j)) {
                ++i;
            } else { // A.get(i) > B.get(j).
                ++j;
            }
        }
        return intersect;
    }
}
