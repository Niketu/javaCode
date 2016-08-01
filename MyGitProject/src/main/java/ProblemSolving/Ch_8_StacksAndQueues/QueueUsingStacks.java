package ProblemSolving.Ch_8_StacksAndQueues;

import java.util.LinkedList;

/**
 * Created by hmahant on 7/18/16.
 */
public class QueueUsingStacks {
    protected LinkedList<Integer> q1 = new LinkedList<>();
    protected LinkedList<Integer> q2 = new LinkedList<>();

    public void enqueue(int x) {
        q1.push(x);
    }

    public int dequeue() {
        if(q2.isEmpty()) {
            System.out.println("Q2 is empty. Trying to reload.");
            while(!q1.isEmpty()) {
                q2.push(q1.pop());
            }
        }

        if(!q2.isEmpty()) {
            return q2.pop();
        }

        throw new RuntimeException("The queue is empty!");
    }

    public static void main(String... args) {
        QueueUsingStacks qs = new QueueUsingStacks();
        qs.enqueue(1);
        qs.enqueue(2);
        qs.enqueue(3);
        qs.enqueue(4);

        System.out.println(qs.dequeue());

        qs.enqueue(9);
        qs.enqueue(10);

        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
    }
}
