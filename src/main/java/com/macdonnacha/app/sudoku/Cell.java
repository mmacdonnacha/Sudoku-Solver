package com.macdonnacha.app.sudoku;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    private int value;
    private List<Integer> candidates;
    private int x, y;


    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        value = 0;
        candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)); 
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
            this.candidates = new ArrayList<>();
            this.candidates.add(num);
            value = num;
        }
    }

    public void removeCandidate(int num){
        if(this.candidates.contains(num)){
            this.candidates.remove(Integer.valueOf(num));
        }
    }


    public boolean isSolved(){
        return this.candidates.size() == 1 && this.value == this.candidates.get(0);
    }

    public int getQuadrant(){

        /*
            +-+-+-+
            |0|1|2|
            +-+-+-+
            |3|4|5|
            +-+-+-+
            |6|7|8|
            +-+-+-+
        */

        int square;

        if(0 <= this.x && this.x <= 2){
            // first row of squares
            if(0<= this.y && this.y <= 2){
                // first column of squares i.e top left
                square = 0;
            }else if(3<= this.y && this.y <= 5){
                // second column of squares i.e top middle
                square = 1;
            }else {
                // third column of squares i.e top right
                square = 2;
            }

        }else if(3 <= this.x && this.x <= 5){
            // second row of squares
            if(0<= this.y && this.y <= 2){
                // first column of squares i.e middle left
                square = 3;
            }else if(3<= this.y && this.y <= 5){
                // second column of squares i.e middle middle
                square = 4;
            }else {
                // third column of squares i.e middle right
                square = 5;
            }
        } else{
            // third row of squares
            if(0<= this.y && this.y <= 2){
                // first column of squares i.e bottom left
                square = 6;
            }else if(3<= this.y && this.y <= 5){
                // second column of squares i.e bottom middle
                square = 7;
            }else {
                // third column of squares i.e bottom right
                square = 8;
            }
        }

        return square;
    }

    public String getPossibleCandidates(){
        return this.candidates.toString().replace("[", "").replace("]", "");
    }


    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + "), [" + this.getPossibleCandidates() + "]";
    }
}