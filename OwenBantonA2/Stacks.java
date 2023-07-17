// Owen Banton
// Uses the linked list and node classes made by Owen Banton for Assignment 1.

package javaProjects.OwenBantonA2;

import javaProjects.OwenBantonA3.MyLinkedList;
import javaProjects.OwenBantonA3.Node;

public class Stacks {

    public Stacks() {

    }

    public MyLinkedList stack = new MyLinkedList(); // Creating an object of the linked list class.

    /**
     * Getter function to return the head of the stack.
     *
     * @return head of stack.
     */
    public Node getHead() {
        return stack.head;
    }

    /**
     * Uses add function from linked list class to push an element to the top of the stack.
     *
     * @param element = integer value to be added.
     */
    public void push(int element) {
        stack.add(element);
    }

    /**
     * Uses remove function from linked list class to identify value of the head and then remove the first instance of it (found at the head).
     * Creates a buffer in order to return the value after it is removed.
     *
     * @return the value popped from the stack.
     */
    public int pop() {
        int lastValue = stack.head.getValue();
        int lastValueBuffer = lastValue;
        stack.remove(lastValue);
        return lastValueBuffer;
    }

    /**
     * Function to add the top two values of the stack together. These two values are then popped, and their sum is pushed onto the top of the stack.
     *
     * @return the sum of the two values.
     */
    public int add() {
        int sum = stack.head.getValue() + stack.head.getNext().getValue();
        pop();
        pop();
        push(sum);
        return sum;
    }


    /**
     * Same function as previous, but multiplies two top values rather than adding them.
     *
     * @return product of top two values.
     */
    public int multi() {
        int product = stack.head.getValue() * stack.head.getNext().getValue();
        pop();
        pop();
        push(product);
        return product;
    }

    /**
     * Uses size function from linked list class to loop through the stack until the end and return the size.
     *
     * @return size of the stack.
     */
    public int size() {
        return stack.size();
    }

    /**
     * Uses toString function from linked list class to loop through each item of the stack and append it to a string builder object.
     *
     * @return string value of the string builder object containing each value of the stack.
     */
    public String toString() {
        return stack.toString();
    }
}
