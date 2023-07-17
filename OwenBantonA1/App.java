// Owen Banton

package javaProjects.OwenBantonA1;

import java.util.Random; // this creates random for our program

public class App {

    /**
     * Main function provided with assignment which builds an array of
     * random integers and calls functions to determine minimum value.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] myArr = new int[100];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin = 0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max - min + 1) + min; // storing random integers in an array
        }
        // here we check the last item of array to see if it is full:
        System.out.println(myArr[myArr.length - 1]); // printing last element, not the biggest or smallest but just the last one
        //now we find the minimum calling the function you wrote:
        indexMin = minFinder(myArr);
        System.out.println("The minimum is at location: " + indexMin + " The value is: " + myArr[indexMin]);
        indexMin = minFinder_recursive(myArr);
        System.out.println("The minimum is at location: " + indexMin + " The value is: " + myArr[indexMin]);
    }

    /**
     * Loops through an array while comparing the index to subsequent values to determine a minimum value.
     *
     * @param arr
     * @return int value of index with the lowest value
     */
    public static int minFinder(int[] arr) {
        int index = 0;
        int compIndex = index + 1;                 // two local values to loop through and index and the following index
        while ((compIndex < arr.length - 1)) {      // loop that goes until the end of the array
            if (arr[index] <= arr[compIndex]) {
                compIndex++;                        // if index isn't larger than following index, it compares to the next
            } else {
                index = compIndex;                  // if index is larger, the smaller value is then taken and compared
                compIndex++;                        // comparison index increased by one
            }
        }
        return index;
    }

    /**
     * Takes array as input and calls function to determine minimum value.
     *
     * @param arr
     * @return int value of index with the lowest value
     */
    public static int minFinder_recursive(int[] arr) {

        int firstIndex = 0;

        return minFindHelp(firstIndex, firstIndex + 1, arr);
    }

    /**
     * Loops through an array using recursion while comparing the index to subsequent values to determine a minimum value.
     *
     * @param index
     * @param compIndex
     * @param arr
     * @return int value of index with the lowest value
     */
    public static int minFindHelp(int index, int compIndex, int[] arr) {

        if (compIndex < arr.length - 1) {            // condition to stop recursion at the end of the array.
            if (arr[index] <= arr[compIndex]) {      // checking if current index value is greater than one it's being compared to.
                return minFindHelp(index, compIndex + 1, arr);      // if index value is smaller, function is run again with index compared to subsequent index.
            } else {
                return minFindHelp(compIndex, compIndex + 1, arr);      // if index value is larger, function run again with the smaller of the two values as an index.
            }
        }
        return index;                           // the index with the smallest value at the end of the array is returned.
    }

}
