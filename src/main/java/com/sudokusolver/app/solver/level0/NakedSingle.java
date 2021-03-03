package com.sudokusolver.app.solver.level0;

import com.sudokusolver.app.sudoku.Cell;

public class NakedSingle {

    private boolean silentFlag;

    public NakedSingle(boolean flag){
        this.silentFlag = flag;
    }
    

    public boolean hasSingleCandidate(Cell cell){
        return (cell.isSolved() || cell.getPossibleCandidates().length() == 1);
    }

    public void setSingleCandidateValue(Cell cell){
        int value = Integer.valueOf(cell.getPossibleCandidates());
        if(!silentFlag) System.out.println("Naked Single: " + value + " in " + cell.coordinates());

        cell.setValue(value);
    }
}