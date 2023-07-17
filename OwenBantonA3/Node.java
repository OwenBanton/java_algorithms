// Owen Banton

package javaProjects.OwenBantonA3;

/**
 * Node class as demonstrated during class lecture on Jan. 12th, 2023.
 * Contains value and pointer attributes, default and alternate constructors.
 */
public class Node {

    int value; // Integer value of element.
    Node next; // Pointer to next element.

    public Node() {

    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }
}
