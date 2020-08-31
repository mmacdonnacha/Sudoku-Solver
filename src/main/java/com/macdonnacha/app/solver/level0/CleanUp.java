package com.macdonnacha.app.solver.level0;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;

public class CleanUp {
    
    
    public static void cleanUpRow(Grid grid, Cell cell){
        Cell[] row = grid.getRow(cell);
        int value = cell.value();
        for(Cell c : row){
            if(!c.isSolved())
                c.removeCandidate(value);
        }
    }

    public static void cleanUpColumn(Grid grid, Cell cell){
        Cell[] column = grid.getColumn(cell);
        int value = cell.value();
        for(Cell c : column){
            if(!c.isSolved())
                c.removeCandidate(value);
        }
    }

    public static void cleanUpSquare(Grid grid, Cell cell){
        Cell[] square = grid.getSquare(cell);
        int value = cell.value();
        for(Cell c : square){
            if(!c.isSolved())
                c.removeCandidate(value);
        }
    }
}