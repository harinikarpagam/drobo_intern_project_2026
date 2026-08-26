import java.util.*;
class Bankdetails {
    String name;
    String accountnum;
    double balance;

    Bankdetails(String name, String accountnum, double balance) {
        this.name = name;
        this.accountnum = accountnum;
        this.balance = balance;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        }
        else if (amount > balance) {
            System.out.println("Insufficient amount");
        }
        else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully");
        }
    }

    void deposit(double amount) {
        if(amount > 0) {
            balance = balance + amount;
            System.out.println("Amount has been deposited");
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    void checkbalance() {
        System.out.println("The balance amount in your account: " + balance);
    }

    void displaydata() {
        System.out.println("Name of the account holder: " + name);
        String maskedAccount;
        if(accountnum.length() > 4) {
            maskedAccount =
                    "X".repeat(accountnum.length() - 4)
                    + accountnum.substring(accountnum.length() - 4);
        }
        else {
            maskedAccount = accountnum;
        }
        System.out.println("Account number of the account: " + maskedAccount);
        System.out.println("Balance amount in the account: " + balance);
    }
}

class SavingsAccount extends Bankdetails {
     SavingsAccount(String name, String accountnum, double balance) {
        super(name, accountnum, balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
        }
        else if (balance - amount < 1000) {
            System.out.println("Savings account must maintain a minimum balance of ₹1000");
        }
        else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully");
        }
    }
    @Override
    void displaydata() {
        System.out.println("Account Type: Savings Account");
        super.displaydata();
    }
}

class CurrentAccount extends Bankdetails {
    CurrentAccount(String name, String accountnum, double balance) {
    super(name, accountnum, balance);
    }
    @Override
    void displaydata() {
        System.out.println("Account Type: Current Account");
        super.displaydata();
    }
}

public class Bank {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Bankdetails> account = new HashMap<>();

        while (true) {

            System.out.println("----BANK MENU----");
            System.out.println("1. Create account");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display details");
            System.out.println("6. Transfer money");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter account number:");
                    String accountnum = sc.next();

                    if(account.containsKey(accountnum)) {
                        System.out.println("Account already exists");
                        break;
                    }
                    sc.nextLine();

                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Choose account type:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    int type = sc.nextInt();
                    System.out.println("Enter initial amount:");
                    double balance = sc.nextDouble();
                    if (balance < 0) {
                        System.out.println("Invalid initial amount");
                        break;
                    }
                    Bankdetails newaccount;
                    if (type == 1) {
                        if (balance < 1000) {
                            System.out.println("Savings account requires minimum initial balance of ₹1000");
                            break;
                        }
                        newaccount = new SavingsAccount(name, accountnum, balance);
                    }
                    else if (type == 2) {
                        newaccount = new CurrentAccount(name, accountnum, balance);
                    }
                    else {
                        System.out.println("Invalid account type");
                        break;
                    }

                    account.put(accountnum, newaccount);
                    System.out.println("Account created successfully");
                    break;
                    
                case 2:
                    System.out.println("Enter account number:");
                    accountnum = sc.next();

                    if(account.containsKey(accountnum)) {

                        System.out.println("Enter withdraw amount:");
                        double amount = sc.nextDouble();
                        account.get(accountnum).withdraw(amount);
                    }
                    else {
                        System.out.println("Account not found");
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter account number:");
                    accountnum = sc.next();

                    if(account.containsKey(accountnum)) {

                        System.out.println("Enter deposit amount:");
                        double amount = sc.nextDouble();
                        account.get(accountnum).deposit(amount);
                    }
                    else {
                        System.out.println("Account not available");
                    }
                    break;
                    
                case 4:
                    System.out.println("Enter account number:");
                    accountnum = sc.next();

                    if(account.containsKey(accountnum)) {
                        account.get(accountnum).checkbalance();
                    }
                    else {
                        System.out.println("Account not available");
                    }
                    break;
                    
                case 5:
                    System.out.println("Enter account number:");
                    accountnum = sc.next();

                    if(account.containsKey(accountnum)) {
                        account.get(accountnum).displaydata();
                    }
                    else {
                        System.out.println("Account not available");
                    }
                    break;
                    
                case 6:
                     System.out.println("Enter sender account number:");
                    String senderNumber = sc.next();
                    
                    if(!account.containsKey(senderNumber)) {
                        System.out.println("Sender account not found");
                        break;
                    }

                    System.out.println("Enter receiver account number:");
                    String receiverNumber = sc.next();

                    if(!account.containsKey(receiverNumber)) {
                        System.out.println("Receiver account not found");
                        break;
                    }

                    if(senderNumber.equals(receiverNumber)) {
                        System.out.println("Sender and receiver cannot be the same");
                        break;
                    }

                    System.out.println("Enter transfer amount:");
                    double transferAmount = sc.nextDouble();

                    if(transferAmount <= 0) {
                        System.out.println("Invalid transfer amount");
                        break;
                    }

                    Bankdetails sender = account.get(senderNumber);
                    Bankdetails receiver = account.get(receiverNumber);

                    if(transferAmount > sender.balance) {
                        System.out.println("Insufficient balance");
                        break;
                    }

                    if(sender instanceof SavingsAccount &&
                            sender.balance - transferAmount < 1000) {
                                System.out.println("Transfer failed. Savings account must maintain ₹1000 minimum balance");
                        break;
                    }

                    sender.balance = sender.balance - transferAmount;
                    receiver.balance = receiver.balance + transferAmount;

                    System.out.println("Transfer successful");
                    System.out.println("Sender new balance: " + sender.balance);
                    System.out.println("Receiver new balance: " + receiver.balance);
                    break;
                    
                case 7:
                    System.out.println("Thank you for using the Bank System");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}