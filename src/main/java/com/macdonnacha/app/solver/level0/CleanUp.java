package com.macdonnacha.app.solver.level0;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;

public class CleanUp {

    public static void cleanUpRow(Grid grid, Cell cell) {
        Cell[] row = grid.getRow(cell);
        int value = cell.value();
        for (Cell c : row) {
            if (!c.isSolved()) {
                // if (c.getPossibleCandidates().contains("" + value)) {
                //     printRemovalLog(cell, c, "row");
                // }

                c.removeCandidate(value);
            }
        }
    }

    public static void cleanUpColumn(Grid grid, Cell cell) {
        Cell[] column = grid.getColumn(cell);
        int value = cell.value();
        for (Cell c : column) {
            if (!c.isSolved()) {
                // if (c.getPossibleCandidates().contains("" + value)) {
                //     printRemovalLog(cell, c, "column");
                // }

                c.removeCandidate(value);
            }
        }
    }

    public static void cleanUpSquare(Grid grid, Cell cell) {
        Cell[] square = grid.getSquare(cell);
        int value = cell.value();
        for (Cell c : square) {
            if (!c.isSolved()) {
                // if (c.getPossibleCandidates().contains("" + value)) {
                //     printRemovalLog(cell, c, "box");
                // }

                c.removeCandidate(value);
            }
        }
    }

    public static void printRemovalLog(Cell cellAlreadySolved, Cell cellToBeRemoved, String place) {

        switch (place) {
            case "row":
                System.out.println("Cleanup unit [row of " + cellAlreadySolved.coordinates() + "]: " 
                    + "removed " + cellAlreadySolved.value() 
                    + " from " + cellToBeRemoved.coordinates());
                break;
            case "column":
                System.out.println("Cleanup unit [column of " + cellAlreadySolved.coordinates() + "]: " 
                    + "removed "+ cellAlreadySolved.value() 
                    + " from " + cellToBeRemoved.coordinates());
                break;
            case "box":
                System.out.println("Cleanup unit [box of " + cellAlreadySolved.coordinates() + "]: " 
                    + "removed " + cellAlreadySolved.value() 
                    + " from " + cellToBeRemoved.coordinates());
                break;
        }
    }
}