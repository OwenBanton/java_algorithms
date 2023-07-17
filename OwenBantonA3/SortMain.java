package javaProjects.OwenBantonA3;

// Owen Banton

import java.util.Arrays;
import java.util.Random;

/**
 * Class to test three different sorting methods.
 */
public class SortMain {

    /**
     * Function that uses first part of code given in Assignment 3 instructions to fill the queue with random integers.
     *
     * @param priorityQueue to be filled with values.
     */
    public static void fillPQ(MyPQ priorityQueue) {
        int numItem = 100; // This decides how big your array is
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        for (int i = 0; i < numItem; i++) {
            priorityQueue.insert(myRand.nextInt(min, max));
        }
    }

    /**
     * Function to create a second queue that is filled in order using the removeMin function on the first queue until it's empty.
     *
     * @param priorityQueue to be sorted.
     * @return sorted queue.
     */
    public static MyPQ sortPQ(MyPQ priorityQueue) {
        MyPQ sortedPQ = new MyPQ();
        for (int i = 0; i < priorityQueue.size(); i++) {
            sortedPQ.insert(priorityQueue.removeMin());
        }
        return sortedPQ;
    }

    /**
     * Function that uses first part of code given in Assignment 3 instructions to fill the queue with random integers.
     *
     * @param priorityQueue to be filled with values.
     */
    public static void fillPQSort(MyPQSort priorityQueue) {
        int numItem = 100; // This decides how big your array is
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        for (int i = 0; i < numItem; i++) {
            priorityQueue.insert(myRand.nextInt(min, max));
        }
    }

    /**
     * Function that returns an already sorted queue. Created so that the queue would be sent through a function like the other one as to not influence time calculation.
     *
     * @param priorityQueue
     * @return same queue.
     */
    public static MyPQSort sortPQSort(MyPQSort priorityQueue) {
        return priorityQueue;
    }

    /**
     * Function that uses first part of code given in Assignment 3 instructions to fill the heap with random integers.
     *
     * @param heap to be filled with values.
     */
    public static void fillHeap(MyHeap heap) {
        int numItem = 100; // This decides how big your array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length - 1; i++) {
            heap.insert(myRand.nextInt(min, max)); // storing random integers in an array
        }

    }

    /**
     * Function to create a second queue that is filled in order using the removeMin function on the first queue until it's empty.
     *
     * @param heap to be sorted.
     * @return sorted list of heap elements.
     */
    public static int [] sortHeap (MyHeap heap) {
       int [] sortedHeap = new int[heap.getHeapSize()];
        for (int i = 0; i < heap.getHeapSize(); i++) {
            sortedHeap[i] = heap.removeMin();
        }
        return sortedHeap;
    }

    public static void main(String[] args) {

        // Testing and timing MyPQ sort method. Not sure why but it's only returning half of the values from the initial list.

        MyPQ unsortedPQ = new MyPQ();

        double startTime2 = System.nanoTime();
        fillPQ(unsortedPQ);
        System.out.println(sortPQ(unsortedPQ));
        double endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to sort MyPQ is " + duration2);

        // Testing and timing MyPQSort sort method.

        MyPQSort pqSort = new MyPQSort();

        double startTime = System.nanoTime();
        fillPQSort(pqSort);
        System.out.println(sortPQSort(pqSort));
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to sort MyPQSort is " + duration);

        // Testing and timing Heap sort method. Wasn't able to get this working properly. Doesn't sort and returns one value and then another repeated 99 times.

        MyHeap heap = new MyHeap(100);

        double startTime3 = System.nanoTime();
        fillHeap(heap);
        System.out.println(heap.toString());
        System.out.println(Arrays.toString(sortHeap(heap)));
        double endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to sort Heap is " + duration3);


    }
}
