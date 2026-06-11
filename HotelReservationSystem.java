import java.util.Scanner;

class Room {
    int roomNumber;
    String roomType;
    int price;
    boolean booked;
    String customerName;

    Room(int roomNumber, String roomType, int price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.booked = false;
        this.customerName = "";
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room[] rooms = {
                new Room(101, "Standard", 1000),
                new Room(102, "Deluxe", 2000),
                new Room(103, "Suite", 3000)
        };

        int choice;

        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room room : rooms) {
                        System.out.println(
                                room.roomNumber + " | "
                                        + room.roomType + " | Rs."
                                        + room.price + " | "
                                        + (room.booked ? "Booked" : "Available"));
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (Room room : rooms) {
                        if (room.roomNumber == roomNo) {
                            found = true;

                            if (!room.booked) {

                                System.out.print("Enter Customer Name: ");
                                String name = sc.nextLine();

                                System.out.println("\nRoom Price = Rs." + room.price);

                                System.out.println("Payment Method:");
                                System.out.println("1. UPI");
                                System.out.println("2. Card");
                                System.out.println("3. Cash");

                                System.out.print("Select Option: ");
                                int payment = sc.nextInt();

                                System.out.println("Payment Successful!");

                                room.booked = true;
                                room.customerName = name;

                                System.out.println("Room Booked Successfully.");
                            } else {
                                System.out.println("Room Already Booked.");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Room Number.");
                    }

                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();

                    for (Room room : rooms) {
                        if (room.roomNumber == cancelRoom) {

                            if (room.booked) {
                                room.booked = false;
                                room.customerName = "";

                                System.out.println("Booking Cancelled Successfully.");
                            } else {
                                System.out.println("Room is Not Booked.");
                            }
                        }
                    }

                    break;

                case 4:
                    System.out.println("\nBooking Details:");

                    for (Room room : rooms) {

                        if (room.booked) {
                            System.out.println("------------------------");
                            System.out.println("Customer Name : " + room.customerName);
                            System.out.println("Room Number   : " + room.roomNumber);
                            System.out.println("Room Type     : " + room.roomType);
                            System.out.println("Amount Paid   : Rs." + room.price);
                        }
                    }

                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}