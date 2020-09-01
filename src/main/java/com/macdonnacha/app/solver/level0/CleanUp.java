package com.macdonnacha.app.solver.level0;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;

public class CleanUp {
    
    
    public static void cleanUpRow(Grid grid, Cell cell){
        Cell[] row = grid.getRow(cell);
        int value = cell.value();
        for(Cell c : row){
            if(!c.isSolved()){
            //     if(c.getPossibleCandidates().contains("" + value)){
            //         System.out.println("Cleanup unit [row of " + cell.coordinates() + "]: " 
            //             + "removed " + cell.value() + " from " + c.coordinates());
            // }

                c.removeCandidate(value);
            }
        }
    }

    public static void cleanUpColumn(Grid grid, Cell cell){
        Cell[] column = grid.getColumn(cell);
        int value = cell.value();
        for(Cell c : column){
            if(!c.isSolved()){
                // if(c.getPossibleCandidates().contains("" + value)){
                //     System.out.println("Cleanup unit [column of " + cell.coordinates() + "]: " 
                //         + "removed " + cell.value() + " from " + c.coordinates());
                // }

                c.removeCandidate(value);
            }
        }
    }

    public static void cleanUpSquare(Grid grid, Cell cell){
        Cell[] square = grid.getSquare(cell);
        int value = cell.value();
        for(Cell c : square){
            if(!c.isSolved()){
                // if(c.getPossibleCandidates().contains("" + value)){
                //     System.out.println("Cleanup unit [box of " + cell.coordinates() + "]: " 
                //         + "removed " + cell.value() + " from " + c.coordinates());
                // }

                c.removeCandidate(value);
            }
        }
    }
}