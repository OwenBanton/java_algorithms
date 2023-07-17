// Owen Banton

package javaProjects.OwenBantonA4;

import java.util.ArrayList;


public class MyMergeSort {

    /**
     * MergeSort function that recursively partitions arrays in half until reaching a length of 1. Then calls the merge function to merge them back into an array matching the original length, and sorting them while doing so.
     * Used ArrayList rather than array for this function as well, as the variable length is necessary for the merging of the partitions.
     * Follows the general outline of the pseudo-code explained in CCCS-315-784 Lecture 11 ("Merge Sort" Lecture Slide p. 3)
     *
     * @param arr array to be sorted.
     * @return sorted array.
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {

        if (arr.size() < 2) {                                                   // base case of array being length 1 or 0.
            return arr;
        }

        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, (arr.size() / 2)));              // creating a division of the array from the first to the middle index.
        ArrayList<Integer> right = new ArrayList<>(arr.subList((arr.size() / 2), arr.size()));    // creating a division of the array from the middle to the last index.

        left = mergeSort(left);                             // continuing to recursively split each subdivision until reaching a length of 1.
        right = mergeSort(right);

        ArrayList<Integer> mergedSorted = merge(left, right);        // calling the merge function to recombine the partitions.

        return mergedSorted;            // return the merged and sorted array.
    }

    /**
     * Method to sort and recombine all of the partitioned arrays from the mergeSort function.
     * Follows the general outline of the three while loops explained in CCCS-315-784 Lecture 11 ("Merge Sort" Lecture Slide p. 4) as no other method to properly merge the values in order seemed apparent.
     *
     * @param left  partitioned array
     * @param right partitioned array
     * @return both arrays sorted and combined into one.
     */
    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

        ArrayList<Integer> sorted = new ArrayList<>();

        int i = 0;          // int variables to loop through each side of the array.
        int j = 0;

        while (i < left.size() && j < right.size()) {       // comparing the left-most value of each array until one is empty, adding the smallest value to the sorted list after each comparison.
            if (left.get(i) <= right.get(j)) {
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {                           // add any remaining values from the left side if the right side is empty.
            sorted.add(left.get(i));
            i++;
        }

        while (j < right.size()) {                          // add any remaining values from the right side if the left side is empty.
            sorted.add(right.get(j));
            j++;
        }

        return sorted;                                      // return the merged and sorted combination of the two inputted arrays.
    }


}
