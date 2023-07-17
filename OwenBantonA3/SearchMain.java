package javaProjects.OwenBantonA3;

// Owen Banton

import java.util.Arrays;
import java.util.Random;

/**
 * Class to test loop comparison search and binary search methods.
 */

public class SearchMain {

    public static void main(String[] args) throws Exception {

        /**
         * Code provided with Assignment 3 instructions to build an array of random integers.
         */
        int numItem = 100; // This decides how big your array is
        int[] myArr = new int[numItem];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(min, max); // storing random integers in an array
        }

        int myVal = 10;     // Value to search for.


        // Loop Search time test.
        double startTime = System.nanoTime();
        System.out.println(loopSearch(myArr, myVal));
        double endTime = System.nanoTime();
        double duration = (endTime - startTime); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to loop search is " + duration);

        // Binary Search time test.
        double startTime2 = System.nanoTime();
        Arrays.sort(myArr);
        System.out.println(binarySearch(myArr, myVal, indexMin, myArr.length-1));
        double endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2); // divide by 1000000 to get milliseconds.
        System.out.println("the time it took to binary search is " + duration2);
    }


    /**
     * function to loop through an array, comparing each element to the specified value.
     * @param array to search
     * @param value to search for
     * @return either index of element that matches the value or -1 for a negative result.
     */
    public static int loopSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {    // loop through array
            if (array[i] == value) {                // checking given element for value
                return i;                           // returns index if found
            }
        }
        return -1;                                  // returns -1 if value not found in the array.
    }

    //    public static int binarySearch(int[] array, int value) {
//        if (array[(array.length - 1) / 2] == value) {
//            return (array.length - 1) / 2;
//        } else if (array[(array.length - 1) / 2] > value) {
//            int[] newArray = Arrays.copyOfRange(array, 0, (array.length - 1) / 2 - 1);
//            return binarySearch(newArray, value);
//        } else if (array[(array.length - 1) / 2] < value) {
//            int[] newArray = Arrays.copyOfRange(array, (array.length - 1) / 2 + 1, (array.length - 1));
//            return binarySearch(newArray, value);
//        }
//        return -1;
//    }
//

    /**
     * Binary search method to split the array in half based on the comparison between the value and the midpoint, narrowing down the array until the value is found or excluded.
     * Originally approached this by making a copy of the half of the array that was to be passed through the function again (above) but kept getting errors with the ranges. Adopted the textbook's approach of
     * passing low and high index ranges instead, which also saves time by not having to copy values. (Data Structures and Algorithms, Goodrich et. al,  pp. 197).
     *
     * @param array sorted array to be searched
     * @param value to search for in the array
     * @param low value of the lower index to search from in the array
     * @param high value of the higher index to search from in the array
     * @return either index of element that matches the value or -1 for a negative result.
     */
    public static int binarySearch(int[] array, int value, int low, int high) {
        if (low > high){        // base case that occurs either when inputs are incorrect or the value isn't found in the array.
            return -1;
        }
        int mid = (low + high) / 2; // determining the pivot point for the next call of the function.
        if (array[mid] == value) {      // case for finding the value.
            return mid;
        } else if (value < array[mid]) {        // case if value is less than the midpoint, the lower half of the array will be called.
            return binarySearch(array, value, low, mid - 1);
        } else {        // case if value is greater than the midpoint, the lower half of the array will be called.
            return binarySearch(array, value, mid + 1, high);
        }
    }
}

