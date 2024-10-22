
import java.util.Scanner;

public class LabExercise5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        boolean continueProcess = true;
        
        while (continueProcess){
            double subtotal = 0;
            int itemNum = 1;
            
            while (true){
            System.out.print("Enter item "+ itemNum + " Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter item " + itemNum + " quantity: ");
            int quantity = scanner.nextInt();
            
            subtotal += price * quantity;
            
            System.out.print("Do you want to add another item? (y/n): ");
            String response = scanner.next();
            
            if (response.equalsIgnoreCase("n")){
                break;
            }
            
            itemNum++;
        }
            
            double vat = subtotal * 0.12;
            double totalAmout = subtotal + vat;
            
            System.out.printf("Subtotal: %.1f%n", subtotal);
            System.out.printf("VAT: %.1f%n", vat);
            System.out.printf("Total amount: %.1f%n", totalAmout);
            
            System.out.print("Do you want to process another customer? (y/n): ");
            String response = scanner.next();
            
            if (response.equalsIgnoreCase("n")){
                continueProcess = false;
            }
        }
        
        System.out.println("Exiting the POS system");
            
        
    }
}
