package com.sudokusolver.app.solver.level1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.sudokusolver.app.sudoku.Grid;
import com.sudokusolver.app.sudoku.Cell;
import com.sudokusolver.app.solver.Solver;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class NakedPairTest {
    
    private Grid grid1, grid2;
    private Solver solver1, solver2;
    private NakedPair nakedPair;

    @Before
    public void setUp() {
        grid1 = new Grid("008571930000403000100090008810000025304000601520000073200050004000704000001932500", true);
        grid2 = new Grid("002000430090405070300090006040701020005000800060908050700010002030204010001000500", true);
        solver1 = new Solver(grid1);
        solver2 = new Solver(grid2);
        nakedPair = new NakedPair(true);

        solver1.cleanUpGrid();
        solver2.cleanUpGrid();

    }

    @After
    public void tearDown() {
        grid1 = null;
        grid2 = null;
        solver1 = null;
        solver2 = null;
        nakedPair = null;
    }

    @Test
    public void rowOneContainsANakedPair(){
        Cell cell = grid1.getCell(0, 0);
        boolean shouldBeTrue = this.nakedPair.hasNakedPairRow(grid1, cell);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void rowFiveDoesNotContainANakedPair(){
        Cell cell = grid1.getCell(4, 1);
        boolean shouldBeFalse = this.nakedPair.hasNakedPairRow(grid1, cell);

        assertFalse(shouldBeFalse);
    }

    

    @Test
    public void columnSevenContainsANakedPair(){
        Cell cell = grid2.getCell(1, 6);
        boolean shouldBeTrue = this.nakedPair.hasNakedPairColumn(grid2, cell);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void columnOneDoesNotContainANakedPair(){
        Cell cell = grid2.getCell(3, 0);
        boolean shouldBeFalse = this.nakedPair.hasNakedPairColumn(grid2, cell);

        assertFalse(shouldBeFalse);
    }

    @Test
    public void boxTwoContainsANakedPair(){
        Cell cell = grid2.getCell(1, 6);

        boolean shouldBeTrue = this.nakedPair.hasNakedPairBox(grid2, cell);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void boxOneDoesNotContainANakedPair(){
        Cell cell = grid2.getCell(2, 1);

        boolean shouldBeFalse = this.nakedPair.hasNakedPairBox(grid2, cell);

        assertTrue(shouldBeFalse);
    }


    @Test
    public void rowRemoveNakePairValues(){
        Cell cell = grid1.getCell(0, 0); // 4, 6
        nakedPair.setNakedPairRow(grid1, cell);

        boolean shouldBeFalse = grid1.getCell(0, 8).getPossibleCandidates().contains("4") 
                            || grid1.getCell(0, 8).getPossibleCandidates().contains("6");

        assertFalse(shouldBeFalse);
    }

    @Test
    public void columnRemoveNakePairValues(){
        Cell cell = grid2.getCell(1, 6); // 1, 2
        nakedPair.setNakedPairColumn(grid2, cell);

        boolean shouldBeFalse = grid2.getCell(5, 6).getPossibleCandidates().contains("1") 
                            || grid2.getCell(0, 8).getPossibleCandidates().contains("2");

        assertFalse(shouldBeFalse);
    }

    @Test
    public void boxRemoveNakePairValues(){
        Cell cell = grid2.getCell(1, 6); // 1, 2
        nakedPair.setNakedPairBox(grid2, cell);

        boolean shouldBeFalse = grid2.getCell(0, 8).getPossibleCandidates().contains("1") 
                            || grid2.getCell(1, 8).getPossibleCandidates().contains("1");

        assertFalse(shouldBeFalse);
    }

    

}