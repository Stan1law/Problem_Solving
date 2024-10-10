//Problem 1: Basic Operations Calculator
//Write a Java program that prompts the user to input two integers. Create methods to perform and display the results of:
//
//Addition
//Subtraction
//Multiplication
//Division (Handle division by zero error in the method)
import java.util.Scanner;
public class practice2 {
   
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.println("Addition: " + addition(num1, num2));
        System.out.println("Subtraction: " + subtraction(num1, num2));
        System.out.println("Multiplication: " + multiplication(num1 ,num2));
        
        if (num2 == 0){
            System.out.println("Division: Cannot divide by zero");
        } else {
            System.out.println("Division: " + division(num1, num2));
        }
    }
    
    public static int addition(int num1, int num2){
        return num1 + num2;
    }
    
    public static int subtraction(int num1, int num2){
        return num1 - num2;
    }
    
    public static int multiplication(int num1, int num2){
        return num1 * num2;
    }
    
    public static double division(double num1, double num2){
        return num1 / num2;
    }
}
