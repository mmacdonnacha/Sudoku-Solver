package com.macdonnacha.app.solver.level1;

import java.util.Arrays;

import com.macdonnacha.app.sudoku.Cell;
import com.macdonnacha.app.sudoku.Grid;

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
        
        for(Cell c : row){
            if(!c.isSolved() && c != cell && c != pair){
                c.removeCandidate(num1);
                c.removeCandidate(num2);
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
        
        for(Cell c : column){
            if(!c.isSolved() && c != cell && c != pair){
                c.removeCandidate(num1);
                c.removeCandidate(num2);
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
        
        for(Cell c : Box){
            if(!c.isSolved() && c != cell && c != pair){
                c.removeCandidate(num1);
                c.removeCandidate(num2);
            }
        }
    }
    
}
