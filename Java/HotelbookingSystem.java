import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

class Booking {
    String customerName;
    String roomNumber;
    LocalDateTime startTime;
    LocalDateTime endTime;

    // Constructor - initializes a new booking
    public Booking(String customerName, String roomNumber, LocalDateTime startTime, int hours) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(hours);
    }

    // Display booking information (start and end times)
    public void displayBooking() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
    System.out.println("Customer: " + customerName);
    System.out.println("Room: " + roomNumber);
    System.out.println("Start Time: " + startTime.format(formatter));
    System.out.println("End Time: " + endTime.format(formatter));
}

    // Method to extend the end time of the booking
    public void extendBooking(int additionalHours) {
        this.endTime = this.endTime.plusHours(additionalHours);
        System.out.println("Booking extended! New End Time: " + endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}

public class HotelBookingManager {
    private static final ArrayList<String> rooms = new ArrayList<>();  // List of available rooms
    private static final ArrayList<Booking> bookings = new ArrayList<>(); // List of all bookings

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initialize available rooms
        initializeRooms();
        
        // Instructions for new staff
        while (true) {
            System.out.println("\nHotel Booking System Menu:");
            System.out.println("1. Book a room");
            System.out.println("2. Display booking by room number");
            System.out.println("3. Display all bookings");
            System.out.println("4. Delete a booking");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookRoom(scanner);
                    break;
                case 2:
                    displayBookingByRoom(scanner);
                    break;
                case 3:
                    displayAllBookings();
                    break;
                case 4:
                    deleteBooking(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
    
    // Method to cancel a booking
private static void deleteBooking(Scanner scanner) {
    System.out.print("Enter the room number to cancel the booking: ");
    String roomNumber = scanner.next();

    boolean found = false;
    for (int i = 0; i < bookings.size(); i++) {
        if (bookings.get(i).roomNumber.equals(roomNumber)) {
            bookings.remove(i);
            System.out.println("Booking for room " + roomNumber + " has been cancelled.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("No booking found for room " + roomNumber);
    }
}


    // Method to book a room
    private static void bookRoom(Scanner scanner) {
        System.out.println("Enter the customer's name: ");
        scanner.nextLine();  // Consume newline left-over
        String customerName = scanner.nextLine();
        displayAvailableRooms();

        System.out.print("Enter the room number: ");
        String roomNumber = scanner.next();

        // Check if the room is available by iterating through bookings
        for (Booking booking : bookings) {
            if (booking.roomNumber.equals(roomNumber)) {
                System.out.println("Sorry, room " + roomNumber + " is already booked.");
                return;
            }
        }

        System.out.print("Enter how many hours the customer will stay: ");
        int hours = scanner.nextInt();

        LocalDateTime startTime = LocalDateTime.now();
        Booking newBooking = new Booking(customerName, roomNumber, startTime, hours);

        // Save the booking to the list
        bookings.add(newBooking);
        newBooking.displayBooking();
    }

    // Method to display a booking by room number
    private static void displayBookingByRoom(Scanner scanner) {
        System.out.print("Enter the room number to display: ");
        String roomNumber = scanner.next();

        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.roomNumber.equals(roomNumber)) {
                booking.displayBooking();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found for room " + roomNumber);
        }
    }

    // Method to display all bookings
    private static void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No current bookings available.");
        } else {
            for (Booking booking : bookings) {
                booking.displayBooking();
                System.out.println("-----------------------");
            }
        }
    }

    // Initialize available rooms
    private static void initializeRooms() {
    for (int i = 201; i <= 210; i++) {
        rooms.add(String.valueOf(i));  // Second floor rooms 201-210
    }
    for (int i = 301; i <= 310; i++) {
        rooms.add(String.valueOf(i));  // Third floor rooms 301-310
    }
    for (int i = 401; i <= 410; i++) {
        rooms.add(String.valueOf(i));  // Fourth floor rooms 401-410
    }
    for (int i = 501; i <= 510; i++) {
        rooms.add(String.valueOf(i));  // Fifth floor rooms 501-510
    }
}

    
    // Display available rooms in a grid format
private static void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        
        // Display rooms in the required format
        for (int i = 0; i < 10; i++) {
            String room201 = rooms.get(i);  // Second floor
            String room301 = rooms.get(i + 10);  // Third floor
            String room401 = rooms.get(i + 20);  // Fourth floor
            String room501 = rooms.get(i + 30);  // Fifth floor
            
            // Check availability for each room
            boolean available201 = isRoomAvailable(room201);
            boolean available301 = isRoomAvailable(room301);
            boolean available401 = isRoomAvailable(room401);
            boolean available501 = isRoomAvailable(room501);
            
            // Display rooms in one line with tabs for alignment
            System.out.printf("%-12s %-12s %-12s %-12s\n",
                available201 ? "Room " + room201 : "",
                available301 ? "Room " + room301 : "",
                available401 ? "Room " + room401 : "",
                available501 ? "Room " + room501 : "");
        }
        System.out.println();  // New line at the end
    }

    // Check if a room is available
    private static boolean isRoomAvailable(String room) {
        for (Booking booking : bookings) {
            if (booking.roomNumber.equals(room)) {
                return false;
            }
        }
        return true;
    }
}
