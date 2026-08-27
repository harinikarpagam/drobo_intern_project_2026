import java.util.*;
enum RoomType {
    NON_AC,AC,LUXURY,SUITE
}

class Room {
    int Roomnumber;
    double price;
    boolean availability;
    RoomType roomType;

    Room(int Roomnumber, double price, RoomType roomType) {
        this.Roomnumber = Roomnumber;
        this.price = price;
        this.roomType = roomType;
        this.availability = true;
    }
}

class Food {
    int foodId;
    String foodName;
    double price;

    Food(int foodId, String foodName, double price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
    }
}

interface Payment {
    void makePayment(double amount);
}

class CashPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Cash payment received: ₹" + amount);
    }
}

class UPIPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("UPI payment successful: ₹" + amount);
    }
}

class CardPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Card payment successful: ₹" + amount);
    }
}

public class Hotel {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         HashMap<Integer, Room> rooms = new HashMap<>();
         for (int i = 1; i <= 3; i++) {
             Room room = new Room(i, 2000, RoomType.NON_AC);
             rooms.put(i, room);
        }

        for (int i = 4; i <= 6; i++) {
            Room room = new Room(i, 3500, RoomType.AC);
            rooms.put(i, room);
        }

        for (int i = 7; i <= 8; i++) {
            Room room = new Room(i, 6000, RoomType.LUXURY);
            rooms.put(i, room);
        }

        for (int i = 9; i <= 10; i++) {
            Room room = new Room(i, 8000, RoomType.SUITE);
            rooms.put(i, room);
        }

        HashMap<Integer, Food> foodMenu = new HashMap<>();

        foodMenu.put(1, new Food(1, "Biriyani", 250));
        foodMenu.put(2, new Food(2, "Fried Rice", 180));
        foodMenu.put(3, new Food(3, "Pizza", 300));
        foodMenu.put(4, new Food(4, "Burger", 150));
        foodMenu.put(5, new Food(5, "Coffee", 80));
        foodMenu.put(6, new Food(6, "Juice", 100));

