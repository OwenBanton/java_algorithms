package javaProjects.OwenBantonA3;

// Owen Banton

/**
 * Array-based heap structure class.
 */
public class MyHeap {

    private int[] heap;
    private int heapSize;

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public MyHeap(int length) {
        heap = new int[length];
        heapSize = 0;
    }

    /**
     * function to insert a new element into the heap and then organize it according to its value.
     *
     * @param element
     */
    public void insert(int element) {
        if (heapSize < heap.length) {       // Makes sure there's room for the new element within the array.
            heap[heapSize] = element; // Adds the new element to the end of the array.
            upHeap(heapSize);         // Calls upheap function to organize the new element within the heap.
            heapSize++;
        }
    }


    /**
     * function to move an element up the heap until its value is less than that of its children.
     *
     * @param index of element to be moved up the heap.
     */
    private void upHeap(int index) {
        int bufferParent;       // buffer value to hold parent value while it swaps with the child.
        while (index > 0) {   // loop to compare value.
            int parent = (index - 1) / 2;   // pointer to the parent element of the compared value.
            if (heap[parent] <= heap[index]) { // If the parent value is smaller, exit the loop.
                break;
            }
            swap(index, parent);    // parent and child values are swapped if the child value is smaller.
            index = parent;
        }
    }

    /**
     * Helper function to swap two elements in the heap
     */
    private void swap(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    /**
     * function to return the root of the heap which should always be the element with the minimum value.
     *
     * @return the minimum value of the heap.
     */
    public int min() {
        return heap[0];
    }

    /**
     * function to remove the root of the heap which should always be the element with the minimum value.
     *
     * @return the minimum value of the heap before removal.
     */
    public int removeMin() {
        int minBuffer = heap[0]; // variable to hold initial root value for return.
        heap[0] = heap[size() - 1]; // root is swapped with last value in the heap.
        downHeap(heap[0]); // swapped value is organized down the heap.

        return minBuffer;
    }

    /**
     * Function to shift an element downwards in the heap until it's value is less than that of its child nodes.
     *
     * @param index of element to be organized down the heap.
     */
    private void downHeap(int index) {
        int leftChild = (index * 2) + 1;        // pointers to left and right children.
        int rightChild = (index * 2) + 2;
        int smallest = index;                        // buffer to hold value when elements are swapped.

        while (true) {      // loop through the heap
            if (leftChild < heapSize && heap[leftChild] < heap[smallest]) {  // Condition where the left child is the smaller than both the parent node and sibling node, it is swapped up.
                smallest = leftChild;
            }
            if (leftChild < heapSize && heap[leftChild] < heap[smallest]) {  // Condition where the right child is the smaller than both the parent node and sibling node, it is swapped up.
                smallest = leftChild;
            }
            if (smallest == index) {                                        // exit loop when the value's position is found in the heap.
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }


    /**
     * Function that returns the current size of the heap. Loops through until finding a 0 value, allowing the size to be found regardless of the length of the array.
     *
     * @return the number of nodes in the heap.
     */
    public int size() {
        int i = 0;      // index and counter values.
        int counter = 0;
        while (heap[i] != 0) {      // loop through array, counting elements.
            counter++;
            i++;
        }
        return counter;
    }


    /**
     * Function that returns the elements of the heap as a string.
     *
     * @return
     */
    public String toString() {
        StringBuilder heapString = new StringBuilder();
        int i = 0;
        while (heap[i] != 0) {                      // loop through the array, appending each element to the string.
            heapString.append(heap[i] + ", ");
            i++;
        }
        heapString.deleteCharAt(heapString.length() - 1);       // extra comma and white space removed from end of the string and then returned.
        heapString.deleteCharAt(heapString.length() - 1);
        return heapString.toString();
    }
}
