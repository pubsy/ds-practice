package com.practice.binary;

/**
 * Created by vitalii.kravets on 13.09.2016.
 */
public class ReplaceBits {

    public int replaceBits(int original, int i, int j, int subst){

        return wipeOutBits(original, i, j) | (subst << i);
    }

    public int wipeOutBits(int n, int i, int j){
        int max = ~0; /* All 1’s */

            // 1’s through position j, then 0’s
         int left = max - ((1 << j) - 1);

           // 1’s after position i
         int right = ((1 << i) - 1);

         // 1’s, with 0s between i and j
         int mask = left | right;

         // Clear i through j, then put m in there
         return (n & mask);
    }
}
