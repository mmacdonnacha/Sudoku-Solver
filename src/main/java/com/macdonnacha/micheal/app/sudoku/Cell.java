package com.macdonnacha.micheal.app.sudoku;

public class Cell {
    private int value;
    private int[] candidates;
    private int x, y;


    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        value = -1;
        candidates = new int[]{0,1,2,3,4,5};
    }


    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int value(){
        if (candidates.length > 1){
            return 0;
        }else {
            return value;
        }
    }

    public void setValue(int num){
        candidates = new int[]{ num };
        value = num;
    }
}