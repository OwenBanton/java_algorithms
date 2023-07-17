// Owen Banton

package javaProjects.OwenBantonA2;

import java.util.Scanner;

public class StackMain {

    /**
     * Main method printing out a welcome message, command list, and calling the input function.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Stacks!" + "\n");
        commandList();
        takeInput();
    }

    static Stacks stack = new Stacks(); // Creating object of the Stacks class.

    /**
     * Function to display user commands, displayed upon starting the program and when requested by user.
     */
    public static void commandList() {
        System.out.println("Available commands:" + "\n");
        System.out.println("a: specify an integer value and enter it into the stack.");
        System.out.println("p: remove the most recent value from the stack.");
        System.out.println("+: add the last two items of the stack.");
        System.out.println("*: multiply the last two items of the stack.");
        System.out.println("?: display the contents of the stack.");
        System.out.println("c: display commands.");
        System.out.println("z: exit stacks." + "\n");
    }

    /**
     * Function that allows for user to manipulate the stack through the scanner class.
     * Uses recursion to allow the user to continue inputting commands until exiting the program.
     */
    public static void takeInput() {
        System.out.println("\n" + "Please enter a command.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char command = input.charAt(0);           // Commands taken through the scanner and converted to char.
        switch (command) {                         // Different functions implemented based on command.
            case 'a':                               // Command a takes input of an integer simultaneously (reason for command conversion into char value).
                String [] numberGetter = input.split("a ");
                if (numberGetter.length > 1){
                int pushValue = Integer.parseInt(numberGetter[1]);      // Command is split into 'a' and an integer, the latter is pushed into the stack.
                stack.push(pushValue);
                System.out.println(pushValue + " has been added to the stack.");}
                else {                                                  // if/else to account for 'a' command without accompanying integer.
                    System.out.println("Please enter a number after the \"a\" command");
                }
                takeInput();                        // User is brought back to the top of the function after value is pushed.
                break;
            case 'p':
                System.out.println("Last number removed from stack.");
                stack.pop();                        // Last value is removed from the stack, user is updated and returned to top of function.
                takeInput();
                break;
            case '+':                  // Command for adding last two stack values, with conditions set for stacks of length 1 or 0.
                if (stack.getHead() != null && stack.getHead().getNext() != null) {
                    System.out.println("Last two values (" + stack.getHead().getValue() + "), (" + stack.getHead().getNext().getValue() + ") added:");
                    System.out.println(stack.add() + " added to the stack.");
                }
                else if (stack.getHead() != null && stack.getHead().getNext() == null) {
                    System.out.println("Only one value in the stack: " + stack.getHead().getValue());
                }
                else if (stack.getHead() == null) {
                    System.out.println("Stack is empty.");
                }
                takeInput();
                break;
            case '*':                   // Command for multiplying last two stack values, with conditions set for stacks of length 1 or 0.
                if (stack.getHead() != null && stack.getHead().getNext() != null) {
                    System.out.println("Last two values (" + stack.getHead().getValue() + "), (" + stack.getHead().getNext().getValue() + ") multiplied:");
                    System.out.println(stack.multi() + " added to the stack.");
                }
                else if (stack.getHead() != null && stack.getHead().getNext() == null) {
                    System.out.println("Only one value in the stack: " + stack.getHead().getValue());
                }
                else if (stack.getHead() == null) {
                    System.out.println("Stack is empty.");
                }
                takeInput();
                break;
            case '?':                   // Command for displaying the current stack, with condition set for an empty stack.
                if (stack.getHead() == null) {
                    System.out.println("Stack is empty.");
                } else {
                    System.out.println("Current stack: ");
                    System.out.println(stack.toString());
                }
                takeInput();
                break;
            case 'c':                   // Command to display the list of commands
                commandList();
                takeInput();
                break;
            case 'z':                   // Command to exit the program, message is displayed and recursion does not occur.
                System.out.println("Thank you for using stacks, goodbye.");
                break;
            default:                    // Case for input that doesn't match an available command.
                System.out.println("Please enter a valid command. Use \"c\" to see commands.");
                takeInput();
                break;
        }
    }
}
