package com.sudokusolver.app.solver.level1;

import java.util.Arrays;

import com.sudokusolver.app.sudoku.Cell;
import com.sudokusolver.app.sudoku.Grid;

public class NakedPair {
    private boolean silentFlag;

    public NakedPair(boolean flag){
        this.silentFlag = flag;
    }


    public boolean hasNakedPairRow(Grid grid, Cell cell){
        Cell[] row = grid.getRow(cell);

        for(Cell c : row){
            if(c != cell && cell.getPossibleCandidates().equals(c.getPossibleCandidates())){
                return true;
            }
        }

        return false;
    }


    public boolean hasNakedPairColumn(Grid grid, Cell cell){
        Cell[] column = grid.getColumn(cell);

        for(Cell c : column){
            if(c != cell && cell.getPossibleCandidates().equals(c.getPossibleCandidates())){
                return true;
            }
        }

        return false;
    }


    public boolean hasNakedPairBox(Grid grid, Cell cell){
        Cell[] box = grid.getBox(cell);

        for(Cell c : box){
            if(c != cell && cell.getPossibleCandidates().equals(c.getPossibleCandidates())){
                return true;
            }
        }

        return false;
    }


    public void setNakedPairRow(Grid grid, Cell cell){
        Cell pair;
        Cell[] row = grid.getRow(cell);

        pair = Arrays.asList(row).stream()
                     .filter(c -> c != cell)
                     .filter(c -> c.getPossibleCandidates().equals(cell.getPossibleCandidates()))
                     .findFirst()
                     .get();

        String nums = cell.getPossibleCandidates().replace("[", "").replace("]", "").replace(",", "");
        int num1 = Integer.parseInt(nums.split(" ")[0]);
        int num2 = Integer.parseInt(nums.split(" ")[1]);
        if(!silentFlag) System.out.println("Naked Pair: [row] " + num1 + ", " + num2 + " in "
             + cell.coordinates() + ", " + pair.coordinates());
        
        for(Cell c : row){
            if(!c.isSolved() && c != cell && c != pair){
                if(c.getPossibleCandidates().contains("" + num1)){
                    c.removeCandidate(num1);
                    if(!silentFlag) 
                        printRemovalLog(new Cell[]{cell, pair}, c, num1,"row");
                }
                if(c.getPossibleCandidates().contains("" + num2)){ 
                    c.removeCandidate(num2);
                    if(!silentFlag) 
                        printRemovalLog(new Cell[]{cell, pair}, c, num2,"row");
                }
                
            }
        }
    }

    public void setNakedPairColumn(Grid grid, Cell cell){
        Cell pair;
        Cell[] column = grid.getColumn(cell);

        pair = Arrays.asList(column).stream()
                     .filter(c -> c != cell)
                     .filter(c -> c.getPossibleCandidates().equals(cell.getPossibleCandidates()))
                     .findFirst()
                     .get();

        String nums = cell.getPossibleCandidates().replace("[", "").replace("]", "").replace(",", "");
        int num1 = Integer.parseInt(nums.split(" ")[0]);
        int num2 = Integer.parseInt(nums.split(" ")[1]);
        if(!silentFlag) System.out.println("Naked Pair: [column] " + num1 + ", " + num2 + " in "
             + cell.coordinates() + ", " + pair.coordinates());
        
        for(Cell c : column){
            if(!c.isSolved() && c != cell && c != pair){
                if(c.getPossibleCandidates().contains("" + num1)){
                    c.removeCandidate(num1);
                    if(!silentFlag) 
                        printRemovalLog(new Cell[]{cell, pair}, c, num1,"column");
                }
                if(c.getPossibleCandidates().contains("" + num2)){ 
                    c.removeCandidate(num2);
                    if(!silentFlag) 
                        printRemovalLog(new Cell[]{cell, pair}, c, num2,"column");
                }
            }
        }
    }

    public void setNakedPairBox(Grid grid, Cell cell){
        Cell pair;
        Cell[] Box = grid.getBox(cell);

        pair = Arrays.asList(Box).stream()
                     .filter(c -> c != cell)
                     .filter(c -> c.getPossibleCandidates().equals(cell.getPossibleCandidates()))
                     .findFirst()
                     .get();

        String nums = cell.getPossibleCandidates().replace("[", "").replace("]", "").replace(",", "");
        int num1 = Integer.parseInt(nums.split(" ")[0]);
        int num2 = Integer.parseInt(nums.split(" ")[1]);
        if(!silentFlag) System.out.println("Naked Pair: [box] " + num1 + ", " + num2 + " in "
             + cell.coordinates() + ", " + pair.coordinates());
        
        for(Cell c : Box){
            if(!c.isSolved() && c != cell && c != pair){
                if(c.getPossibleCandidates().contains("" + num1)){
                    c.removeCandidate(num1);
                    if(!silentFlag) 
                        printRemovalLog(new Cell[]{cell, pair}, c, num1,"box");
                }
                if(c.getPossibleCandidates().contains("" + num2)){ 
                    c.removeCandidate(num2);
                    if(!silentFlag) 
                        printRemovalLog(new Cell[]{cell, pair}, c, num2,"box");
                }
            }
        }
    }

    public static void printRemovalLog(Cell[] pair, Cell cellToBeRemoved, int num, String place) {

        switch (place) {
            case "row":
                System.out.println("Naked Pair [row of " + pair[0].coordinates() + ", " +pair[1].coordinates() + "]: " 
                    + "removed " + num
                    + " from " + cellToBeRemoved.coordinates());
                break;
            case "column":
                System.out.println("Naked Pair [column of " + pair[0].coordinates() + ", " +pair[1].coordinates() + "]: " 
                    + "removed " + num 
                    + " from " + cellToBeRemoved.coordinates());
                break;
            case "box":
                System.out.println("Naked Pair [box of " + pair[0].coordinates() + ", " +pair[1].coordinates() + "]: " 
                    + "removed " + num 
                    + " from " + cellToBeRemoved.coordinates());
                break;
        }
    }
    
}
