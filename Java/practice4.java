/**Problem: Array Sum and Average
Write a Java program that:

Asks the user to enter N numbers (where N is provided by the user).
Stores these numbers in an array.
Calculates and prints the sum of all the numbers.
Calculates and prints the average of the numbers.
Requirements:
Use an array to store the numbers.
Write a method calculateSum that takes the array of numbers as a parameter and returns the sum.
Write a method calculateAverage that takes the array and returns the average.
Example:

Copy code
Input: 
Enter the number of elements: 5
Enter number 1: 10
Enter number 2: 20
Enter number 3: 30
Enter number 4: 40
Enter number 5: 50

Output:
Sum: 150
Average: 30.0
Hints:
Use a loop to input the numbers.
The average is calculated by dividing the sum by the total number of elements (N).

 *
 * @author Stanley
 */
import java.util.Scanner;

public class practice4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[5]; // Only 5 elements are needed
        
        System.out.println("Enter the number of elements: 5");
        
        // Loop to input all numbers from index 0 to 4
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }
        
        double sumOfNumbers = calculateSum(numbers);
        double averageOfNumbers = calculateAverage(numbers);
        
        System.out.println("Sum: " + sumOfNumbers);
        System.out.println("Average: " + averageOfNumbers);
    }
    
    // Method to calculate the sum of numbers
    public static double calculateSum(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
    
    // Method to calculate the average of numbers
    public static double calculateAverage(double... numbers) {
        double sum = calculateSum(numbers); // Reuse the sum method
        return sum / numbers.length;
    }
}
