package com.practice.binary;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


/**
 * Created by vitalii.kravets on 13.09.2016.
 */
public class ReplaceBitsTest {

    @Test
    public void wipeOutOneBit(){
        int result = new ReplaceBits().wipeOutBits(0b101, 0, 1);
        assertEquals(0b100, result);
    }

    @Test
    public void wipeOutAllBit(){
        int result = new ReplaceBits().wipeOutBits(0b101, 0, 3);
        assertEquals(0b0, result);
    }

    @Test
    public void wipeOutSomeBit(){
        int result = new ReplaceBits().wipeOutBits(0b10101, 1, 3);
        assertEquals(0b10001, result);
    }

    @Test
    public void replaceBitsCompletely(){
        int result = new ReplaceBits().replaceBits(0b101, 0, 3, 0b010);
        assertEquals(0b010, result);
    }

    @Test
    public void replaceOneBit(){
        int result = new ReplaceBits().replaceBits(0b101, 0, 1, 0b0);
        assertEquals(0b100, result);
    }

    @Test
    public void replaceSomeBits(){
        int result = new ReplaceBits().replaceBits(0b10101, 1, 3, 0b01);
        assertEquals(0b10011, result);
    }
}
