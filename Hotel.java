import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Scanner;

class Room {
    int Roomnumber;
    double price;
    boolean availability;

    Room(int Roomnumber, double price) {
        this.Roomnumber = Roomnumber;
        this.price = price;
        this.availability = true;
    }
}

public class Hotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Room> rooms = new HashMap<>();

        for (int i = 1; i < 11; i++) {
            Room room = new Room(i, 5000);
            rooms.put(i, room);
        }

        while (true) {
            System.out.println("----HOTEL ROOM MENU----");
            System.out.println("1. View room");
            System.out.println("2. Book room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.println("Enter the choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Room room : rooms.values()) {
                        System.out.println("Room number: " + room.Roomnumber +"Price: " + room.price +"Availability: " +(room.availability ? "Available" : "Booked"));
                    }
                    break;
                    
                case 2:
                    System.out.println("Enter the room number: ");
                    int Roomnumber = sc.nextInt();

                    if (!rooms.containsKey(Roomnumber)) {
                        System.out.println("Room does not exist");
                    }
                    else {
                        Room selectedRoom = rooms.get(Roomnumber);
                        if (!selectedRoom.availability) {
                            System.out.println("Room is already booked");
                        }
                        else {
                            System.out.println("Enter check-in date: Year-Month-Date");
                             String date = sc.next();
                              selectedRoom.availability = false;
                              System.out.println("Room booked");
                        }
                    }

                    break;


                case 3:
                     System.out.println("Enter the room number: ");
                    Roomnumber = sc.nextInt();

                    if (!rooms.containsKey(Roomnumber)) {
                        System.out.println("Room does not exist");
                    }
                     else {
                        Room room = rooms.get(Roomnumber);
                        if (room.availability) {
                            System.out.println("Room is not booked");
                        }
                         else {
                            System.out.println("Enter checkIn date: ");
                            String checkInDate = sc.next();

                            System.out.println("Enter checkout date: ");
                            String checkOutDate = sc.next();

                            LocalDate checkIn = LocalDate.parse(checkInDate);
                            LocalDate checkOut = LocalDate.parse(checkOutDate);

                            long days =
                                    ChronoUnit.DAYS.between(checkIn,checkOut);

                            double total = days * room.price;
                            System.out.print("Are you a regular customer? (true/false): ");

                            boolean regular = sc.nextBoolean();
                            double discount = 0;

                            if (regular) {
                                discount = total * 0.10;
                            }

                            double finalAmount = total - discount;

                            System.out.println("----BILL----");
                            System.out.println("Room Number: " + Roomnumber);
                            System.out.println("Days: " + days);
                            System.out.println("Room Charge: ₹" + total);
                            System.out.println("Discount: " + discount);
                            System.out.println("Final amount: " + finalAmount);

                            room.availability = true;

                            System.out.println("Checkout successful");
                        }
                    }

                    break;


                case 4:
                    System.out.println("Thank you!");
                    return;
                    
                    default:
                     System.out.println("Invalid choice");
                     break;
            }
        }
    }
}