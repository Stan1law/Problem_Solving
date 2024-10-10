import java.util.InputMismatchException;
import java.util.Scanner;
public class LabExercise4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
        
        while (programRunning){
            try{
                System.out.println("Enter a number: ");
                int number = scanner.nextInt();
                int[] fibonacciSequence = getFibonacciSequence(number);

                System.out.println("Fibonacci Sequence: ");
                for (int i = 0; i < fibonacciSequence.length; i++){
                    System.out.println(fibonacciSequence[i] + " ");
                    if ( i < fibonacciSequence.length - 1){
                        System.out.print(",");
                    }
                } 

                System.out.println();

                System.out.println("Do you want to continue? (yes or no)");
                String keepRunning = scanner.next();
                if (keepRunning.equals("no")){
                    programRunning = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
    
    public static int[] getFibonacciSequence(int number){
        int[] fibonacciSequence = new int[number];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;
        
        for (int i = 2; i < number; i++){
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        
        return fibonacciSequence;
    }
}
