import java.util.Scanner;
public class LabActivity2ndTerm {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int num1 = scanner.nextInt();
        
        if (num1 < 0){
            System.out.println("Factorial is not define for negative numbers!");
        }else{
            long factorial = 1;
            
            for (int i = 1; i <= num1; i++){
                factorial *= i;
            }
            System.out.println("Factorial: " + factorial);
        }
        
//        
        System.out.println("Enter a number: ");
        int num2 = scanner.nextInt();
        
        if(num2 < 0){
            System.out.append("Invalid");
        } else{
            System.out.println("Factors: ");
             for(int i = 1; i <= num2; i++){
                 if (num2 % i == 0){
                     System.out.println(i + " ");
                 }
             }
        }
        
        System.out.println("Enter a string: ");
        String Word = scanner.next();
        System.out.println("Enter the letter you want to count: ");
        char letter = scanner.next().charAt(0);
        
        int count = 0;
        
        for(int i = 0; i < Word.length(); i++){
            if (Word.charAt(i) == letter){
                count++;
            }
        }
        
        System.out.println(letter + " occurs " + count + " times");
    }
}
