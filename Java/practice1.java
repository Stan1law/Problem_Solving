import java.util.Scanner;
import java.util.Arrays;

public class practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.println("Enter third number: ");
        int num3 = scanner.nextInt();

        int largestNumber = checkLargestnumber(num1, num2, num3);

        System.out.println("The largest number is: " + largestNumber);
    }

    public static int checkLargestnumber(int num1, int num2, int num3) {
        int[] numbers = {num1, num2, num3};
        Arrays.sort(numbers);
        int maxNumber = numbers[numbers.length - 1];
        return maxNumber;
    }
}
