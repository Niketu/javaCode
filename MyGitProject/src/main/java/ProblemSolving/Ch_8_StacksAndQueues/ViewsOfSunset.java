package ProblemSolving.Ch_8_StacksAndQueues;

import ProblemSolving.Utils.Pair;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Algorithm processes the buildings as they are presented.
 * The number of buildings is not known in advance.
 * Buildings are specified by EAST-TO-WEST and known by their height.
 * The amount of memory used by the algorithm depends on the number of buildings that have view.
 * i.e. It should not depend on the number of buildings processed.
 * <p>
 * Approach:
 * - Use a stack to record the buildings that have a view.
 * - Each time a building b is processed, if it is taller than the building on the Top of the stack,
 * we pop the stack until we find a building that is taller than b.
 * - All buildings that are removed lie on the east of a taller building.
 *
 * 1,2
 * 2,4
 * 3,1
 * 5,3
 * 7,4
 * 9,8
 */

public class ViewsOfSunset {
    public static LinkedList<Pair<Integer, Integer>> examineBuildingsWithSunset(InputStream sin) {
        int idx = 0; // Building's index.
        Integer height;
        // Stores (building_idx, building_height) pair with sunset views.
        LinkedList<Pair<Integer, Integer>> buildingsWithSunset = new LinkedList<>();
        Scanner osin = new Scanner(sin);

        while (osin.hasNext()) {
            height = osin.nextInt();
            while (!buildingsWithSunset.isEmpty() &&
                    (height.compareTo(buildingsWithSunset.getLast().getValue()) >= 0)) {
                buildingsWithSunset.removeLast();
            }
            buildingsWithSunset.addLast(new Pair<>(idx++, height));
        }

        return buildingsWithSunset;
    }
}
