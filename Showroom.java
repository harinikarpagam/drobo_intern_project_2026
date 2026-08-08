import java.util.Scanner;

class Showroom {
    public static void main(String args[])
    {
        System.out.println("Welcome to the Showroom!!!!");
        System.out.println("What type of vehicle are you looking for???");
        System.out.println("1. Two wheelers");
        System.out.println("2. Three wheelers");
        System.out.println("3. Four wheelers");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int vehicle = sc.nextInt();

        switch (vehicle) {
            case 1:
                System.out.println("Two wheeler");
                System.out.println("1. Scooter");
                System.out.println("2. Trendy Bike");
                System.out.println("3. Family bikes");
                
                System.out.println("Enter the model :");
                int twochoice = sc.nextInt();
                switch (twochoice) {
                    case 1:
                        System.out.println("1. Scooty peps");
                        System.out.println("2. Scoooty streak");
                        System.out.println("3. Tvs Jupiter");
                        System.out.println("4. Electric scooter");

                        int scooter = sc.nextInt();
                        switch(scooter){
                            case 1:
                                System.out.println("Congrats! Scooty peps will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! Scooty streak will be delivered soon");
                                break;
                            case 3:
                                System.out.println("Congrats! Tvs Jupiter will be delivered soon");
                                break;
                            case 4:
                                System.out.println("Congrats! Electric scooter will be delivered soon");
                                break;
                            default:
                                System.out.println("Nil");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1. Duke");
                        System.out.println("2. MT");
                        System.out.println("3. R15");
                        System.out.println("4. Triumph");
                        int bike = sc.nextInt();
                        switch(bike){
                            case 1:
                                System.out.println("Congrats! Duke will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! MT will be delivered soon");
                                break;
                            case 3:
                                System.out.println("Congrats! R15 will be delivered soon");
                                break;
                            case 4:
                                System.out.println("Congrats! Triumph will be delivered soon");
                                break;
                            default:
                                System.out.println("Nil");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("1. Yamaha");
                        System.out.println("2. Splender");
                        System.out.println("3. Pulsar");
                        int fbike = sc.nextInt();

                        switch(fbike){
                            case 1:
                                System.out.println("Congrats! Yamaha will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! Splender will be delivered soon");
                                break;
                            case 3:
                                System.out.println("Congrats! Pulsar will be delivered soon");
                                break;
                            default:
                                System.out.println("Nil");
                        }
                        break;
                    default:
                        System.out.println("Sorry, the model is not available here");
                    break;
                }
            case 2:
                System.out.println("Three wheelers");
                System.out.println("1. Auto");    
                System.out.println("2. Waste collection vehicle :");

                int threechoice = sc.nextInt();
                switch (threechoice) {
                    case 1:
                        System.out.println("1. Pink auto");
                        System.out.println("2. yellow auto");
                        System.out.println("3. Green auto");

                        int color = sc.nextInt();
                        switch (color) {
                            case 1:
                                System.out.println("Congrats! Pink auto will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! Yellow auto will be delivered soon");
                                break;
                            case 3:
                                System.out.println("Congrats! Green auto will be delivered soon");
                                break;
                        
                            default:
                                System.out.println("Nil");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("1. Electric vehicle");
                        System.out.println("2. Fuel vehicle");

                        int Waste = sc.nextInt();
                        switch (Waste) {
                            case 1:
                                System.out.println("Congrats! Electric vehicle will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! Fuel vehicle will be delivered soon");
                                break;
                            default:
                                System.out.println("Nil");
                                break;
                        }
                        break;
                    default:
                    System.out.println("Sorry , the model is not available");
                    break;
                }
            case 3:
                System.out.println("Four wheelers");
                System.out.println("1. Lorry");
                System.out.println("2. Truck");
                System.out.println("3. Car");
                
                int fourchoice = sc.nextInt();

                switch (fourchoice) {
                    case 1:
                        System.out.println("1. Eicher");
                        System.out.println("2. Mahindra");
                        System.out.println("3. Ashok leyland");

                        int lorry = sc.nextInt();
                        switch (lorry) {
                            case 1:
                                System.out.println("Congrats! Eicher will be delivered soon");
                            case 2:
                                System.out.println("Congrats! Mahindra will be delivered soon");
                            case 3:
                                System.out.println("Congrats! Ashok leyland will be delivered soon");
                            default:
                                System.out.println("Nil");
                                break;
                        }
                    break;
                    case 2:
                        System.out.println("1. Mahindra");
                        System.out.println("2. Volvo");
                        System.out.println("3. Scania");

                        int truck = sc.nextInt();
                        switch (truck) {
                            case 1:
                                System.out.println("Congrats! Mahindra will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! Volvo will be delivered soon");
                                break;
                            case 3:
                                 System.out.println("Congrats! Scania will be delivered soon");
                                 break;
                        
                            default:
                                System.out.println("Nil");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("1. Audi");
                        System.out.println("2. Kia");
                        System.out.println("3. Ferrari");
                        int car = sc.nextInt();
                        switch (car) {
                            case 1:
                                System.out.println("Congrats! Audi will be delivered soon");
                                break;
                            case 2:
                                System.out.println("Congrats! Kia will be delivered soon");
                                break;
                            case 3:
                                System.out.println("Congrats! Ferrari will be delivered soon");
                        
                            default:
                                System.out.println("Nil");
                                break;
                        }
                        break;
                    default:
                        System.out.println("Sorry , the model your asking is not available");
                break;
                        }
        }
        System.out.println("Thank you so much for visiting our showroom");
        
    }
}
