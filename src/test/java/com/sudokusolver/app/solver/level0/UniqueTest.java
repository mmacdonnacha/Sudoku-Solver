package com.sudokusolver.app.solver.level0;

import com.sudokusolver.app.sudoku.Grid;
import com.sudokusolver.app.sudoku.Cell;
import com.sudokusolver.app.solver.Solver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class UniqueTest {
    private Grid grid;
    private Solver solver;
    private Unique unique;

    @BeforeEach
    public void setUp() {
        grid = new Grid(
           "000000000000100000000000100010000000000000000001000000000000000000000000001000000", true);
    /* 
        ++---+---+---++---+---+---++---+---+---++
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   || 1 |   |   ||   |   |   ||
        ||   |   |   ||   |   |   || 1 |   |   ||
        ++---+---+---++---+---+---++---+---+---++
        ||   | 1 |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ++---+---+---++---+---+---++---+---+---++
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ||   |   |   ||   |   |   ||   |   |   ||
        ++---+---+---++---+---+---++---+---+---++
     */
        solver = new Solver(grid);
        solver.cleanUpGrid();
        unique = new Unique(grid);
    }

    @AfterEach
    public void tearDown() {
        grid = null;
    }

    @Test
    public void cell00solutionIsTheNumberOneInRow(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeTrue = this.unique.uniqueCandidateInRow(cell) == 1 ? true : false;

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cell00solutionIsTheNumberOneInColumn(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeTrue = this.unique.uniqueCandidateInColumn(cell) == 1 ? true : false;

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cell00solutionIsTheNumberOneInBox(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeTrue = this.unique.uniqueCandidateInBox(cell) == 1 ? true : false;

        assertTrue(shouldBeTrue);
    }

    @Test
    public void cell00solutionIsNotTheNumberTwoInRow(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeFalse = this.unique.uniqueCandidateInRow(cell) == 2 ? true : false;

        assertFalse(shouldBeFalse);
    }

    @Test
    public void cell00solutionIsTheNumberTwoInColumn(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeFalse = this.unique.uniqueCandidateInColumn(cell) == 2 ? true : false;

        assertFalse(shouldBeFalse);
    }

    @Test
    public void cell00solutionIsTheNumberTwoInBox(){
        Cell cell = this.grid.getCell(0, 0);
        boolean shouldBeFalse = this.unique.uniqueCandidateInBox(cell) == 2 ? true : false;

        assertFalse(shouldBeFalse);
    }

}