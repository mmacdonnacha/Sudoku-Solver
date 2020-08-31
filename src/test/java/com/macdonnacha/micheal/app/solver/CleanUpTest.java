package com.macdonnacha.micheal.app.solver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.macdonnacha.micheal.app.sudoku.Grid;
import com.macdonnacha.micheal.app.sudoku.Cell;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CleanUpTest {
    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid("020000000000000000000000000000000000000000000000000000000000000000000000000000000");
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
        CleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for (Cell c : this.grid.getRow(cell)) {

            if (c != cell) {
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            if (shouldBeFalse) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertFalse(shouldBeFalse);
    }

    @Test
    public void removalOfCandidatesFromColumn() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for (Cell c : this.grid.getColumn(cell)) {

            if (c != cell) {
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            if (shouldBeFalse) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertFalse(shouldBeFalse);
    }

    @Test
    public void removalOfCandidatesFromSquare() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpSquare(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeFalse = false;

        for (Cell c : this.grid.getSquare(cell)) {

            if (c != cell) {
                shouldBeFalse = c.getPossibleCandidates().contains(value);
            }

            if (shouldBeFalse) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertFalse(shouldBeFalse);
    }

    @Test
    public void cleanUpRowDoesNotAffectTheColumn() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getColumn(cell)) {

            if (c != cell) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpRowDoesNotAffectTheRestOfQuadrant() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpRow(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getSquare(cell)) {

            boolean cellsInRow = (c.getX() == 0 && (c.getY() == 0 || c.getY() == 1 || c.getY() == 2));
            if (!cellsInRow) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpColumnDoesNotAffectTheRestOfRow() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getRow(cell)) {

            if (c != cell) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpColumnDoesNotAffectTheRestOfQuadrant() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpColumn(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        for (Cell c : this.grid.getSquare(cell)) {

            boolean cellsInColumn = (c.getY() == 1 && (c.getX() == 0 || c.getX() == 1 || c.getX() == 2));
            if (!cellsInColumn) {
                shouldBeTrue = c.getPossibleCandidates().contains(value);
            }

            if (!shouldBeTrue) {
                // candidate was not removed so test should fail
                break;
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpSquareDoesNotAffectTheRestOfRows() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpSquare(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        outerLoop:
        for (int x=0; x<3; x++) { // first 3 rows
            for(int y=3; y<9; y++){ // columns 3 -> 9
                shouldBeTrue = grid.getCell(x, y).getPossibleCandidates().contains(value);
            

                if (!shouldBeTrue) {
                    // candidate was not removed so test should fail
                    break outerLoop;
                }
            }
        }

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cleanUpSquareDoesNotAffectTheRestOfColumns() {
        Cell cell = this.grid.getCell(0, 1);
        CleanUp.cleanUpSquare(grid, cell);

        String value = Integer.toString(cell.value());
        boolean shouldBeTrue = true;

        outerLoop:
        for (int x=3; x<9; x++) { // Rows 3 -> 9
            for(int y=0; y<3; y++){ // columns 1 -> 3
                shouldBeTrue = grid.getCell(x, y).getPossibleCandidates().contains(value);
            

                if (!shouldBeTrue) {
                    // candidate was not removed so test should fail
                    break outerLoop;
                }
            }
        }

        assertTrue(shouldBeTrue);
    }
}