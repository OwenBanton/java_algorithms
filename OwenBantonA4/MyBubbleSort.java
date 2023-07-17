// Owen Banton

package javaProjects.OwenBantonA4;

public class MyBubbleSort {

    /**
     * Wrapper function to be able to call the bubble sort without specifying index values.
     *
     * @param arr array to be sorted.
     * @return sorted array.
     */
    public static int[] bubbleSort(int[] arr) {
        return bubbleSorter(arr, 0, arr.length);

    }


    /**
     * @param arr array to be sorted.
     * @param indexComp index value being sorted within the array.
     * @param indexMax  upper limit of unsorted portion of the array.
     * @return sorted array.
     */
    public static int[] bubbleSorter(int[] arr, int indexComp, int indexMax) {

        if (indexMax < 2) {                             // base case: array is returned if length is one or zero.
            return arr;
        }
        if (arr[indexComp] > (arr[indexComp + 1])) {        // value being sorted (starting with index 0) is compared with neighboring value to the right.
            int buffer;
            buffer = arr[indexComp];                        // values are swapped using a buffer variable if the value on the left is larger.
            arr[indexComp] = arr[indexComp + 1];
            arr[indexComp + 1] = buffer;
            if (indexComp + 2 == indexMax) {                        // check to see if the sorting process has reached the end of the unsorted portion and returns to the
                return bubbleSorter(arr, 0, --indexMax);  // beginning of the array, decreasing the unsorted portion by one.
            } else {
                return bubbleSorter(arr, ++indexComp, indexMax);    // if not at the end of the unsorted portion, the next index then compared.
            }
        } else if (indexComp + 2 == indexMax) {                 // same conditions to either return to the beginning or continue sorting but without a swap,
            return bubbleSorter(arr, 0, --indexMax);  // in the case the two values compared are already in the proper order.
        } else {
            return bubbleSorter(arr, ++indexComp, indexMax);
        }
    }

}
