package com.sudokusolver.app.solver.level0;

import com.sudokusolver.app.sudoku.Grid;
import com.sudokusolver.app.sudoku.Cell;
import com.sudokusolver.app.solver.Solver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class NakedSingleTest {
    private Grid grid;
    private Solver solver;
    private NakedSingle nakedSingle;

    @BeforeEach
    public void setUp() {
        grid = new Grid(
           "006481300020000040700000009800090004600342001500060002300000005090000070005716200", true);
        solver = new Solver(grid);
        nakedSingle = new NakedSingle(grid.getSilentFlag());

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

    @AfterEach
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