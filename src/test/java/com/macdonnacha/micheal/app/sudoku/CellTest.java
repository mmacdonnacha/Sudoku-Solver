package com.macdonnacha.micheal.app.sudoku;


import junit.framework.TestCase;

public class CellTest extends TestCase {
    private Cell c;

    protected void setUp() {
        c = new Cell(1,6);
    }

   
    public void testXCoordintate()
    {
        assertEquals(c.getX(), 1);
    }


    public void testYCoordintate()
    {
        assertEquals(c.getY(), 6);
    }


    public void testValueFail() {
        assertFalse(c.value() == 8);
        
    }


    public void testValueTest()
    {
        c.setValue(8);
        assertEquals(c.value() , 8);
    }
}