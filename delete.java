import java.util.*;
class Bank{
    String name;
    String accountnum;
    double amount;
    double balance;

    void deposit(double amount){
        balance = balance + amount;
        System.out.println("Amount has been deposited");
        System.out.println("Balance amount: "+balance);
    }
    void withdraw(double amount){
    }
}