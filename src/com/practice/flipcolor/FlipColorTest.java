package com.practice.flipcolor;

import org.testng.annotations.Test;

/**
 * Created by vitalii.kravets on 05.10.2016.
 */
public class FlipColorTest {

    @Test
    public void testFlipColor(){
        Boolean[][] matrix = new Boolean[][]
                {{true,  false, true,  true},
                 {false, false, false, false},
                 {false, false, true,  true},
                 {true,  true,  true,  false}};
        new FlipColor().flipColorTwo(matrix, 2, 1);

        for(int i=0; i<matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ") ;
        }
    }

}

