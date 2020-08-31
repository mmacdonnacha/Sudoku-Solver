package com.macdonnacha.micheal.app.solver;

import com.macdonnacha.micheal.app.sudoku.Cell;

public class NakedSingle {
    

    public boolean hasSingleCandidate(Cell cell){
        return (cell.isSolved() || cell.getPossibleCandidates().length() == 1);
    }

    public void setSingleCandidateValue(Cell cell){
        int value = Integer.valueOf(cell.getPossibleCandidates());

        cell.setValue(value);
    }
}