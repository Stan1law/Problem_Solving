import java.util.Scanner;
import java.util.ArrayList;
public class ArrayListAct {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>> names = new ArrayList<>();
        
        ArrayList<String> group1 = new ArrayList<>();
        group1.add("Stanley");
        group1.add("Denzu");
        group1.add("Fayur");
        names.add(group1);
        
        ArrayList<String> group2 = new ArrayList<>();
        group2.add("Anna");
        group2.add("Marie");
        group2.add("Sammy");
        names.add(group2);
        
        
        System.out.println("Groups:");
        for (int i = 0; i < names.size(); i++){
            System.out.print("Group " + (i + 1) + ": ");
            for (String name : names.get(i)){
                System.out.print(name + " ");
            }
            System.out.println();
        }
        
        System.out.print("\nDo you want to add a name to group1 or 2? (yes/no): ");
        String response = scanner.nextLine();
        
        if (response.equalsIgnoreCase("yes")){
            System.out.print("Which group do you want to add a name (enter group number 1, 2): ");
            int groupNumber = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter the new name: ");
            String newName = scanner.nextLine();
            
            names.get(groupNumber - 1).add(newName);
        }
        
        System.out.println("Groups:");
        for (int i = 0; i < names.size(); i++){
            System.out.print("Group " + (i + 1) + ": ");
            for (String name : names.get(i)){
                System.out.print(name + " ");
            }
            System.out.println();
        }
        
        System.out.print("\nDo you want to check a name in any group? (yes/no): ");
        String response2 = scanner.nextLine();
        
        if (response2.equalsIgnoreCase("yes")){
            System.out.print("Which group do you want to check? (1/2): ");
            int groupNumber = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter the name you want to check: ");
            String checkName = scanner.nextLine();
            
            if (groupNumber - 1 < names.size()){
                boolean containsName = names.get(groupNumber - 1).contains(checkName);
                int index = names.get(groupNumber - 1).indexOf(checkName);
                System.out.println("Does group " + groupNumber + " contains the name " + checkName + "? " + containsName + " at the index:" + index);
            } else {
                System.out.println("Invalid Group number or index!");
            }
        }
        
        System.out.println("Groups:");
        for (int i = 0; i < names.size(); i++){
            System.out.print("Group " + (i + 1) + ": ");
            for (String name : names.get(i)){
                System.out.print(name + " ");
            }
            System.out.println();
        }
        
        System.out.print("\nDo you want to remove a name to group1 or 2? (yes/no): ");
        String response3 = scanner.nextLine();
        
        if (response3.equalsIgnoreCase("yes")){
            System.out.print("Which group do you want to remove a name from (enter group number 1 or 2): ");
            int groupNumber = scanner.nextInt();
            
            System.out.print("Enter the index that you want to remove: ");
            int index = scanner.nextInt();
            
            if (groupNumber - 1 < names.size() && index >= 0 && index < names.get(groupNumber - 1).size()){
                names.get(groupNumber - 1).remove(index);
                System.out.println("Succesfully remove!");
            } else {
                System.out.println("Invalid Group number or index!");
            }
        }
        
        System.out.println("Groups:");
        for (int i = 0; i < names.size(); i++){
            System.out.print("Group " + (i + 1) + ": ");
            for (String name : names.get(i)){
                System.out.print(name + " ");
            }
            System.out.println();
        }
        
        System.out.print("\nDo you want to set a name to group1 or 2? (yes/no): ");
        String response4 = scanner.nextLine();
        
        if (response4.equalsIgnoreCase("yes")){
            System.out.print("Which group do you want to remove a name from (enter group number 1 or 2): ");
            int groupNumber = scanner.nextInt();
            
            System.out.print("Enter the index that you want to set: ");
            int index = scanner.nextInt();
            
            if (groupNumber - 1 < names.size() && index >= 0 && index < names.get(groupNumber - 1).size()){
                System.out.print("Enter the new name ");
                String newName = scanner.nextLine();
                names.get(groupNumber - 1).set(index, newName);
            } else {
                System.out.println("Invalid Group number or index!");
            }
        }
        
        System.out.println("Groups:");
        for (int i = 0; i < names.size(); i++){
            System.out.print("Group " + (i + 1) + ": ");
            for (String name : names.get(i)){
                System.out.print(name + " ");
            }
            System.out.println();
        }
    }
}
