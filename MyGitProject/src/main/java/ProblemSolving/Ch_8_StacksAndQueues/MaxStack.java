package ProblemSolving.Ch_8_StacksAndQueues;

import java.util.LinkedList;

import ProblemSolving.Utils.*;


/**
 * Created by hmahant on 7/16/16.
 */

public class MaxStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Pair<Integer, Integer>> aux = new LinkedList<>();

    public int pop() {
        if(empty()) {
            throw new RuntimeException("The stack is empty.");
        }

        Integer toReturn = stack.pop();

        if(aux.peek().getKey().compareTo(toReturn) == 0) {
            if(aux.peek().getValue() == 1) {
                aux.pop();
            } else if(aux.peek().getValue()-1 > 0){
                aux.push(new Pair(aux.pop().getKey(), aux.peek().getValue()-1));
            } else {
                aux.pop();
            }
        }

        return toReturn;
    }

    public void push(Integer element) {
        stack.push(element);
        if (!aux.isEmpty()) {
            if(element.compareTo(aux.peek().getKey()) == 0) {
                aux.peek().setValue(aux.peek().getValue()+1);
            } else if(element.compareTo(aux.peek().getKey()) > 0) {
                aux.push(new Pair(element, 1));
            }
        } else {
            aux.push(new Pair(element, 1));
        }
    }

    public int max() {
        if(empty()) {
            throw new RuntimeException("No max found. Empty stack.");
        }
        return aux.peek().getKey();
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public static void main(String... args) {
        MaxStack mStack = new MaxStack();

        System.out.println("Pushing 1: ");
        mStack.push(1);
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Pushing 2: ");
        mStack.push(2);
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Pushing 3: ");
        mStack.push(3);
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Pushing 4: ");
        mStack.push(4);
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Pushing 5: ");
        mStack.push(5);
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Pushing 5: ");
        mStack.push(5);
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Popping 5: ");
        mStack.pop();
        System.out.println("Max stack is: "+mStack.max());

        System.out.println("Popping 5: ");
        mStack.pop();
        System.out.println("Max stack is: "+mStack.max());
    }
}
