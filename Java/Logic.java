Check for empty input: You can check if the user has entered any input for each field. If the input is empty, you can prompt the user to enter a value.
if (studentNumber.isEmpty()) {
    System.out.println("Please enter a student number.");
    studentNumber = scanner.nextLine();
}

Check for valid age: You can check if the age entered by the user is within a valid range (e.g., between 18 and 100).
if (studentAge < 18 || studentAge > 100) {
    System.out.println("Please enter a valid age (between 18 and 100).");
    studentAge = Integer.parseInt(scanner.nextLine());
}

Check for valid gender: You can check if the gender entered by the user is either "M" or "F".
if (!studentGender.equalsIgnoreCase("M") && !studentGender.equalsIgnoreCase("F")) {
    System.out.println("Please enter a valid gender (M or F).");
    studentGender = scanner.nextLine();
}

Check for duplicate student numbers: You can check if a student with the same number already exists in the studentsRecord map.
if (studentsRecord.containsKey(studentNumber)) {
    System.out.println("A student with this number already exists.");
    // You can either prompt the user to enter a different number or update the existing student's record.
}

You can add a validation to check if the student number matches the format "YYYY-XXXXXXXX", where "YYYY" is a 4-digit year and "XXXXXXXX" is an 8-digit number.
private static boolean isValidStudentNumber(String studentNumber) {
    String pattern = "^\\d{4}-\\d{8}$";
    return studentNumber.matches(pattern);
}
In this code, ^ matches the start of the string, \\d{4} matches exactly 4 digits, - matches the hyphen, \\d{8} matches exactly 8 digits, and $ matches the end of the string.

if (!isValidStudentNumber(studentNumber)) {
    System.out.println("Please enter a valid student number in the format YYYY-XXXXXXXX.");
    studentNumber = scanner.nextLine();
}

Here's a breakdown of the regular expression used:

^ matches the start of the string
\\d{4} matches exactly 4 digits (the year)
- matches the hyphen
\\d{8} matches exactly 8 digits (the student ID)
$ matches the end of the string
This regular expression will match strings like "2024-10799671", but not strings like "2024-107996" or "2024-107996711".

for (StudentRecord studentRecord : studentsRecord.values()) {
    // ...
}
studentsRecord is a Map (a data structure that stores key-value pairs).
values() is a method of the Map interface that returns a Collection of all the values in the map. In this case, the values are StudentRecord objects.
The for loop is using a syntax called "enhanced for loop" or "foreach loop". It's a shorthand way to iterate over a collection of objects.
Here's how it works:

The for loop iterates over the Collection of StudentRecord objects returned by studentsRecord.values().
On each iteration, the loop assigns the current StudentRecord object to the variable studentRecord.
The loop body is executed for each StudentRecord object in the collection.
The :values() part is where the magic happens. It's called the "expression" part of the foreach loop. It's evaluated once, before the loop starts, and it returns a Collection of objects. The loop then iterates over this collection.

In this specific case, studentsRecord.values() returns a Collection of StudentRecord objects, which are the values stored in the studentsRecord map. The loop then iterates over these objects, assigning each one to the studentRecord variable.

Here's an equivalent way to write the loop using a traditional for loop:
Collection<StudentRecord> studentRecords = studentsRecord.values();
for (int i = 0; i < studentRecords.size(); i++) {
    StudentRecord studentRecord = studentRecords.get(i);
    // ...
}
Reference the PracticalJava File

Let's break down the logic behind the array in the code.

Array Initialization
String[] tasks = new String[0];
Here, we create a new array of strings called tasks with an initial size of 0. This means that the array has no elements yet.

Array Expansion
tasks = Arrays.copyOf(tasks, tasks.length + 1);

When the user chooses to add a task, we use the Arrays.copyOf method to create a new array with a size that is one more than the current size of the tasks array. This effectively "expands" the array to accommodate the new task.

Adding an Element to the Array
tasks[tasks.length - 1] = scanner.nextLine();
When the user chooses to add a task, we use the Arrays.copyOf method to create a new array with a size that is one more than the current size of the tasks array. This effectively "expands" the array to accommodate the new task.

Adding an Element to the Array
tasks[tasks.length - 1] = scanner.nextLine();
After expanding the array, we add the new task to the last index of the array using the tasks.length - 1 syntax. This is because arrays in Java are 0-indexed, meaning that the first element is at index 0, and the last element is at index length - 1.  

