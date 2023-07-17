// Owen Banton

package javaProjects.OwenBantonA4;

import java.util.ArrayList;


public class MyQuickSort {

    /**
     * Quicksort algorithm that designates a pivot value and organizes all other values into either an array of values less than the pivot, or an array of values greater than or equal to the pivot.
     * This sorting is performed recursively on all ensuing sub-arrays until they reach a size of one. They are then added back in order into the resulting sorted array.
     * Opted to use first index as a pivot, as it seemed slightly more simple than the last index, and substantially simpler than a random index. This would be detrimental in sorted arrays, but
     * given the task is sorting an array of 100 random integers, obtaining a sorting list is extremely unlikely. Used ArrayList rather than array for this function as the variable length is necessary for creating the partitions.
     *
     * @param arr array to be sorted
     * @return sorted array
     */
    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {

        if (arr.size() < 2) {                               // base case for arrays of size 0 or 1.
            return arr;
        }
        ArrayList<Integer> lessThan = new ArrayList<>();        // declaring lists for values to be sorted into, whether they're less than or equal to the pivot.
        ArrayList<Integer> greaterOrEqual = new ArrayList<>();
        int pivot = arr.get(0);                 // declaring the pivot value (first index of the array).
        for (int i = 1; i < arr.size(); i++) {  // loop through the array comparing each value to the pivot. i = 1 to exclude the pivot itself.
            if (arr.get(i) >= pivot) {
                greaterOrEqual.add(arr.get(i));     // larger or equal values sorted into one list, smaller values into the other.
            } else {
                lessThan.add(arr.get(i));
            }
        }
        greaterOrEqual = quickSort(greaterOrEqual);     // recursive call to continue partitioning each new array based on a pivot value.
        lessThan = quickSort(lessThan);

        ArrayList<Integer> sorted = new ArrayList<>();  // new list is created to hold sorted arrays.

        sorted.addAll(lessThan);                        // sorted arrays are added in order from least to greatest, with pivot value in the middle.
        sorted.add(pivot);
        sorted.addAll(greaterOrEqual);

        return sorted;                                  // sorted array of all values is returned.
    }

}
