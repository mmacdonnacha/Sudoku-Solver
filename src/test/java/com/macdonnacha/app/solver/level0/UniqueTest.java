package com.macdonnacha.app.solver.level0;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.sudoku.Cell;
import com.macdonnacha.app.solver.Solver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class UniqueTest {
    private Grid grid;
    private Solver solver;
    private Unique unique;

    @Before
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

    @After
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