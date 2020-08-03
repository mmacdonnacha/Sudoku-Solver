package com.macdonnacha.micheal.app.sudoku;

public class Cell {
    private int value;
    private int[] candidates;
    private int x, y;


    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        value = 0;

        // [0] is the amount of possible candidates
        // the rest of the array is 1 or 0 for possible candidates
        // candidate[4] = 1 means that 4 is a candidate 
        // candidate[6] = 0 means that 6 is not a candidate
        candidates = new int[]{9, 1, 1, 1, 1, 1, 1, 1, 1, 1}; 
    }


    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int value(){
        return this.value;
    }

    public void setValue(int num){
        
        if(num == 0){
            // do nothing as candidates is already set in the constructor
        } else {
            this.candidates = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            this.candidates[num] = 1;
            value = num;
        }
    }


    public boolean isSolved(){
        return this.candidates[0] == 1 && this.value != 0;
    }

    public String getPossibleCandidates(){
        return candidates.toString();
    }


    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + "), " + this.getPossibleCandidates();
    }
}