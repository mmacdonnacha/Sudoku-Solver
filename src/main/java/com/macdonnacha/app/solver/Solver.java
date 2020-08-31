package com.macdonnacha.app.solver;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;

public class Solver {
    private Grid grid;

    public Solver(Grid grid){
        this.grid = grid;
    }


    public void solve(){
        String initialGrid;
        cleanUpGrid();
        
        do{
            initialGrid = new String(this.grid.solutionAsSingleLine());

            level0Stragies();

        }while(!initialGrid.equals(this.grid.solutionAsSingleLine()));

        
    }

    public void level0Stragies(){
        setNakedSingle();
        cleanUpGrid();
        setUnique();
        cleanUpGrid();
    }



    public void cleanUpGrid(){
        
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = grid.getCell(row, col);
                if(cell.isSolved()){
                    CleanUp.cleanUpRow(grid, cell);
                    CleanUp.cleanUpColumn(grid, cell);
                    CleanUp.cleanUpSquare(grid, cell);
                }
            }
        }
        
    }

    public void setNakedSingle(){
        NakedSingle nakedSingle = new NakedSingle();
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = grid.getCell(row, col);
                if(!cell.isSolved()){
                    if(nakedSingle.hasSingleCandidate(cell))
                        nakedSingle.setSingleCandidateValue(cell);
                }
            }
        }
    }


    public void setUnique(){
        Unique unique = new Unique(grid);
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = grid.getCell(row, col);
                if(!cell.isSolved()){
                    // System.out.println(cell);
                    int num = unique.uniqueCandidate(cell);
                    if(num != 0){
                        cell.setValue(num);
                        // System.out.println("Setting value: " + num + " into Cell: " + cell);
                    }
                }
            }
        }
    }
}