package com.macdonnacha.micheal.app.solver;

import com.macdonnacha.micheal.app.sudoku.Grid;
import com.macdonnacha.micheal.app.sudoku.Cell;

public class CleanUp {
    
    
    public static void cleanUpRow(Grid grid, Cell cell){
        Cell[] row = grid.getRow(cell);
        int value = cell.value();
        for(Cell c : row){
            if(c != cell || !c.isSolved())
                c.removeCandidate(value);
        }
    }

    public static void cleanUpColumn(Grid grid, Cell cell){
        Cell[] column = grid.getColumn(cell);
        int value = cell.value();
        for(Cell c : column){
            if(c != cell || !c.isSolved())
                c.removeCandidate(value);
        }
    }

    public static void cleanUpSquare(Grid grid, Cell cell){
        Cell[] square = grid.getSquare(cell);
        int value = cell.value();
        for(Cell c : square){
            if(c != cell || !c.isSolved())
                c.removeCandidate(value);
        }
    }
}