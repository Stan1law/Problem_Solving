import java.util.Scanner;
import java.util.ArrayList;
public class practice5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        
        while (true){
            System.out.println("1. Add a new employee");
            System.out.println("2. Display all employees");
            System.out.println("3. Display the highest-paid employee");
            System.out.println("4. Calculate the average salary of all employees");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice){
                case 1:
                    addNewEmployee(scanner, employees);
                    break;
                case 2:
                    displayAllEmployees(employees);
                    break;
                case 3:
                    displayHighestPayingEmployee(employees);
                    break;
                case 4:
                    calculateAverageSalary(employees);
                    break;
                case 5:
                    Exit();
                    System.exit(0);
            }
        }
    }
    
    public static void addNewEmployee(Scanner scanner, ArrayList<Employee> employees) {
    System.out.println("Enter employee ID: ");
    int employeeID = scanner.nextInt();
    scanner.nextLine();  // Consume the newline after the ID input

    System.out.println("Enter employee name: ");
    String employeeName = scanner.nextLine();

    System.out.println("Enter employee age: ");
    int employeeAge = scanner.nextInt();
    scanner.nextLine();  // Consume the newline after the age input

    System.out.println("Enter employee department: ");
    String employeeDepartment = scanner.nextLine();

    System.out.println("Enter employee salary: ");
    double employeeSalary = scanner.nextDouble();
    
    // Create and add the new employee to the ArrayList
    Employee employee = new Employee(employeeID, employeeName, employeeAge, employeeDepartment, employeeSalary);
    employees.add(employee);  // Add the employee to the ArrayList
    
    System.out.println("Employee added successfully!");
}
    
    public static void displayAllEmployees(ArrayList<Employee> employees) {
    if (employees.isEmpty()) {
        System.out.println("No employees to display.");
        return;
    }

    System.out.println("Employee List:");
    for (Employee employee : employees) {
        System.out.println("ID: " + employee.getID());
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("-------------------------");
    }
}   
    
    public static void displayHighestPayingEmployee(ArrayList<Employee> employees) {
    if (employees.isEmpty()) {
        System.out.println("No employees to display.");
        return;
    }

    Employee highestPayingEmployee = employees.get(0); // Assume the first employee has the highest salary

    for (Employee employee : employees) {
        if (employee.getSalary() > highestPayingEmployee.getSalary()) {
            highestPayingEmployee = employee; // Update if a higher salary is found
        }
    }

    // Display the highest paying employee
    System.out.println("Highest Paying Employee:");
    System.out.println("ID: " + highestPayingEmployee.getID());
    System.out.println("Name: " + highestPayingEmployee.getName());
    System.out.println("Age: " + highestPayingEmployee.getAge());
    System.out.println("Department: " + highestPayingEmployee.getDepartment());
    System.out.println("Salary: " + highestPayingEmployee.getSalary());
}

    
    public static double calculateAverageSalary(ArrayList<Employee> employees) {
    if (employees.isEmpty()) {
        System.out.println("No employees available to calculate average salary.");
        return 0;
    }

    double totalSalary = 0;

    // Loop through the ArrayList to sum all salaries
    for (Employee employee : employees) {
        totalSalary += employee.getSalary();
    }

    // Calculate the average salary
    double averageSalary = totalSalary / employees.size();
    
    return averageSalary;
}

    
    public static void Exit(){
        System.out.println("Exiting...");
        System.exit(0);
    }
}

class Employee{
    public int employeeID;
    public String employeeName;
    public int employeeAge;
    public String employeeDepartment;
    public double employeeSalary;
    
    public Employee(int employeeID, String employeeName, int employeeAge, String employeeDepartment, double employeeSalary){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }
    
    public int getID(){
        return employeeID;
    }
    
    public String getName(){
        return employeeName;
    }
    
    public int getAge(){
        return employeeAge;
    }
    
    public String getDepartment(){
        return employeeDepartment;
    }
    
    public double getSalary(){
        return employeeSalary;
    }
}
