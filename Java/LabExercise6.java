import java.util.Scanner;
import java.util.ArrayList;
public class LabExercise6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
//        // One-dimensional array
//        String[] names = {"Ana", "Jose", "Juan"};
//        System.out.print("Enter name: ");
//        String newName = sc.nextLine();
//        
//        // Add new name to the array (1D Array)
//        String[] updatedNames = new String[names.length + 1];
//        for (int i = 0; i < names.length; i++) {
//            updatedNames[i] = names[i];
//        }
//        updatedNames[updatedNames.length - 1] = newName;
//
//        // Print all elements
//        System.out.println("Here are the names:");
//        for (String name : updatedNames) {
//            System.out.print(name + " ");
//        }
//        System.out.println();
//
//        // Search for an index
//        System.out.print("Enter index number: ");
//        int index = sc.nextInt();
//        if (index >= 0 && index < updatedNames.length) {
//            System.out.println("Index " + index + " belongs to " + updatedNames[index] + ".");
//        } else {
//            System.out.println("Invalid index.");
//        }
//        
//        // Multidimensional array (for demonstration)
//        String[][] multiNames = {
//            {"Ana", "Jose"},
//            {"Juan", newName}
//        };
//
//        // Print multidimensional array
//        System.out.println("Here are the names from the multidimensional array:");
//        for (String[] row : multiNames) {
//            for (String name : row) {
//                System.out.print(name + " ");
//            }
//            System.out.println();
//        }
        
        ArrayList<String> names = new ArrayList<>();
        names.add("Ana");
        names.add("Jose");
        names.add("Juan");

        // Add a new element
        System.out.print("Enter name to add: ");
        String newName = sc.nextLine();
        names.add(newName);

        // Print all elements
        System.out.println("Here are the names:");
        System.out.println(names);

        // Remove an element by index
        System.out.print("Enter index number to remove: ");
        int indexToRemove = sc.nextInt();
        if (indexToRemove >= 0 && indexToRemove < names.size()) {
            names.remove(indexToRemove);
        } else {
            System.out.println("Invalid index.");
        }
        System.out.println("Here are the names:");
        System.out.println(names);

        // Replace (set) an element
        System.out.print("Enter index number to replace (set): ");
        int indexToSet = sc.nextInt();
        sc.nextLine();  // Consume newline left-over
        if (indexToSet >= 0 && indexToSet < names.size()) {
            System.out.print("Enter new name: ");
            String nameToSet = sc.nextLine();
            names.set(indexToSet, nameToSet);
        } else {
            System.out.println("Invalid index.");
        }
        System.out.println("Here are the names:");
        System.out.println(names);

        // Search for a name (contains/indexOf)
        System.out.print("Enter name to search (contains/indexOf): ");
        String nameToSearch = sc.nextLine();
        if (names.contains(nameToSearch)) {
            System.out.println(nameToSearch + " is in the list with index " + names.indexOf(nameToSearch) + ".");
        } else {
            System.out.println(nameToSearch + " is not in the list.");
        }

        // Get element by index
        System.out.print("Enter index number: ");
        int indexToGet = sc.nextInt();
        if (indexToGet >= 0 && indexToGet < names.size()) {
            System.out.println("Index " + indexToGet + " belongs to " + names.get(indexToGet) + ".");
        } else {
            System.out.println("Invalid index.");
        }

        // Clear the list
        System.out.print("Clear the list? Y/N: ");
        char clearList = sc.next().charAt(0);
        if (clearList == 'Y' || clearList == 'y') {
            names.clear();
        }
        System.out.println("The list is now empty.");
        System.out.println("The size of the list is " + names.size() + ".");
    
    }
}
