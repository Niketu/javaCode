package ProblemSolving.Ch_8_StacksAndQueues;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by hmahant on 7/18/16.
 */
public class MaxQueue extends QueueUsingStacks {
    public int max() {
        if (!q1.isEmpty()) {
            return q2.isEmpty() ? Collections.max(q1) : Collections.max(Arrays
                    .asList(Collections.max(q1), Collections.max(q2)));
        } else {
            if (!q2.isEmpty()) {
                return Collections.max(q2);
            }
            throw new RuntimeException("empty queue");
        }
    }

    public static void main(String... args) {
        MaxQueue qs = new MaxQueue();
        qs.enqueue(1);
        qs.enqueue(2);
        qs.enqueue(3);
        qs.enqueue(4);

        System.out.println(qs.dequeue());
        System.out.println("Max: "+qs.max());

        qs.enqueue(9);
        qs.enqueue(10);

        System.out.println("Max: "+qs.max());

        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println("Max: "+qs.max());
        System.out.println(qs.dequeue());
        System.out.println(qs.dequeue());
        System.out.println("Max: "+qs.max());
    }
}
