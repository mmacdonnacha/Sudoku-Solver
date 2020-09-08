package com.macdonnacha.app.solver;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;
import com.macdonnacha.app.solver.level0.CleanUp;
import com.macdonnacha.app.solver.level0.NakedSingle;
import com.macdonnacha.app.solver.level0.Unique;
import com.macdonnacha.app.solver.level1.NakedPair;

public class Solver {
    private boolean silentFlag;
    private Grid grid;
    private CleanUp cleanUp;
    private NakedSingle nakedSingle;
    private NakedPair nakedPair;
    

    public Solver(Grid grid) {
        this.grid = grid;
        silentFlag = grid.getSilentFlag();
        cleanUp = new CleanUp(silentFlag);
        nakedSingle = new NakedSingle(silentFlag);
        nakedPair = new NakedPair(silentFlag);
    }

    public void solve() {
        String initialGrid = "";
        cleanUpGrid();

        if (!silentFlag) System.out.println(grid.fullGridInfo());

        while (true) {
            if(initialGrid.equals(this.grid.fullGridInfo()))
                break;

            initialGrid = new String(this.grid.fullGridInfo());
            
            level0Strategies();
            if (!silentFlag) System.out.println(grid.fullGridInfo());

            if(initialGrid.equals(this.grid.fullGridInfo()))
                level1Strategies();
        }
    }

    public void level0Strategies() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Cell cell = grid.getCell(row, col);
                if (!cell.isSolved()) {
                    if (cell.getPossibleCandidates().length() == 1) {
                        setNakedSingle(cell);
                    } else {
                        setUnique(cell);
                    }
                }
            }
        }
    }

    public void level1Strategies(){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Cell cell = grid.getCell(row, col);
                if (!cell.isSolved()) {
                    if (cell.getPossibleCandidates().length() == 4) {
                        setNakedPair(cell);
                    }
                }
            }
        }
    }


    public void cleanUpGrid() {
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Cell cell = grid.getCell(row, col);
                if (cell.isSolved()) {
                    cleanUp.cleanUpRow(grid, cell);
                    cleanUp.cleanUpColumn(grid, cell);
                    cleanUp.cleanUpBox(grid, cell);
                }
            }
        }

    }

    public void setNakedSingle(Cell cell) {
        if (nakedSingle.hasSingleCandidate(cell)) {
            nakedSingle.setSingleCandidateValue(cell);
            cleanUp.cleanUpRow(grid, cell);
            cleanUp.cleanUpColumn(grid, cell);
            cleanUp.cleanUpBox(grid, cell);
        }

    }

    public void setUnique(Cell cell) {
        Unique unique = new Unique(grid);

        int num = unique.uniqueCandidate(cell);
        if (num != 0) {
            cell.setValue(num);
            cleanUp.cleanUpRow(grid, cell);
            cleanUp.cleanUpColumn(grid, cell);
            cleanUp.cleanUpBox(grid, cell);
        }
    }


    public void setNakedPair(Cell cell) {
        if (nakedPair.hasNakedPairRow(grid, cell)) 
            nakedPair.setNakedPairRow(grid, cell);

        if (nakedPair.hasNakedPairColumn(grid, cell)) 
            nakedPair.setNakedPairColumn(grid, cell);
           
        if (nakedPair.hasNakedPairBox(grid, cell)) 
            nakedPair.setNakedPairBox(grid, cell);   
           
           
            cleanUp.cleanUpRow(grid, cell);
            cleanUp.cleanUpColumn(grid, cell);
            cleanUp.cleanUpBox(grid, cell);
        }

    

}