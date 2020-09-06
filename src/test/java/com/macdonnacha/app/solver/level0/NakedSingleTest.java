package com.macdonnacha.app.solver.level0;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;
import com.macdonnacha.app.solver.Solver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class NakedSingleTest {
    private Grid grid;
    private Solver solver;
    private NakedSingle nakedSingle;

    @Before
    public void setUp() {
        grid = new Grid(
           "006481300020000040700000009800090004600342001500060002300000005090000070005716200");
        solver = new Solver(grid);
        nakedSingle = new NakedSingle();

    /*
        ++---+---+---++---+---+---++---+---+---++
        ||   |   | 6 || 4 | 8 | 1 || 3 |   |   ||
        ||   | 2 |   ||   |   |   ||   | 4 |   ||
        || 7 |   |   ||   |   |   ||   |   | 9 ||
        ++---+---+---++---+---+---++---+---+---++
        || 8 |   |   ||   | 9 |   ||   |   | 4 ||
        || 6 |   |   || 3 | 4 | 2 ||   |   | 1 ||
        || 5 |   |   ||   | 6 |   ||   |   | 2 ||
        ++---+---+---++---+---+---++---+---+---++
        || 3 |   |   ||   |   |   ||   |   | 5 ||
        ||   | 9 |   ||   |   |   ||   | 7 |   ||
        ||   |   | 5 || 7 | 1 | 6 || 2 |   |   ||
        ++---+---+---++---+---+---++---+---+---++
     */
    }

    @After
    public void tearDown() {
        grid = null;
    }

    @Test
    public void checkIfCellDoesNotHaveOneCandidate(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeFalse = this.nakedSingle.hasSingleCandidate(cell);

        assertFalse(shouldBeFalse);
    }

    @Test
    public void checkIfCellhasOnlyOneCandidate(){
        solver.cleanUpGrid();
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeTrue = this.nakedSingle.hasSingleCandidate(cell);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void setUniqueInCell(){
        solver.cleanUpGrid();
        Cell cell = this.grid.getCell(0, 0);
        this.nakedSingle.setSingleCandidateValue(cell);

        assertTrue(cell.isSolved());
    }

}