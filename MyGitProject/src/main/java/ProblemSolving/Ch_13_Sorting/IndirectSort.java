package ProblemSolving.Ch_13_Sorting;

import java.io.*;
import java.util.*;

/**
 * Created by hmahant on 7/21/16.
 */
public class IndirectSort {
    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            // We want to close "closeable" silently
        }
    }

    public static void indirectSort(String fileName) throws Exception {
        // Stores file records into A.
        Scanner ifs = null;
        List<Integer> A = new ArrayList<>();
        try {
            ifs = new Scanner(new File(fileName));
            while (ifs.hasNextInt()) {
                A.add(ifs.nextInt());
            }
        } finally {
            close(ifs);
        }

        // Indirectly sorts file.
        Collections.sort(A);

        // Outputs file.
        PrintWriter ofs = null;
        try {
            ofs = new PrintWriter(new FileWriter(fileName));
            for (Integer a : A) {
                ofs.println(a);
            }
        } finally {
            close(ofs);
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(
            Iterable<T> iterable) {
        Iterator<T> iter = iterable.iterator();
        if (!iter.hasNext()) {
            return true;
        }
        T t = iter.next();
        while (iter.hasNext()) {
            T t2 = iter.next();
            if (t.compareTo(t2) > 0) {
                return false;
            }
            t = t2;
        }
        return true;
    }
}
