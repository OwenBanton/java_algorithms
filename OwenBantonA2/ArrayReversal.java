package javaProjects.OwenBantonA2;

import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6};


        myRevArray(arr);

        System.out.println(Arrays.toString(arr));

    }


    // Function that pushes each element into stack then pops them back in in reverse order.
    public static void myRevArray(int[] arr) {

        Stacks stack = new Stacks();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

    }
}


