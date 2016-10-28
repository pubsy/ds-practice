package com.practice.deadlock;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by vitalii.kravets on 16.08.2016.
 */
public class DeadLock {

    @Test
    public void testMoneyTransfer() throws InterruptedException {

        final Account user1 = new UserAccount(0.0);
        final Account user2 = new UserAccount(0.0);

        for(int i= 0; i < 100 ; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    user1.transfer(user2, 1.0);
                }
            });

            Thread threadTwo = new Thread(new Runnable() {
                @Override
                public void run() {
                    user2.transfer(user1, 2.0);
                }
            });
            thread.start();
            threadTwo.start();
            thread.join();
            threadTwo.join();
        }


        assertEquals(100.0, user1.getBalance(), 0.0);
        assertEquals(-100.0, user2.getBalance(), 0.0);
    }
}
