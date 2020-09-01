package com.macdonnacha.app.solver.level0;

import com.macdonnacha.app.sudoku.Cell;

public class NakedSingle {
    

    public boolean hasSingleCandidate(Cell cell){
        return (cell.isSolved() || cell.getPossibleCandidates().length() == 1);
    }

    public void setSingleCandidateValue(Cell cell){
        int value = Integer.valueOf(cell.getPossibleCandidates());
        // System.out.println("Naked Single: " + value + " in " + cell.coordinates());

        cell.setValue(value);
    }
}