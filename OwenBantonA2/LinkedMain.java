// Owen Banton

package javaProjects.OwenBantonA2;

import javaProjects.OwenBantonA3.MyLinkedList;

public class LinkedMain {
    /**
     * Main function calling some functions from MyLinkedList to test.
     *
     * @param args
     */
    public static void main(String[] args) {


        MyLinkedList listOne = new MyLinkedList();
        MyLinkedList listTwo = new MyLinkedList();

        listOne.addInOrder(7);
        listOne.addInOrder(2);
        listOne.addInOrder(5);
        listOne.addInOrder(11);

        listTwo.addInOrder(7);
        listTwo.addInOrder(2);
        listTwo.addInOrder(5);
        listTwo.addInOrder(11);

        listTwo.add(5);
        listTwo.add(6);
        listTwo.add(4);
        listTwo.add(2);

        listTwo.addAfter(4, 3);

        listTwo.remove(11);


        System.out.println("list one: " + listOne.toString());
        System.out.println("list two: " + listTwo.toString());

        System.out.println("list one size: " + listOne.size());
        System.out.println("list two size: " + listTwo.size());

        System.out.println("list one contains 23: " + listOne.contains(23));
        System.out.println("list two contains 6: " + listTwo.contains(6));

        System.out.println("lists are equal: " + listOne.compare(listTwo));


    }

}
