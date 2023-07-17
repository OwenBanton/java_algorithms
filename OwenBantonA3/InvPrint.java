package javaProjects.OwenBantonA3;

public class InvPrint {


    public static void main(String[] args) {


        MyLinkedList list = new MyLinkedList();


        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Node buffer = list.head;

        System.out.println(list.toString());

        inversePrint(buffer);

        System.out.println(list.toString());
    }


    public static void inversePrint(Node buffer) {

        if (buffer.next == null) {
            return;
        }

        inversePrint(buffer.next);  // Recursion call to travel to the end of the list.

        System.out.println(buffer.value); // Values printed in reverse order as recursive calls go back up.

    }

}
