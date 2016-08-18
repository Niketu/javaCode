package ProblemSolving.CoreJava;

import java.util.Stack;

/**
 * Created by ndave on 8/4/16.
 */
public class MyStack {
    public static void main(String [] args) {
        Stack stack = new Stack();
        stack.push("first Object");
        stack.push("Second Object");
        stack.push("Third Object");
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());


    }
}
