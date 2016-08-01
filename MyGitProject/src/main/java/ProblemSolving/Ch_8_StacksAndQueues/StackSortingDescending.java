package ProblemSolving.Ch_8_StacksAndQueues;

import java.util.LinkedList;

/**
 * Created by hmahant on 7/18/16.
 *
 * Sort the given stack in descending order.
 *
 * Only allowed operations are push, pop, top.
 * Usage of extra memory beyond a few words is not allowed.
 */
public class StackSortingDescending {
    public static void sort(LinkedList<Integer> S) {
        if (!S.isEmpty()) {
            Integer e = S.pop();
            System.out.println("Recurse sort on: "+e);
            sort(S);
            System.out.println("Sort call stack completes for :"+e);
            insert(S, e);
        }
    }

    private static void insert(LinkedList<Integer> S, Integer e) {
        if (S.isEmpty() || e.compareTo(S.peek()) > 0) {
            System.out.println("*Insert: "+e);
            S.push(e);
        } else {
            Integer f = S.pop();
            System.out.println("Recurse insert on: "+ e);
            insert(S, e);
            System.out.println("Insert call stack completes for :"+e);
            S.push(f);
        }
    }

    public static void main(String[] args) {
        /*
        Output:
        Recurse sort on: 1
        Recurse sort on: 2
        Recurse sort on: 3
        Sort call stack completes for :3
        *Insert: 3
        Sort call stack completes for :2
        Recurse insert on: 2
        *Insert: 2
        Insert call stack completes for :2
        Sort call stack completes for :1
        Recurse insert on: 1
        Recurse insert on: 1
        *Insert: 1
        Insert call stack completes for :1
        Insert call stack completes for :1
        [3, 2, 1]
         */
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println("Before sorting: "+stack);
        sort(stack);
        System.out.println(stack);
    }
}
