import java.util.Scanner;

public class HomeActivity {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        //Input rows and columns
        int rows = 0, cols = 0;
        while (rows <= 0){
            System.out.print("Enter rows: ");
            if (scanner.hasNextInt()){
                rows = scanner.nextInt();
                if (rows <= 0){
                    System.out.println("Rows must be a positive number!!!");
                }
            } else{
                System.out.println("Invalid Input. Please enter a positive number.");
                scanner.next();//clear invalid input
            }
        }
        
        while (cols <= 0){
            System.out.print("Enter columns");
            if (scanner.hasNextInt()){
                cols = scanner.nextInt();
                if (cols <= 0){
                    System.out.println("Cols must be a positive number!!!");
                }
            } else {
                System.out.println("Invalid Input. Please enter a positive number.");
                scanner.next();//clear invalid input
            }
        }
        // Initialize and fill the array
        int[][] array = new int[rows][cols];
        System.out.println("Enter Elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear invalid input
                }
                array[i][j] = scanner.nextInt();
            }
        }

        // Display the array
        System.out.println("\nArray Elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        // Find element
        System.out.print("\nFind: ");
        int find = scanner.nextInt();
        boolean found = false;
        int findRow = -1, findCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == find) {
                    found = true;
                    findRow = i;
                    findCol = j;
                    break;
                }
            }
            if (found) break;
        }

        if (found) {
            System.out.printf("%d is at row %d, column %d\n", find, findRow, findCol);
        } else {
            System.out.println(find + " not found in the array.");
        }

        // Find minimum, maximum, and sum
        int min = array[0][0];
        int max = array[0][0];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] < min) min = array[i][j];
                if (array[i][j] > max) max = array[i][j];
                sum += array[i][j];
            }
        }

        System.out.println("\nMinimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Sum: " + sum);

        scanner.close();
    }
}
