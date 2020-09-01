package com.macdonnacha.app.solver.level0;

import com.macdonnacha.app.sudoku.Cell;
import com.macdonnacha.app.sudoku.Grid;

public class Unique {
    private Grid grid;

    /*
     * look at a cell check first candidate if candidate does not appear in row,
     * column or square it must be the solution for the given cell
     * 
     * if it is not the solution repeat steps with next canditate if cell cant be
     * solved check next cell
     * 
     */

    public Unique(Grid grid) {
        this.grid = grid;
    }

    public int uniqueCandidate(Cell cell) {
        int num = 0;
        
        num = uniqueCandidateInRow(cell);
        if (num != 0)
            return num;

        num = uniqueCandidateInColumn(cell);
        if (num != 0)
            return num;

        num = uniqueCandidateInSquare(cell);
        if (num != 0)
            return num;

        return num;
    }

    public int uniqueCandidateInRow(Cell cell) {
        char[] array = cell.getPossibleCandidates().replaceAll("\\s+", "").replaceAll(",", "").toCharArray();
        for (char ch : array) {
            int num = Integer.parseInt(new String("" + ch));
            int count = 0;

            Cell[] row = grid.getRow(cell);

            for (Cell c : row) {
                if (!(c == cell)) {
                    if (c.getPossibleCandidates().contains("" + num)) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                // printRemovalLog(cell, num, "row");
                return num;
            }

        }

        return 0;
    }

    public int uniqueCandidateInColumn(Cell cell) {
        char[] array = cell.getPossibleCandidates().replaceAll("\\s+", "").replace(",", "").toCharArray();
        for (char ch : array) {
            int num = Integer.parseInt(new String("" + ch));
            int count = 0;

            Cell[] column = grid.getColumn(cell);

            for (Cell c : column) {
                if (!(c == cell)) {
                    if (c.getPossibleCandidates().contains("" + num)) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                // printRemovalLog(cell, num, "column");
                return num;
            }

        }

        return 0;
    }

    public int uniqueCandidateInSquare(Cell cell) {
        char[] array = cell.getPossibleCandidates().replaceAll("\\s+", "").replace(",", "").toCharArray();
        for (char ch : array) {
            int num = Integer.parseInt(new String("" + ch));
            int count = 0;

            Cell[] square = grid.getSquare(cell);

            for (Cell c : square) {
                if (!(c == cell)) {
                    if (c.getPossibleCandidates().contains("" + num)) {
                        count++;
                    }
                }
            }

            if (count == 0) {
                // printRemovalLog(cell, num, "box");
                return num;
            }

        }

        return 0;
    }

    public void printRemovalLog(Cell cell, int value, String place){

        System.out.println("Unique unit: " + value + " in " + cell.coordinates()
        + " is unique within " + place + ".");

        char[] numbers = cell.getPossibleCandidates().replaceAll("\\s+", "").replace(",", "").toCharArray();
        
        for(char c : numbers){
            int num = Integer.parseInt(new String("" + c));
            if(value != num){
                System.out.println("Unique unit: removed " + num + " from " + cell.coordinates());
            }
        }

    }
}