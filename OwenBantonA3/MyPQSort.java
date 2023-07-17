package javaProjects.OwenBantonA3;

// Owen Banton
// Uses the linked list and node classes made by Owen Banton for Assignment 1.

/**
 * Insertion sort class using linked list.
 */
public class MyPQSort {

    MyLinkedList queue = new MyLinkedList();

    public Node head = null;

    /**
     * Uses the addInOrder function from the linked list class to sort a new element into the list by comparing
     * its value against subsequent elements.
     *
     * @param element
     */
    public void insert(int element) {
        queue.addInOrder(element);      // calling linked list function to insert and sort the element
    }

    /**
     * Returns the head of the queue as it will always be the minimum value since it is sorted as it's added.
     *
     * @return the minimum value of the queue.
     */
    public int min() {
        return head.value;
    }

    /**
     * Removes the head of the queue as it will always be the minimum value since it is sorted as it's added.
     *
     * @return the minimum value of the queue before removal.
     */
    public int removeMin() {
        int buffer = head.value;        // buffer to hold value to return after removal
        queue.remove(head.value);       // linked list remove function is called
        return buffer;
    }

    /**
     * Uses size function from linked list class to loop through the queue and count the number of nodes.
     *
     * @return size of the queue.
     */
    public int size() {
        return queue.size();   // linked list size function that loops through the queue is called to return size.
    }

    /**
     * Uses toString function from linked list class to loop through the queue and append each value to a string.
     *
     * @return string containing each value in the queue.
     */
    public String toString() {
        return queue.toString();    // linked list string function that loops through the queue is called to return string.
    }
}