Loop Example
for (int i = 0; i <= inputString.length() - substring.length(); i++) {
    if (inputString.substring(i, i + substring.length()).equals(substring)) {
        found = true;
        break;
    }
}
Loop Initialization
int i = 0;
This line initializes the loop counter i to 0. The loop will start by checking the first character in the input string.
Loop Condition
This line specifies the condition for the loop to continue. The loop will continue as long as the current index i is less than or equal to the length of the input string minus the length of the substring. This ensures that we don't go out of bounds when checking for the substring.
Loop Increment
i++;
This line increments the loop counter i by 1 after each iteration of the loop. This moves the loop to the next character in the input string.
Checking for the Substring
if (inputString.substring(i, i + substring.length()).equals(substring)) {
    found = true;
    break;
}
This line checks if the substring starting at index i and ending at i + substring.length() is equal to the target substring. If it is, we set the found variable to true and break out of the loop.

Example Walkthrough

Let's say the input string is "I love programming in Java" and the target substring is "java". Here's how the loop would iterate through the characters:

i = 0, inputString.substring(0, 4) = "I lo" (not equal to "java"), found = false
i = 1, inputString.substring(1, 5) = "love" (not equal to "java"), found = false
i = 2, inputString.substring(2, 6) = "ove p" (not equal to "java"), found = false
i = 3, inputString.substring(3, 7) = "ve pr" (not equal to "java"), found = false
i = 4, inputString.substring(4, 8) = "e pro" (not equal to "java"), found = false
i = 5, inputString.substring(5, 9) = "progr" (not equal to "java"), found = false
i = 6, inputString.substring(6, 10) = "ogram" (not equal to "java"), found = false
i = 7, inputString.substring(7, 11) = "gramm" (not equal to "java"), found = false
i = 8, inputString.substring(8, 12) = "rammi" (not equal to "java"), found = false
i = 9, inputString.substring(9, 13) = "ammin" (not equal to "java"), found = false
i = 10, inputString.substring(10, 14) = "mmin g" (not equal to "java"), found = false
i = 11, inputString.substring(11, 15) = "ming J" (not equal to "java"), found = false
i = 12, inputString.substring(12, 16) = "ing Ja" (not equal to "java"), found = false
i = 13, inputString.substring(13, 17) = "ng Jav" (not equal to "java"), found = false
i = 14, inputString.substring(14, 18) = "g Java" (equal to "java"), found = true
After the loop finishes, the found variable is set to true, indicating that the target substring was found in

Shapes
Triagle
int rows = 5; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
Inverted Triagle
 int rows = 5; // number of rows in the triangle
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
Square
int size = 5; // size of the square
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
Rectangle
int width = 5; // width of the rectangle
        int height = 3; // height of the rectangle
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
Diamond
int size = 5; // size of the diamond
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < size - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
Hollow Square
int size = 5; // size of the square
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
Hollow Rectangle
int width = 5; // width of the rectangle
        int height = 3; // height of the rectangle
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

for display box room
private void displayAllBookings() {
    int boxWidth = 12; // width of each room box

    for (Floor floor : floors) {
        System.out.println("Floor " + floor.floorNumber); // Print the floor number

        // First line: Top border for each room
        for (Room room : floor.rooms) {
            for (int i = 0; i < boxWidth; i++) {
                System.out.print("*");
            }
            System.out.print("  "); // Space between rooms
        }
        System.out.println();

        // Second line: Room number inside the box
        for (Room room : floor.rooms) {
            String roomInfo = "* Room " + room.roomNumber;
            System.out.print(roomInfo);
            for (int i = roomInfo.length(); i < boxWidth; i++) {
                System.out.print(" ");
            }
            System.out.print("  "); // Space between rooms
        }
        System.out.println();

        // Third line: Customer Name inside the box
        for (Room room : floor.rooms) {
            String customerInfo = "* " + (room.customerName != null ? room.customerName : "Empty");
            System.out.print(customerInfo);
            for (int i = customerInfo.length(); i < boxWidth; i++) {
                System.out.print(" ");
            }
            System.out.print("  "); // Space between rooms
        }
        System.out.println();

        // Fourth line: Bottom border for each room
        for (Room room : floor.rooms) {
            for (int i = 0; i < boxWidth; i++) {
                System.out.print("*");
            }
            System.out.print("  "); // Space between rooms
        }
        System.out.println();
        System.out.println(); // Extra line to separate floors
    }
}

