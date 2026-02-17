package org.BankApp;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    private int accNo;

    private String name;
    private String address;
    private String accType;
    private double balance;
    private double minBalance;

    public Account() {}

    public Account(int accNo, String name, String address,
                   String accType, double balance, double minBalance) {
        this.accNo = accNo;
        this.name = name;
        this.address = address;
        this.accType = accType;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    // Getters & Setters
    public int getAccNo() { return accNo; }
    public double getBalance() { return balance; }
    public double getMinBalance() { return minBalance; }

    public void setBalance(double balance) { this.balance = balance; }
}
