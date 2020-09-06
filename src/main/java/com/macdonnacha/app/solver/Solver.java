package com.macdonnacha.app.solver;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;
import com.macdonnacha.app.solver.level0.CleanUp;
import com.macdonnacha.app.solver.level0.NakedSingle;
import com.macdonnacha.app.solver.level0.Unique;

public class Solver {
    private Grid grid;

    public Solver(Grid grid){
        this.grid = grid;
    }


    public void solve(){
        String initialGrid = "";
        cleanUpGrid();
        // System.out.println(grid.fullGridInfo());
        
        while(!initialGrid.equals(this.grid.solutionAsSingleLine())){
            initialGrid = new String(this.grid.solutionAsSingleLine());

            level0Strategies();
            // System.out.println(grid.fullGridInfo());

        }
    }

    public void level0Strategies(){
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = grid.getCell(row, col);
                if(!cell.isSolved()){
                    if(cell.getPossibleCandidates().length() == 1){
                        setNakedSingle(cell);
                    }else{
                        setUnique(cell);
                    }
                }
            }
        }
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

    public void setNakedSingle(Cell cell){
        NakedSingle nakedSingle = new NakedSingle();
        
                    if(nakedSingle.hasSingleCandidate(cell)){
                        nakedSingle.setSingleCandidateValue(cell);
                        CleanUp.cleanUpRow(grid, cell);
                        CleanUp.cleanUpColumn(grid, cell);
                        CleanUp.cleanUpSquare(grid, cell);
                    }
                
            
        
    }


    public void setUnique(Cell cell){
        Unique unique = new Unique(grid);
        
                    int num = unique.uniqueCandidate(cell);
                    if(num != 0){
                        cell.setValue(num);
                        CleanUp.cleanUpRow(grid, cell);
                        CleanUp.cleanUpColumn(grid, cell);
                        CleanUp.cleanUpSquare(grid, cell);
                    }
    }
            
        
    
}