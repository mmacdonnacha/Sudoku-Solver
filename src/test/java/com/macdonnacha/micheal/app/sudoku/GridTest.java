package com.macdonnacha.micheal.app.sudoku;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class GridTest {
    private Grid grid;

    @Before
    public void setUp() {
       grid = new Grid("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
    }

    @After
    public void tearDown() {
        grid = null;
    }

    @Test
    public void gridRowIsLengthNine(){
        assertEquals(grid.solutionAsSingleLine(), 
            "123456789123456789123456789123456789123456789123456789123456789123456789123456789");
    }

    @Test
    public void rowIsLengthNine()
    {
        Cell[] row = grid.getRow(0);
        assertEquals(row.length, 9);
    }

    @Test
    public void columnIsLengthNine()
    {
        Cell[] column = grid.getColumn(0);
        assertEquals(column.length, 9);
    }


    // @Test
    // public void yCoordintate()
    // {
    //     Cell c = new Cell(1,6);
    //     assertEquals(c.getY(), 6);
    // }
}