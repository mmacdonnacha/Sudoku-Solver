package com.macdonnacha.micheal.app.sudoku;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CellTest {
    private Cell c;

    @Before
    public void setUp() {
        c = new Cell(1,6);
    }

    @After
    public void tearDown() {
        c = null;
    }


   @Test
    public void xCoordintateIsOne()
    {
        assertEquals(c.getX(), 1);
    }


    @Test
    public void yCoordintateIsSix()
    {
        assertEquals(c.getY(), 6);
    }


    @Test
    public void xCoordintateIsNotTwo()
    {
        assertNotEquals(c.getX(), 2);
    }


    @Test
    public void yCoordintateIsNotEight()
    {
        assertNotEquals(c.getY(), 8);
    }


    @Test
    public void testValueFail() {
        boolean shouldBeFalse = c.value() == 8;
        assertFalse(shouldBeFalse);
        
    }


    @Test
    public void testValue()
    {
        c.setValue(8);
        assertEquals(c.value() , 8);
    }


    @Test
    public void doesNotHaveSingleCandidate(){
        assertFalse(c.isSolved());
    }


    @Test
    public void hasSingleCandidate(){
        c.setValue(5);
        assertTrue(c.isSolved());
    }
}