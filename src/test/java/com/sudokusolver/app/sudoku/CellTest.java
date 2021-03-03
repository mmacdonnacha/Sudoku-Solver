package com.sudokusolver.app.sudoku;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CellTest {
    private Cell c;

    @BeforeEach
    public void setUp() {
        c = new Cell(1,6);
    }

    @AfterEach
    public void tearDown() {
        c = null;
    }


   @Test
   @DisplayName("Given Cell(1, 6) - X coordinate value is 1")
    public void xCoordintateIsOne()
    {
        assertEquals(c.getX(), 1);
    }


    @Test
    @DisplayName("Given Cell(1, 6) - Y coordinate value is 6")
    public void yCoordintateIsSix()
    {
        assertEquals(c.getY(), 6);
    }


    @Test
    @DisplayName("Given Cell(1, 6) - X coordinate value is not 2")
    public void xCoordintateIsNotTwo()
    {
        assertNotEquals(c.getX(), 2);
    }


    @Test
    @DisplayName("Given Cell(1, 6) - Y coordinate value is not 8")
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
    @DisplayName("Check value 8 is assigned to value")
    public void testValue()
    {
        c.setValue(8);
        assertEquals(c.value() , 8);
    }

    @Test
    @DisplayName("Check value 0 is assigned to value")
    public void testSetValueZero(){
        c.setValue(0);
        assertEquals(c.value(), 0);
    }

    @Test
    @DisplayName("If value is 0 candidates should be \"1, 2, 3, 4, 5, 6, 7, 8, 9\"")
    public void testSetValueZeroCandidates(){
        c.setValue(0);
        assertEquals(c.getPossibleCandidates(), "1, 2, 3, 4, 5, 6, 7, 8, 9");
    }


    @Test
    @DisplayName("Cell is not solved - multiple candidates")
    public void doesNotHaveSingleCandidate(){
        assertFalse(c.isSolved());
    }


    @Test
    @DisplayName("Cell is solved - single candidate")
    public void hasSingleCandidate(){
        c.setValue(5);
        assertTrue(c.isSolved());
    }

    @Test
    @DisplayName("Given Cell(1, 6) - not in top row left quadrant")
    public void isNotInQuadrantOne(){
        assertNotEquals(c.getQuadrant(), 0);
    }

    @Test
    @DisplayName("Given Cell(1, 1) - is in top row left quadrant")
    public void isInQuadrantZero(){
        Cell c = new Cell(1, 1);
        assertEquals(c.getQuadrant(), 0);
    }

    @Test
    @DisplayName("Given Cell(1, 4) - is in top row middle quadrant")
    public void isInQuadrantOne(){
        Cell c = new Cell(1, 4);
        assertEquals(c.getQuadrant(), 1);
    }

    @Test
    @DisplayName("Given Cell(1, 7) - is in top row right quadrant")
    public void isInQuadrantTwo(){
        Cell c = new Cell(1, 7);
        assertEquals(c.getQuadrant(), 2);
    }

    @Test
    @DisplayName("Given Cell(4, 1) - is in middle row left quadrant")
    public void isInQuadrantThree(){
        Cell c = new Cell(4, 1);
        assertEquals(c.getQuadrant(), 3);
    }

    @Test
    @DisplayName("Given Cell(4, 4) - is in middle row middle quadrant")
    public void isInQuadrantFour(){
        Cell c = new Cell(4, 4);
        assertEquals(c.getQuadrant(), 4);
    }

    @Test
    @DisplayName("Given Cell(4, 7) - is in middle row right quadrant")
    public void isInQuadrantFive(){
        Cell c = new Cell(4, 7);
        assertEquals(c.getQuadrant(), 5);
    }

    @Test
    @DisplayName("Given Cell(7, 1) - is bottom row left quadrant")
    public void isInQuadrantSix(){
        Cell c = new Cell(7, 1);
        assertEquals(c.getQuadrant(), 6);
    }

    @Test
    @DisplayName("Given Cell(7, 4) - is bottom row middle quadrant")
    public void isInQuadrantSeven(){
        Cell c = new Cell(7, 4);
        assertEquals(c.getQuadrant(), 7);
    }

    @Test
    @DisplayName("Given Cell(7, 7) - is bottom row right quadrant")
    public void isInQuadrantEight(){
        Cell c = new Cell(7, 7);
        assertEquals(c.getQuadrant(), 8);
    }

    @Test
    @DisplayName("Given Cell(2, 3) - getCoordinates returns (2, 3)")
    public void testGetCoordinates(){
        Cell c = new Cell(2, 3);
        String actual = "(2, 3)";

        assertEquals(c.coordinates(), actual);
    }

    @Test
    @DisplayName("Testing toString method")
    public void  testToString(){
        String expected = "(1, 6), [1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String actual = c.toString();

        assertEquals(expected, actual);
    }
}