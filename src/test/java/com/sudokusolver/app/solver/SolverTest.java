package com.sudokusolver.app.solver;

import com.sudokusolver.app.sudoku.Grid;
import com.sudokusolver.app.sudoku.Cell;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolverTest {
    private Grid[] grid;
    private Solver solver;


    @BeforeEach
    public void setUp() {
        grid = new Grid[]{
            new Grid("006481300020000040700000009800090004600342001500060002300000005090000070005716200", true),
            new Grid("008571900000403000100090008810000025304000601520000073200050004000704000001932500", true)
        };
        
    }

    @AfterEach
    public void tearDown() {
        grid = null;
    }

    @Test
    public void cleanupShouldNotChangeValues(){
        String answer = "006481300020000040700000009800090004600342001500060002300000005090000070005716200";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void nakedSingleTest(){
        String answer = "956481327120000040700000009800090004679342001500060002300020005090000070485716203";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();

        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = this.grid[0].getCell(row, col);
                solver.setNakedSingle(cell);
            }
        }
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void uniqueTest(){
        String answer = "906481327020070040700000009802090004600342001500060002367000005291000070485716293";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = this.grid[0].getCell(row, col);
                solver.setUnique(cell);
            }
        }
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void cleanupShouldNotChangeValues2(){
        String answer = "008571900000403000100090008810000025304000601520000073200050004000704000001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void nakedSingleTest2(){
        String answer = "008571900000403000100096008810000425304000601520000873200058004000704000001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();

        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = this.grid[1].getCell(row, col);
                solver.setNakedSingle(cell);
            }
        }
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void uniqueTest2(){
        String answer = "008571902000483000100296008810300025304025691520000873200058004000704209001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                Cell cell = this.grid[1].getCell(row, col);
                solver.setUnique(cell);
            }
        }
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void level0StrategiesTest(){
        String answer = "956481327120070040700000009802090004679342001500060002367020005291000070485716293";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        solver.level0Strategies();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void level0StrategiesTest2(){
        String answer = "008571902000483000100296008810300425304825691520049873200058004000714209001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        solver.level0Strategies();
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void solveTest(){
        String answer = "956481327123679548748253619832195764679342851514867932367924185291538476485716293";
        solver = new Solver(grid[0]);
        solver.solve();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void solveTest2(){
        String answer = "438571962962483157157296348819367425374825691526149873293658714685714239741932586";
        solver = new Solver(grid[1]);
        solver.solve();        
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

}