        while (true) {

            System.out.println("---- HOTEL ROOM MENU ----");
            System.out.println("1. View rooms");
            System.out.println("2. Book room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            System.out.println("Enter the choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Room room : rooms.values()) {
                        System.out.println("Room number: " + room.Roomnumber+ " | Type: " + room.roomType+ " | Price: ₹" + room.price+ " | Availability: "+ (room.availability ? "Available" : "Booked"));
                    }
                    break;

                case 2:
                    System.out.println("Choose room type:");
                    System.out.println("1. Non-AC - ₹2000");
                    System.out.println("2. AC - ₹3500");
                    System.out.println("3. Luxury - ₹6000");
                    System.out.println("4. Suite - ₹8000");

                    int typeChoice = sc.nextInt();
                    RoomType selectedType;

                    if (typeChoice == 1) {
                        selectedType = RoomType.NON_AC;
                    }
                    else if (typeChoice == 2) {
                        selectedType = RoomType.AC;
                    }
                    else if (typeChoice == 3) {
                        selectedType = RoomType.LUXURY;
                    }
                    else if (typeChoice == 4) {
                        selectedType = RoomType.SUITE;
                    }
                    else {
                        System.out.println("Invalid room type");
                        break;
                    }

                    System.out.println("Available rooms:");
                    boolean found = false;
                    for (Room room : rooms.values()) {
                        if (room.roomType == selectedType &&
                                room.availability) {
                                    System.out.println("Room " + room.Roomnumber+ " - ₹" + room.price);
                                found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No rooms available for this type");
                        break;
                    }

                    System.out.println("Enter the room number:");
                    int Roomnumber = sc.nextInt();

                    if (!rooms.containsKey(Roomnumber)) {
                        System.out.println("Room does not exist");
                    }
                    else {
                        Room selectedRoom = rooms.get(Roomnumber);
                        if (!selectedRoom.availability) {
                            System.out.println("Room is already booked");
                        }
                        else if (selectedRoom.roomType != selectedType) {
                            System.out.println("Selected room does not match the chosen room type");
                        }
                        else {
                            System.out.println("Enter check-in date (YYYY-MM-DD):");
                            String date = sc.next();

                            LocalDate checkIn = LocalDate.parse(date);
                            selectedRoom.availability = false;
                            System.out.println("Room booked successfully!");
                            System.out.println("Check-in date: " + checkIn);
                        }
                    }

                    break;
                case 3:
                    System.out.println("Enter the room number:");
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
                            System.out.println("Enter check-in date (YYYY-MM-DD):");
                            String checkInDate = sc.next();

                            System.out.println("Enter checkout date (YYYY-MM-DD):");
                            String checkOutDate = sc.next();
                            LocalDate checkIn = LocalDate.parse(checkInDate);
                            LocalDate checkOut = LocalDate.parse(checkOutDate);
                            long days = ChronoUnit.DAYS.between(checkIn,checkOut);

                            if (days <= 0) {
                                System.out.println("Checkout date must be after check-in date");
                                break;
                            }
                            double total = days * room.price;
                            System.out.print("Are you a regular customer? (true/false): ");
                            boolean regular = sc.nextBoolean();
                            double discount = 0;

                            if (regular) {
                                discount = total * 0.10;
                            }
                            else if (days >= 6) {
                                discount = total * 0.15;
                            }

                            double roomAmount = total - discount;
                            ArrayList<Food> orderedFood = new ArrayList<>();
                            double foodTotal = 0;

                            System.out.println("\nDo you want to order food? (true/false)");
                            boolean orderFood = sc.nextBoolean();

                            while (orderFood) {
                                System.out.println("\n----- FOOD MENU -----");
                                for (Food food : foodMenu.values()) {
                                    System.out.println(food.foodId+ ". "+ food.foodName+ " - ₹"+ food.price);
                                }
                                System.out.println("Enter food number:");
                                int foodChoice = sc.nextInt();

                                if (!foodMenu.containsKey(foodChoice)) {
                                    System.out.println("Food item does not exist");
                                    continue;
                                }

                                Food selectedFood = foodMenu.get(foodChoice);
                                System.out.println("Enter quantity:");

                                int quantity = sc.nextInt();

                                if (quantity <= 0) {
                                    System.out.println("Invalid quantity");
                                    continue;
                                }

                                for (int i = 0; i < quantity; i++) {
                                    orderedFood.add(selectedFood);
                                }

                                foodTotal = foodTotal+ selectedFood.price * quantity;

                                System.out.println(selectedFood.foodName+ " added successfully");
                                System.out.println("Do you want to order more food? (true/false)");
                                orderFood = sc.nextBoolean();
                            }

                            double finalAmount = roomAmount + foodTotal;
                            System.out.println("\n------ BILL ------");
                            System.out.println("Room Number: " + Roomnumber);
                            System.out.println("Room Type: " + room.roomType);
                            System.out.println("Days: " + days);
                            System.out.println("Room Charge: ₹" + total);
                            System.out.println("Discount: ₹" + discount);
                            System.out.println("Food Charge: ₹" + foodTotal);
                            System.out.println("Final Amount: ₹" + finalAmount);
                            
                            
                            System.out.println("Choose payment method:");
                            System.out.println("1. Cash");
                            System.out.println("2. UPI");
                            System.out.println("3. Card");

                            int paymentChoice = sc.nextInt();
                            Payment payment;
                            if (paymentChoice == 1) {
                                payment = new CashPayment();
                            }
                            else if (paymentChoice == 2) {
                                payment = new UPIPayment();
                            }
                            else if (paymentChoice == 3) {
                                payment = new CardPayment();
                            }
                            else {
                                System.out.println("Invalid payment method");
                                break;
                            }
                            payment.makePayment(finalAmount);
                            room.availability = true;
                            System.out.println("Checkout successful!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}