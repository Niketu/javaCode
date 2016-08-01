package ProblemSolving.Ch_8_StacksAndQueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hmahant on 7/17/16.
 */
public class TowerOfHanoi {
    public static void moveTowerHanoi(int n) {
        List<LinkedList<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pegs.add(new LinkedList<>());
        }

        // Initialize pegs.
        for (int i = n; i >= 1; --i) {
            pegs.get(0).push(i);
        }

        transfer(n, pegs, 0, 1, 2);
    }

    private static void transfer(int n, List<LinkedList<Integer>> pegs,
                                 int from, int to, int use) {
        if (n > 0) {
            //FROM->USE->TO
            //FROM->TO
            //USE->TO->FROM
            transfer(n - 1, pegs, from, use, to);
            pegs.get(to).push(pegs.get(from).pop());
            System.out.println("Move from peg " + from + " to peg " + to);
            transfer(n - 1, pegs, use, to, from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        moveTowerHanoi(n);
    }
}
