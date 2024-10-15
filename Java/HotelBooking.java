import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

class Room {
    int roomNumber;
    String customerName;
    Date startTime;
    Date endTime;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void bookRoom(String customerName, Date startTime, Date endTime) {
        this.customerName = customerName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void displayBooking() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
    }
}

class Floor {
    int floorNumber;
    ArrayList<Room> rooms;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.rooms = new ArrayList<>();

        // Initialize rooms for this floor
        for (int i = 1; i < 5; i++) {
            int roomNumber = floorNumber * 100 + i;
            rooms.add(new Room(roomNumber));
        }
    }

    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

public class HotelBooking_Project {
    private ArrayList<Floor> floors;
    private Scanner scanner;

    public HotelBooking_Project() {
        this.floors = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // Initialize floors
        for (int floor = 2; floor <= 6; floor++) {
            floors.add(new Floor(floor));
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Book Room");
            System.out.println("2. Display Booking");
            System.out.println("3. Display All Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    bookRoom();
                    break;
                case 2:
                    displayBooking();
                    break;
                case 3:
                    displayAllBookings();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void bookRoom() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Get the floor number from the room number
        int floorNumber = roomNumber / 100;

        Floor floor = getFloor(floorNumber);
        if (floor != null) {
            Room room = floor.getRoom(roomNumber);
            if (room != null) {
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();

                System.out.print("Enter start time (yyyy-MM-dd h:mm a): ");
                Date startTime = getDateFromInput();

                System.out.print("Enter end time (yyyy-MM-dd h:mm a): ");
                Date endTime = getDateFromInput();

                room.bookRoom(customerName, startTime, endTime);
                System.out.println("Room booked successfully!");
            } else {
                System.out.println("Room not found.");
            }
        } else {
            System.out.println("Floor not found.");
        }
    }

    private Date getDateFromInput() {
        String dateString = scanner.nextLine();
        try {
            return new SimpleDateFormat("yyyy-MM-dd h:mm a").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a valid date in the format yyyy-MM-dd h:mm a.");
            return null;
        }
    }

    private void displayBooking() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Get the floor number from the room number
        int floorNumber = roomNumber / 100;

        Floor floor = getFloor(floorNumber);
        if (floor != null) {
            Room room = floor.getRoom(roomNumber);
            if (room != null) {
                room.displayBooking();
            } else {
                System.out.println("Room not found.");
            }
        } else {
            System.out.println("Floor not found.");
        }
    }

    private void displayAllBookings() {
    int size = 10; // size of the box
    for (Floor floor : floors) {
        for (Room room : floor.rooms) {
            // Print top border of the box
            for (int i = 0; i < size; i++) {
                System.out.print("* ");
            }
            System.out.println();

            // Print room details inside the box
            System.out.println("* Room Number: " + room.roomNumber);
            System.out.println("* Customer Name: " + room.customerName);
            System.out.println("* Start Time: " + room.startTime);
            System.out.println("* End Time: " + room.endTime);

            // Print bottom border of the box
            for (int i = 0; i < size; i++) {
                System.out.print("* ");
            }
            System.out.println();
            System.out.println(); // Empty line for better readability
        }
    }
}

    private Floor getFloor(int floorNumber) {
        for (Floor floor : floors) {
            if (floor.floorNumber == floorNumber) {
                return floor;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HotelBooking_Project hotelBooking_Project = new HotelBooking_Project();
        hotelBooking_Project.run();
    }
}
