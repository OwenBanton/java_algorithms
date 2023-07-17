package javaProjects.OwenBantonA3;
// Owen Banton
// Uses the linked list and node classes made by Owen Banton for Assignment 1.

/**
 * Selection sort class using linked list.
 */
public class MyPQ {

    MyLinkedList queue = new MyLinkedList();


    public void insert(int element) {
        queue.add(element);
    }

    /**
     * Function to loop through the queue while comparing each node's value against the currently established
     * minimum value held in a buffer.
     *
     * @return minimum value of the queue.
     */
    public int min() {
        Node buffer = new Node();
        int minBuffer;
        if (queue.head == null) { // case if queue is empty.
            return -1;
        }
        if (queue.head.next == null) { // case if head is the only node.
            return queue.head.value;
        } else {
            buffer = queue.head.next; // buffer to loop through list.
            minBuffer = queue.head.value; // variable to hold the lowest value to compare against other values.
            while (buffer.next != null) {   // loop through list comparing values
                if (minBuffer > buffer.value) { // if a lower value is found, it's stored in the buffer variable to be returned.
                    minBuffer = buffer.value;
                }
                buffer = buffer.next; // loop continues if the element value is greater than the min.
            }
        }
        return minBuffer;
    }

    /**
     * Uses min() function to determine lowest value in the queue and hold it in a buffer variable.
     * The remove function is then called from the linked list class to remove the node holding that value.
     * Would ideally be combined into the min() function to avoid looping twice.
     *
     *
     * @return the minimum value of the queue.
     */
    public int removeMin() {
        int buffer = min();        // buffer to indicate min value to be removed and to return it after removal
        queue.remove(min());       // linked list remove function is called
        return buffer;
    }

    /**
     * Uses size function from linked list class to loop through the queue and count the number of nodes.
     *
     * @return size of the queue.
     */
    public int size() {
        return queue.size();
    }   // linked list size function that loops through the queue is called to return size.

    /**
     * Uses toString function from linked list class to loop through the queue and append each value to a string.
     *
     * @return string containing each value in the queue.
     */
    public String toString() {
        return queue.toString();    // linked list string function that loops through the queue is called to return string.
    }
}
