package com.practice.deadlock;

/**
 * Created by vitalii.kravets on 16.08.2016.
 */
public interface Account {
    public void transfer(Account recipient, double amount);

    void withdraw(double amount);

    void deposit(double amount);

    double getBalance();
}
