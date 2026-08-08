import java.util.HashMap;
import java.util.Scanner;
class Hash {
    public static void main(String args[])
    {
        HashMap <Integer,String> apps = new HashMap<>();
        apps.put(1, "Youtube");
        apps.put(2,"Instagram" );
        apps.put(3, "Camera");
        apps.put(4,"Playstore");
        apps.put(5,"Snapchat");
        apps.put(6, "Claude");
        apps.put(7, "Whatsapp");
        apps.put(8,"Telegram");
        apps.put(9,"Telegram");
        apps.put(10,"Twitter");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the app you need to open:");
        int choice = sc.nextInt();

        if(apps.containsKey(choice)){
            System.out.println(apps.get(choice) +" has been opened");
        }
        else 
            System.out.println("App not found");

    }
}