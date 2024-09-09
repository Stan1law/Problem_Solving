// Problem: Guessing Game
// Objective: Create a Java program that implements a simple number guessing game.

// Instructions:

// The program should randomly generate a number between 1 and 100.
// The user will try to guess the number.
// After each guess, the program should tell the user whether the guess was too high, too low, or correct.
// The game should continue until the user guesses the correct number.
// After the game ends, the program should display how many attempts it took to guess the correct number.
// Ask the user if they want to play again. If they choose to play again, the game should start over with a new random number.
import java.util.Random;
import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        // Create a new Random object to generate random numbers
        Random random = new Random();

        // Create a new Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 10
        int numberToGuess = random.nextInt(10) + 1;

        // Initialize the number of attempts
        int attempts = 0;

        // Loop until the user guesses the number
        while (true) {
            // Prompt the user to guess a number
            System.out.print("Guess a number between 1 and 10: ");

            // Read the user's input
            String input = scanner.next();

            // Try to parse the input as an integer
            try {
                int userGuess = Integer.parseInt(input);

                // Increment the number of attempts
                attempts++;

                // Check if the user's guess is correct
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    // The user guessed the number, print a congratulatory message
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");

                    // Break out of the loop
                    break;
                }
            } catch (NumberFormatException e) {
                // The user's input was not a valid integer, print an error message
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }

        // Ask the user if they want to play again
        System.out.print("Do you want to play again? (y/n) ");
        String playAgain = scanner.next();

        // Check if the user wants to play again
        if (playAgain.equalsIgnoreCase("y")) {
            // Call the main method to start a new game
            main(args);
        } else {
            // Print a goodbye message and exit
            System.out.println("Goodbye!");

        }
    }
}
