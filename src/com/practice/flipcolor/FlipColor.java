package com.practice.flipcolor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vitalii.kravets on 05.10.2016.
 */
public class FlipColor {

    public void flipColor(Boolean[][] matrix, int x, int y){
        boolean current = matrix[x][y];
        matrix[x][y] = !current;
        if(x-1 >= 0 && matrix[x-1][y] == current){
            flipColor(matrix, x-1, y);
        }

        if(x+1 < matrix.length && matrix[x+1][y] == current){
            flipColor(matrix, x+1, y);
        }

        if(y-1 >= 0 && matrix[x][y - 1] == current){
            flipColor(matrix, x, y-1);
        }

        if(y+1 < matrix.length && matrix[x][y+1] == current){
            flipColor(matrix, x, y+1);
        }
    }

    public void flipColorTwo(Boolean[][] matrix, int x, int y){
        Queue<Coordinates> q = new LinkedList<Coordinates>();
        boolean current = matrix[x][y];
        q.add(new Coordinates(x,y));
        while(!q.isEmpty()){
            Coordinates cell = q.poll();
            matrix[cell.x][cell.y] = !current;

            if(cell.x-1 >= 0 && matrix[cell.x-1][cell.y] == current){
                q.add(new Coordinates(cell.x-1,cell.y));
            }

            if(cell.x+1 < matrix.length && matrix[cell.x+1][cell.y] == current){
                q.add(new Coordinates(cell.x+1,cell.y));
            }

            if(cell.y-1 >= 0 && matrix[cell.x][cell.y - 1] == current){
                q.add(new Coordinates(cell.x,cell.y-1));
            }

            if(cell.y+1 < matrix.length && matrix[cell.x][cell.y+1] == current){
                q.add(new Coordinates(cell.x,cell.y+1));
            }
        }
    }

    private static class Coordinates{
        public int x;
        public int y;

        private Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
