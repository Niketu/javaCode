package ProblemSolving.Ch_13_Sorting;

import java.util.Arrays;

/**
 * Created by hmahant on 7/21/16.
 */
public class CountOccurrences {
    public static void countOccurrences(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);

        int count = 1;
        for (int i = 1; i < a.length; ++i) {
            if (a[i] == a[i - 1]) {
                ++count;
            } else {
                System.out.print("(" + a[i - 1] + "," + count + "),");
                count = 1;
            }
        }
        System.out.println("(" + a[a.length - 1] + ',' + count + ")");
    }
}
