package ProblemSolving.Utils;

/**
 * Created by hmahant on 7/15/16.
 */
public class Node {
    public Integer data;
    public Node next;

    public Node (Integer data) {
        this.data = data;
    }

    public String toString() {
        return data +"";
    }

    public static void printList(Node node) {
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
