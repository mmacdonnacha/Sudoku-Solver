package com.macdonnacha.app.solver.level0;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CleanUpTest {
    private Grid grid;
    private CleanUp cleanUp;

    @Before
    public void setUp() {
        grid = new Grid("020000000000000000000000000000000000000000000000000000000000000000000000000000000", true);
        cleanUp = new CleanUp(grid.getSilentFlag());
    /*
        ++---+---+---++---+---+---++---+---+---++
        ||   | 2 |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ++---+---+---++---+---+---++---+---+---++
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ++---+---+---++---+---+---++---+---+---++
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ++---+---+---++---+---+---++---+---+---++
     */
    
    }

    @After
    public void tearDown() {
        grid = null;
    }

    @Test
    public void removalOfCandidatesFromRow() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for (Cell c : this.grid.getRow(cell)) {

            if (c != cell) {
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            if (shouldBeFalse) {
                // shouldBeFalse = true
                // candidate was not removed so test should fail
                break;
            }
        }

        assertFalse(shouldBeFalse);
    }

    @Test
    public void removalOfCandidatesFromColumn() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for (Cell c : this.grid.getColumn(cell)) {

            if (c != cell) {
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            if (shouldBeFalse) {
                // shouldBeFalse = true
                // candidate was not removed so test should fail
                break;
            }
        }

        assertFalse(shouldBeFalse);
    }

    @Test
    public void removalOfCandidatesFromBox() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpBox(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for (Cell c : this.grid.getBox(cell)) {

            if (c != cell) {
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            if (shouldBeFalse) {
                // shouldBeFalse = true
                // candidate was not removed so test should fail
                break;
            }
        }

        assertFalse(shouldBeFalse);
    }

    @Test
    public void cleanUpRowDoesNotAffectTheColumn() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getColumn(cell)) {

            if (c != cell) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // shouldBeTrue = false
                // candidate was removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpRowDoesNotAffectTheRestOfQuadrant() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getBox(cell)) {

            boolean cellsInRow = (c.getX() == 0 && (c.getY() == 0 || c.getY() == 1 || c.getY() == 2));
            if (!cellsInRow) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // shouldBeTrue = false
                // candidate was removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpColumnDoesNotAffectTheRestOfRow() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getRow(cell)) {

            if (c != cell) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // shouldBeFalse = true
                // candidate was not removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpColumnDoesNotAffectTheRestOfQuadrant() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getBox(cell)) {

            boolean cellsInColumn = (c.getY() == 1 && (c.getX() == 0 || c.getX() == 1 || c.getX() == 2));
            if (!cellsInColumn) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // shouldBeTrue = false
                // candidate was removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpBoxDoesNotAffectTheRestOfRows() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpBox(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        outerLoop:
        for (int x=0; x<3; x++) { // first 3 rows
            for(int y=3; y<9; y++){ // columns 3 -> 9
                shouldBeTrue = grid.getCell(x, y).getPossibleCandidates().contains(value);
            

                if (!shouldBeTrue) {
                    // shouldBeTrue = false
                    // candidate was removed so test should fail
                    break outerLoop;
                }
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpBoxDoesNotAffectTheRestOfColumns() {
        Cell cell = this.grid.getCell(0, 1);
        cleanUp.cleanUpBox(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        outerLoop:
        for (int x=3; x<9; x++) { // Rows 3 -> 9
            for(int y=0; y<3; y++){ // columns 1 -> 3
                shouldBeTrue = grid.getCell(x, y).getPossibleCandidates().contains(value);
            

                if (!shouldBeTrue) {
                    // shouldBeTrue = false
                    // candidate was removed so test should fail
                    break outerLoop;
                }
            }
        }

        assertTrue(shouldBeTrue);
    }
}