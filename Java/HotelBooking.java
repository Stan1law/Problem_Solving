import java.util.Timer;
import java.util.TimerTask;
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
        for (int i = 1; i <= 5; i++) {
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
    private Timer timer; // Timer for periodic checks

    public HotelBooking_Project() {
        this.floors = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.timer = new Timer(); // Initialize the timer

        // Initialize floors
        for (int floor = 2; floor <= 6; floor++) {
            floors.add(new Floor(floor));
        }

        // Schedule the real-time status checker (runs every minute)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkRoomStatuses(); // Update room statuses based on the current time
            }
        }, 0, 60000); // 60000 milliseconds = 1 minute
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
                    System.out.println("Exiting the system...");
                    timer.cancel(); // Stop the timer when exiting
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void checkRoomStatuses() {
        Date currentTime = new Date(); // Get current system time

        for (Floor floor : floors) {
            for (Room room : floor.rooms) {
                if (room.endTime != null && currentTime.after(room.endTime)) {
                    // If current time is past the end time, mark room as empty
                    room.customerName = null;
                    room.startTime = null;
                    room.endTime = null;
                }
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

            Date endTime;
            while (true) {
                System.out.print("Enter end time (yyyy-MM-dd h:mm a): ");
                endTime = getDateFromInput();
                if (endTime.after(startTime)) {
                    break;
                } else {
                    System.out.println("End time cannot be before start time. Please enter a valid end time.");
                }
            }

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
    while (true) {
        String dateString = scanner.nextLine();
        try {
            return new SimpleDateFormat("yyyy-MM-dd h:mm a").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a valid date in the format (yyyy-MM-dd h:mm a): ");
        }
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
    int boxWidth = 15; // width of each room box

    for (Floor floor : floors) {
        System.out.println("Floor " + floor.floorNumber); // Print the floor number

        // First line: Top border for each room
        for (Room room : floor.rooms) {
            for (int i = 0; i < boxWidth; i++) {
                System.out.print("*");
            }
            System.out.print("     "); // Space between rooms
        }
        System.out.println();

        // Second line: Room number inside the box
        for (Room room : floor.rooms) {
            String roomInfo = "* Room " + room.roomNumber;
            System.out.print(roomInfo);
            for (int i = roomInfo.length(); i < boxWidth; i++) {
                System.out.print(" ");
            }
            System.out.print("     "); // Space between rooms
        }
        System.out.println();

        // Third line: Occupied status inside the box
        for (Room room : floor.rooms) {
            String occupiedInfo = "* " + (room.customerName != null ? "Occupied" : "Empty");
            System.out.print(occupiedInfo);
            for (int i = occupiedInfo.length(); i < boxWidth; i++) {
                System.out.print(" ");
            }
            System.out.print("     "); // Space between rooms
        }
        System.out.println();

        // Fourth line: End time inside the box
        for (Room room : floor.rooms) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            String endTimeInfo = "* End:" + (room.customerName != null ? sdf.format(room.endTime) : "");
            System.out.print(endTimeInfo);
            for (int i = endTimeInfo.length(); i < boxWidth; i++) {
                System.out.print(" ");
            }
            System.out.print("     "); // Space between rooms
        }
        System.out.println();

        // Fifth line: Bottom border for each room
        for (Room room : floor.rooms) {
            for (int i = 0; i < boxWidth; i++) {
                System.out.print("*");
            }
            System.out.print("     "); // Space between rooms
        }
        System.out.println();
        System.out.println(); // Extra line to separate floors
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
