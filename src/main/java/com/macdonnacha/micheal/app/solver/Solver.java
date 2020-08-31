package com.macdonnacha.micheal.app.solver;

import com.macdonnacha.micheal.app.sudoku.Grid;
import com.macdonnacha.micheal.app.sudoku.Cell;

public class Solver {
    private Grid grid;

    public Solver(Grid grid){
        this.grid = grid;
    }


    public void solve(){
        String initialGrid;
        do{
            initialGrid = new String(this.grid.solutionAsSingleLine());

            cleanUpGrid();
            setUnique();
            
        }while(!initialGrid.equals(this.grid.solutionAsSingleLine()));
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

    public void setUnique(){
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
}