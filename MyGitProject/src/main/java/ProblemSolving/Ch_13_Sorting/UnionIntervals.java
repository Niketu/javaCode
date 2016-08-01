package ProblemSolving.Ch_13_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hmahant on 7/21/16.
 */
class ExInterval implements Comparable<ExInterval> {
    class Endpoint {
        public boolean isClose;
        public int val;
    }

    public int compareTo(ExInterval i) {
        if (left.val < i.left.val) {
            return -1;
        }
        if (left.val > i.left.val) {
            return 1;
        }
        if (left.isClose && !i.left.isClose) {
            return -1;
        }
        if (!left.isClose && i.left.isClose) {
            return 1;
        }
        return 0;
    }

    public Endpoint left = new Endpoint();
    public Endpoint right = new Endpoint();
}
public class UnionIntervals {

    public static List<ExInterval> unionExIntervals(List<ExInterval> I) {

        // Empty input.
        List<ExInterval> uni = new ArrayList<>();
        if (I.isEmpty()) {
            return uni;
        }

        // Sorts ExIntervals according to their left endpoints.
        Collections.sort(I);
        ExInterval curr = new ExInterval();
        curr = I.get(0);

        for (int i = 1; i < I.size(); ++i) {
            if (I.get(i).left.val < curr.right.val
                    || (I.get(i).left.val == curr.right.val
                    && (I.get(i).left.isClose || curr.right.isClose))) {
                if (I.get(i).right.val > curr.right.val
                        || (I.get(i).right.val == curr.right.val
                        && I.get(i).right.isClose)) {
                    curr.right = I.get(i).right;
                }
            } else {
                uni.add(curr);
                curr = I.get(i);
            }
        }
        uni.add(curr);
        return uni;
    }
}
