// Owen Banton

package javaProjects.OwenBantonA4;

import java.util.*;

public class SortMain {


    /**
     * Code provided with Assignment 4 instructions to build an array of random integers.
     */
    public static void main(String[] args) throws Exception {
        int numItem = 100; // This decide how big you array is
        int numTest = 10; // How many times to run the sort test.
        int[][] myArr = new int[numTest][numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < numTest; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
                myArr[i][j] = myRand.nextInt(min, max); // storing random integers in an array of arrays
            }
        }

        ArrayList<Integer> myArrList = new ArrayList<>();

        for (int i = 0; i < numItem; i++) {
            myArrList.add(myRand.nextInt(min,max)); // storing random integers in an arraylist. Couldn't get a 2D arraylist working so the test reuses the same list unlike the array tests for bubblesort.
        }


        // Now bubble sort it
        double startTime = System.nanoTime();
        for (int i = 0; i < numTest; i++) {
             System.out.println(Arrays.toString(MyBubbleSort.bubbleSort(myArr[i])));
//            MyBubbleSort.bubbleSort(myArr[i]);
        }
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        double average = (duration / 10);
        System.out.println("the average time it took to bubble sort is " + average);

        // Now quick sort it
        double startTime2 = System.nanoTime();
        for (int i = 0; i < numTest; i++) {
             System.out.println(MyQuickSort.quickSort(myArrList));
//            MyQuickSort.quickSort(myArrList);
        }
        double endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2); // divide by 1000000 to get milliseconds.
        double average2 = (duration2 / 10);
        System.out.println("the average time it took to quick sort is " + average2);

        // Now merge sort it
        double startTime3 = System.nanoTime();
        for (int i = 0; i < numTest; i++) {
             System.out.println(MyMergeSort.mergeSort(myArrList));
//            MyMergeSort.mergeSort(myArrList);
        }
        double endTime3 = System.nanoTime();
        double duration3 = (endTime3 - startTime3); // divide by 1000000 to get milliseconds.
        double average3 = (duration3 / 10);
        System.out.println("the average time it took to merge sort is " + average3);

    }
}
