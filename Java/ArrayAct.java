import java.util.Scanner;
public class ArrayAct {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        String[][] names = {
            {"Group1:", "Stanley", "Denzu", "Fayur"}, 
            {"Group2:", "Anna", "Marie", "Sammy"}
        };
        
        System.out.println("Names");
        for (int i = 0; i < names.length; i++){
            for (int j = 0; j < names[i].length; j++){
                System.out.println(names[i][j]);
            }
            System.out.println();
    }
        System.out.println("Do you want to add another name? (yes/no)");
        String response = scanner.nextLine();
        
        while(response.equalsIgnoreCase("yes")){
            System.out.println("What group do you want to add the name? (1/2):");
            int numGroup = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Enter a new name: ");
            String newName = scanner.nextLine();
            
            String[] newGroup = new String[names[numGroup -1].length + 1];
            
            for(int i = 0; i < names[numGroup - 1].length; i++){
                newGroup[i] = names[numGroup - 1][i];
        }
            newGroup[newGroup.length - 1] = newName;
            
            names[numGroup - 1] = newGroup;
            break;
        }
        
        
        System.out.println("Names\nBoys:");
        for (int i = 0; i < names.length; i++){
            for (int j = 0; j < names[i].length; j++){
                System.out.println(names[i][j]);
            }
            System.out.println();
    }
        
        System.out.println("Do you want to search for a name by index? (yes/no): ");
        String response2 = scanner.nextLine();
        
        if (response2.equalsIgnoreCase("yes")){
            System.out.print("Which group do want to search for (1/2): ");
            int numGroup = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter the index you want to search for (1-based index): ");
            int index = scanner.nextInt();
            scanner.nextLine();
            
            if (numGroup - 1 < names.length && index >= 0 && index < names[numGroup - 1].length){
                String foundName = names[numGroup - 1][index];
                System.out.println("The name that you search for is: " + foundName);
            }
        }
            
    }
}
