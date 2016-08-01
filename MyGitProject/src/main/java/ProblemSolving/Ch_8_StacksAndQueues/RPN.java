package ProblemSolving.Ch_8_StacksAndQueues;

import java.util.LinkedList;

/**
 * Created by hmahant on 7/17/16.
 */
public class RPN {
    public static int evaluateRPN(String s) {
        LinkedList<Integer> evalStack = new LinkedList<>();
        for (char symbol : s.toCharArray()) {
            if ("+-*/".contains(symbol+"")) {
                int y = evalStack.pop();
                int x = evalStack.pop();
                switch (symbol) {
                    case '+':
                        evalStack.push(x + y);
                        break;
                    case '-':
                        evalStack.push(x - y);
                        break;
                    case '*':
                        evalStack.push(x * y);
                        break;
                    case '/':
                        evalStack.push(x / y);
                        break;
                    default:
                        throw new IllegalArgumentException("Malformed RPN at :" + symbol);
                }
            } else { // symbol is a number.
                evalStack.push(Integer.parseInt(symbol+""));
            }
        }
        return evalStack.pop();
    }

    public static void main(String... args) {
        String rpn = "12+4*51-+";
        System.out.println("Expected answer = 16, Actual answer is = "+evaluateRPN(rpn));
    }
}
