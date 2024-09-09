// # Problem: Palindrome Checker
// # Objective: Create a program that checks if a given string is a palindrome.

// # Instructions:

// # Prompt the user to enter a string.
// # The program should check if the string is a palindrome—a word, phrase, or sequence that reads the same backward as forward (ignoring spaces, punctuation, and case).
// # If the string is a palindrome, the program should print a message saying so; otherwise, it should say that the string is not a palindrome.
// # The program should continue to prompt the user for strings until they choose to exit.
import java.util.Scanner;

public class problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Palindrome Checker");
        while (true) {
            System.out.println("Enter a string: ");
            String input = scanner.nextLine();
            String reversed = new StringBuilder(input).reverse().toString();
            if (input.equals(reversed)) {
                System.out.println("The string is a palindrome.");
            } else {
                System.out.println("The string is not a palindrome.");
            }

            System.out.println("Do you want to input another string? (y/n)");
            String PlayAgain = scanner.nextLine();
            if (PlayAgain.equals("y")) {
                main(args);
            } else {
                System.out.println("Goodbye!");
                break;
            }

        }

    }

}
