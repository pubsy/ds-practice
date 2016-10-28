package com.practice.deadlock;

import java.util.UUID;

/**
 * Created by vitalii.kravets on 16.08.2016.
 */
public class UserAccount implements Account {

    private double balance;

    public UserAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void transfer(Account recipient, double amount) {
        synchronized (this) {
            synchronized (recipient) {
                this.withdraw(amount);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                recipient.deposit(amount);
            }
        }
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
