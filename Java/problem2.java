// # Problem: Write a program that takes a list of integers as input and prints out the second-largest number in the list.

// # Example Input/Output:

// # Input: [10, 20, 30, 40, 50]
// # Output: 40
// # Input: [5, 5, 5, 5, 5]
// # Output: None (since all numbers are the same)
// # Constraints:

// # The input list will contain at least two elements.
// # The input list will only contain integers.
// # If all numbers in the list are the same, the program should print None.
// # Your Task:

// # Write a Java (or Python, if you prefer) program that takes a list of integers as input and prints out the second-largest number in the list.

// # Hint: You can use a simple loop to iterate over the list, and keep track of the maximum and second-maximum values as you go.
import java.util.Scanner;
import java.util.Arrays;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a group of numbers: ");
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findSecondLargest(input));
    }

    public static Integer findSecondLargest(int[] numbers) {
        if (numbers.length < 2) {
            return null; // not enough elements
        }

        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1];
        int secondMaxNumber = -1;

        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] != max) {
                secondMaxNumber = numbers[i];
                break;
            }
        }

        return secondMaxNumber;
    }

}
