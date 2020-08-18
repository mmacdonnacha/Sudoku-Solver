package com.macdonnacha.micheal.app.solver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.macdonnacha.micheal.app.sudoku.Grid;
import com.macdonnacha.micheal.app.sudoku.Cell;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class CleanUpTest {
    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(
           "020000000000000000000000000000000000000000000000000000000000000000000000000000000");
    }

    @After
    public void tearDown() {
        grid = null;
    }

    @Test
    public void removalOfCandidatesFromRow(){
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for(Cell c : this.grid.getRow(cell)){

            if(c != cell){
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            
            if(shouldBeFalse){
                // candidate was not removed so test should fail
                break;
            }
        }
        
        
        assertFalse(shouldBeFalse);
    }


    @Test
    public void removalOfCandidatesFromColumn(){
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for(Cell c : this.grid.getColumn(cell)){
            
            if(c != cell){
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            
            if(shouldBeFalse){
                // candidate was not removed so test should fail
                break;
            }
        }
        
        
        assertFalse(shouldBeFalse);
    }


    @Test
    public void removalOfCandidatesFromSquare(){
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpSquare(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for(Cell c : this.grid.getSquare(cell)){
            
            if(c != cell){
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            
            if(shouldBeFalse){
                // candidate was not removed so test should fail
                break;
            }
        }
        
        
        assertFalse(shouldBeFalse);
    }

}