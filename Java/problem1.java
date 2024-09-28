// # Problem: Write a program that takes a string as input and prints out the number of vowels in the string.

// # Example Input/Output:

// # Input: "Hello World"
// # Output: 3 (because there are 3 vowels: e, o, and o)
// # Constraints:

// # The input string will only contain letters (a-z or A-Z) and spaces.
// # You can assume that the input string is not null.
// # Your Task:

// # Write a method that takes a string as input and returns the number of vowels in the string.

// # Hint: You can use a simple loop to iterate over the characters in the string, and a conditional statement to check if each character is a vowel.
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a Word: ");
        String InputWord = scanner.next();
        int count = 0;

        // for (int i = 0; i < InputWord.length(); i++) {
        //     if (InputWord.charAt(i) == 'a' || InputWord.charAt(i) == 'e' || InputWord.charAt(i) == 'i'
        //             || InputWord.charAt(i) == 'o' || InputWord.charAt(i) == 'u' || InputWord.charAt(i) == 'A'
        //             || InputWord.charAt(i) == 'E' || InputWord.charAt(i) == 'I' || InputWord.charAt(i) == 'O'
        //             || InputWord.charAt(i) == 'U') {
        //         count++;
        //     }
        // }
        //Better way to do it
        for (int i = 0; i < inputWord.length(); i++) {
            char ch = Character.toLowerCase(inputWord.charAt(i)); // Convert to lowercase for easier checking
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("Number of Vowels: " + count);

    }
}
