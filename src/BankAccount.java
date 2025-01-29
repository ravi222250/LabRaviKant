package src;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private final List<String> transactionsHistory;

    private double balance;
    private String ownerName;

    public BankAccount() {
        transactionsHistory = new ArrayList<>();
    }

    public BankAccount(String ownerName, double balance) {
        transactionsHistory = new ArrayList<>();
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            transactionsHistory.add("Balance is reset to $" + balance);
            this.balance = balance;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void printTranscationsHistory() {
        transactionsHistory.forEach(System.out::println);
    }

    public void deposit (double amount) {
        if (amount>0) {
            transactionsHistory.add("Deposited $" + amount);
            this.balance += amount;
        } else {
            System.out.println("amount should be >=0");
        }
    }

    public void withdraw (double amount) {
        if (amount > 0 && amount>balance) {
            transactionsHistory.add("Withdrawn $" + amount);
            balance -= amount;
        } else {
            System.out.println("Amount should be >=0 and balance itself");
        }
    }

}
