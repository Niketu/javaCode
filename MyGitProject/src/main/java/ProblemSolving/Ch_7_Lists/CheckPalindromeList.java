package ProblemSolving.Ch_7_Lists;

import ProblemSolving.Utils.Node;

/**
 * Created by hmahant on 7/16/16.
 */
public class CheckPalindromeList {
    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reverse = ReverseListIterative.reverseLinkedList(slow.next);

        while(head != null && reverse != null) {
            if(head.data != reverse.data) {
                return false;
            }

            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    public static void main(String... args) {
        Node a = new Node(1);
        Node b = new Node(2);
        a.next = b;
        Node c = new Node(3);
        b.next = c;
        Node d = new Node(2);
        c.next = d;
        Node f = new Node(1);
        d.next = f;

        System.out.println("Is list palindrome ? "+isPalindrome(a));
    }
}
