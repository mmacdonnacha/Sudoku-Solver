package com.macdonnacha.micheal.app.sudoku;

public class Grid {
    private Cell[][] grid;


    public Grid(){
        prepareGrid();
    }


    private void prepareGrid(){
        this.grid = new Cell[9][9];

        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++) {
                grid[i][j] = new Cell(i+1, j+1);

                if(i%3 == 0){
                    grid[i][j].setValue(8);
                }
            }
        }
    }


    public String solutionAsLine(){
        StringBuilder sb = new StringBuilder();
        for (Cell[] rows : grid) {
            for(Cell c : rows){
                sb.append(c.value());
            }
        }
        return sb.toString();
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("||   |   |   ||   |   |   ||   |   |   ||\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");
        sb.append("++---+---+---++---+---+---++---+---+---++\n");

        return sb.toString();
    }
}