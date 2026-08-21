import java.util.*;
class Bankdetails{
    String name;
    String accountnum;
    double balance;

    Bankdetails(String name, String accountnum, double balance){
        this.name = name;
        this.accountnum = accountnum;
        this.balance = balance;
    }
    void withdraw(double amount){
      if(amount>balance){
        System.out.println("Insufficient amount");
      }
      else if(amount<0){
        System.out.println("Cannot be processed");
      }
      else{
        balance = balance - amount;
      }
        }
    
    void deposit(double amount){
        if(amount>=0){
            balance = balance + amount;
        System.out.println("Amount has been deposited");
        }
        else{
            System.out.println("Nil");
        }
    }
    void checkbalance(){
        System.out.println("The balance amount in your account: " +balance);
    }
    void displaydata(){
        System.out.println("Name of the account holder: "+name);
        System.out.println("Account number of the account: "+accountnum);
        System.out.println("Balance amount in the account: "+balance);
    }
}
public class Bank{
    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    HashMap<String,Bankdetails> account = new HashMap<>();
    while(true){
        System.out.println("Enter the choice number that you want to proceed with:");
        System.out.println("1. Create account");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Check Balance");
        System.out.println("5. Display details");

        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter account number:");
                String accountnum = sc.next();
                sc.nextLine();
                if(account.containsKey(accountnum)){
                    System.out.println("Account already exist");
                    break;
                }
                System.out.println("Enter name:");
                String name = sc.nextLine();

                System.out.println("Enter initial amount:");
                double balance = sc.nextDouble();

                Bankdetails newaccount = new Bankdetails(name, accountnum, balance);
                account.put(accountnum,newaccount);
                System.out.println("Account created successfully");
                break;

            case 2:
                System.out.println("Enter account number: ");
                accountnum = sc.next();
                if(account.containsKey(accountnum)){
                    System.out.println("Enter withdraw amount: ");
                    double amount = sc.nextDouble();
                    account.get(accountnum).withdraw(amount);
                }
                else{
                    System.out.println("Account not found");
                }
                break;

            case 3:
                System.out.println("Enter account number: ");
                accountnum = sc.next();
                if(account.containsKey(accountnum)){
                    System.out.println("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    account.get(accountnum).deposit(amount);
                }
                else{
                    System.out.println("Account not available");
                }
                break;
            case 4:
                System.out.println("Enter account number: ");
                accountnum = sc.next();
                if(account.containsKey(accountnum)){
                    account.get(accountnum).checkbalance();
                }
                else{
                    System.out.println("Account not available");
                }
                break;
            case 5:
                System.out.println("Enter account number: ");
                accountnum = sc.next();
                if(account.containsKey(accountnum)){
                    account.get(accountnum).displaydata();
                }
                else{
                    System.out.println("Account not available");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    } 
}
}