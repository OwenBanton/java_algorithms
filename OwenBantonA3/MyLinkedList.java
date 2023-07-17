// Owen Banton

package javaProjects.OwenBantonA3;

public class MyLinkedList {

    public MyLinkedList() {
    }

    public Node head = null;

    /**
     * Add method function as demonstrated during class lecture on Jan. 12th, 2023.
     * Adds a node with specified element to the head of the list.
     *
     * @param element
     */
    public void add(int element) {
        Node newNode = new Node(element, head);     // Function demonstrated in class. A new node is created pointing to the head
        head = newNode;                             // and then replaces the head, which becomes the second node.

    }

    /**
     * Adds a node with a specified element after the first instance of a node with a specified target value.
     *
     * @param element
     * @param afterInt
     */
    public void addAfter(int element, int afterInt) {
        Node newNode = new Node(element, null);
        Node buffer = new Node();
        if (head == null) {                 // uses add function to add element if list is empty.
            add(element);
        } else {
            buffer = head;                  // buffer as head to loop through list
            while ((buffer.value != afterInt) && (buffer.next != null)) {
                buffer = buffer.next;       // buffer loops until it finds target value or end of list.
            }
        }
        newNode.next = buffer.next;         // new node pointed to targeted node after value found by buffer.
        buffer.next = newNode;              // node with target value then points to new node

    }

    /**
     * Removes a node with specified value by reassigning the pointer of the node before it.
     *
     * @param value
     */
    public void remove(int value) {
        Node buffer = new Node();
        if (head == null) {
            head = null;
        } else if (head.value == value && head.next == null) {              // if target value is in the head node, and it is the only node, the head becomes null.
            head = null;
        } else if (head.value == value) {              // if target value is in the head node, the second node becomes the head.
            head = head.next;
        } else if (head.next.value == value && head.next.next != null) {         // if second node is target value, it is bypassed and head points to following node.
            head.next = head.next.next;
        } else {
            buffer = head;                      // buffer to loop through list.
            while ((buffer.next.next != null) && (buffer.next.next.value != value)) {
                buffer = buffer.next;           // buffer loops until finding value or list ends. Searches two nodes ahead to allow access to
            }                                   // following node's next value so bypassing the target value is possible.
            if (buffer.next.next != null) {
                buffer.next.next = buffer.next.next.next;       // bypassing the target value's node in the list after found in the loop.
            } else {
                buffer.next.next = null;        // condition for when the target value is in the final node, changes pointer to null to remove it.
            }
        }
    }

    /**
     * Removes all instances of nodes with specified value.
     *
     * @param value
     */
    public void removeAll(int value) {
        Node buffer = new Node();
        if (head.value == value) {
            head = head.next;
        }
        if (head.next.value == value) {
            head.next = head.next.next;
        } else {
            buffer = head;
            while ((buffer.next.next != null) && (buffer.next.next.value != value)) {
                buffer = buffer.next;
            }
            if (buffer.next.next != null) {
                buffer.next.next = buffer.next.next.next;
            } else {
                buffer.next.next = null;
            }
        }
        if (contains(value)) {                  // Check to see if any elements with target value remain, functions recurs if so.
            remove(value);
        }

    }

    /**
     * Loops through each node of the list in order to count them and determine list size.
     *
     * @return int size of the list.
     */
    public int size() {
        Node buffer = new Node();
        buffer = head;
        int count = 1;         // Counter starts at one because it's used when head != null.
        if (head == null) {     // Checks for an empty list.
            return 0;
        } else {
            while (buffer.next != null) {
                buffer = buffer.next;       // buffer created to loop to the end of the list, counts each node along the list.
                count++;
            }
        }
        return count;
    }

    /**
     * Loops through each node of the list to check for specified value.
     *
     * @param value
     * @return either true (value found) or false (value not found)
     */
    public boolean contains(int value) {
        if (head == null) {                 // Check for empty list.
            return false;
        }
        if (head.value == value) {          // Check for target value in head.
            return true;
        } else {
            Node buffer = new Node();
            buffer = head;                  // buffer to loop through list.
            while (buffer.next != null) {
                if (buffer.value == value) {        // Checks each node until finding value or end of list.
                    return true;
                } else {
                    buffer = buffer.next;
                }
                if ((buffer.next == null) && (buffer.value == value)) { // Condition for the target value being at the tail of the list.
                    return true;
                }
            }
        }
        return false; // return false if target value isn't found.
    }

    /**
     * Loops through each node of the list and appends its value to a string.
     *
     * @return
     */
    public String toString() {
        StringBuilder list = new StringBuilder(); // stringbuilder to hold and update list of node values.
        Node buffer = new Node();
        buffer = head;                             // buffer to loop through the list.
        if (head == null) {                         // Check for empty list.
            return "List is empty";
        } else {
            while (buffer.next != null) {
                list.append(buffer.value + ", ");   // buffer loops through the list, appending each value to the stringbuilder object.
                buffer = buffer.next;
            }
            list.append(buffer.value);              // final value is appended.
        }
        return list.toString();                     // result converted to string and returned.
    }

    /**
     * Loops through two lists to compare each node's value against the corresponding node of the second list.
     *
     * @param otherList
     * @return True if the lists are the same, false if they are not.
     */
    public boolean compare(MyLinkedList otherList) {
        Node bufferOne = head;
        Node bufferTwo = otherList.head;                        // Two buffers to loop each list and compare values.

        if (size() != otherList.size()) {                       // Using size function to see if lists are same size.
            return false;
        } else {
            while ((bufferOne.next != null) && (bufferTwo.next != null)) {
                if (bufferOne.value != bufferTwo.value) {
                    return false;                               // Any non-matching pair of values will return false.
                } else {
                    bufferOne = bufferOne.next;                 // matching values allow the loop to continue.
                    bufferTwo = bufferTwo.next;
                }
            }
            if (bufferOne.value != bufferTwo.value) {               // Condition for the last element as it won't be checked in while loop.
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Adds an element to the list in order of the size of its value in relation to the other values already in the list.
     *
     * @param element
     */
    public void addInOrder(int element) {
        if ((head == null) || (element <= head.value)) {       // Check if list is empty or head is larger than value,
            add(element);                                      // which would allow value to be added to head.
        } else if (head.next == null) {                        // Condition for list with only one element, value added before or after head.
            if (element < head.value) {
                add(element);
            } else {
                addAfter(element, head.value);
            }
        } else {
            Node buffer = new Node();
            buffer = head;                                      // buffer to loop through list.
            while (buffer.next != null) {
                if (element < buffer.next.value) {              // if following value is greater, new element will be added before it.
                    buffer.next = new Node(element, buffer.next);
                    return;
                } else {                                        // loop continues until finding greater value or end of list.
                    buffer = buffer.next;
                }
            }
            buffer.next = new Node(element, null);          // Condition for adding the value to the tail if it is the largest value.
        }

    }


}