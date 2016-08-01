package ProblemSolving.Ch_7_Lists;

import java.util.HashMap;
import java.util.Map;

public class CopyJumpList<T> {

    public RandomListNode<T> copyRandomList(RandomListNode head) {
        while(head == null) {
            return head;
        }

        RandomListNode<Integer> currentNew = new RandomListNode<>(-1);
        RandomListNode current = head;
        RandomListNode dummy = currentNew;

        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

        //First copy the data and next pointer field
        while(current != null) {
            RandomListNode t = new RandomListNode(current._data);
            t._next = current._next;
            dummy._next = t;
            nodeMap.put(current, current._random);
            current = current._next;
            dummy = dummy._next;

        }

        current = head;
        dummy = currentNew._next;

        //Copy the jump/random pointer now
        while(current != null) {
            dummy._random = nodeMap.get(current);
            dummy = dummy._next;
            current = current._next;
        }

        return currentNew._next;
    }

    public static void main(String... args) {
        //(1, 4) -> (2, 1) -> (3, 2) -> (4, 2)
        RandomListNode<Integer> four = new RandomListNode<>(4);
        RandomListNode<Integer> three = new RandomListNode<>(3);
        RandomListNode<Integer> two = new RandomListNode<>(2);
        RandomListNode<Integer> one = new RandomListNode<>(1);

        one._next = two;
        two._next = three;
        three._next = four;

        one._random = four;
        two._random = one;
        three._random = two;
        four._random = two;

        //Print input list
        RandomListNode<Integer> current = one;


        CopyJumpList jumpList = new CopyJumpList();
        System.out.print("Original List:: ");
        jumpList.printList(current);
        System.out.println();
        System.out.print("Copied List:: ");
        jumpList.printList(jumpList.copyRandomList(one));

    }

    private void printList(RandomListNode<Integer> current) {
        while (current != null) {
            System.out.print(current);
            System.out.print("(");
            System.out.print(current._next == null ? 0 : current._next);
            System.out.print(",");
            System.out.print(current._random == null ? 0 : current._random);
            System.out.print(")");
            current = current._next;
            if (current != null) {
                System.out.print("->");
            }
        }
    }
}

class RandomListNode<T> {
    T _data;
    RandomListNode _next;
    RandomListNode _random;

    RandomListNode(T data) {
        _data = data;
    }

    public String toString() {
        return "" + _data;
    }
}
