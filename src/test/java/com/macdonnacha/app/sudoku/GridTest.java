package com.macdonnacha.app.sudoku;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
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
    public void singleLineSolution(){
        assertEquals(grid.solutionAsSingleLine(), 
            "123456789123456789123456789123456789123456789123456789123456789123456789123456789");
    }

    @Test
    public void rowsAreLengthNine()
    {
        boolean isLengthNine = false;
        for(int i=0; i<9; i++){
            if(grid.getRow(i).length != 9){
                isLengthNine = false;
                break;
            }

            isLengthNine = true;

        }
       assertTrue(isLengthNine);
    }

    @Test
    public void columnsAreLengthNine()
    {
        boolean isLengthNine = false;
        for(int i=0; i<9; i++){
            if(grid.getColumn(i).length != 9){
                isLengthNine = false;
                break;
            }

            isLengthNine = true;

        }
       assertTrue(isLengthNine);
    }


    @Test
    public void QuadrantAreNineCells()
    {
        boolean isLengthNine = false;
        for(int i=0; i<9; i++){
            if(grid.getSquare(i).length != 9){
                isLengthNine = false;
                break;
            }

            isLengthNine = true;

        }
       assertTrue(isLengthNine);
    }


    @Test
    public void getRowReturnsCorrectCells(){
        Cell[] actualRow = {
            this.grid.getCell(0,0),
            this.grid.getCell(0,1),
            this.grid.getCell(0,2),
            this.grid.getCell(0,3),
            this.grid.getCell(0,4),
            this.grid.getCell(0,5),
            this.grid.getCell(0,6),
            this.grid.getCell(0,7),
            this.grid.getCell(0,8)
        };

        Cell[] expectedRow = this.grid.getRow(0);
        assertArrayEquals(expectedRow, actualRow);
    }

    @Test
    public void getColumnReturnsCorrectCells(){
        Cell[] actual = {
            this.grid.getCell(0,0),
            this.grid.getCell(1,0),
            this.grid.getCell(2,0),
            this.grid.getCell(3,0),
            this.grid.getCell(4,0),
            this.grid.getCell(5,0),
            this.grid.getCell(6,0),
            this.grid.getCell(7,0),
            this.grid.getCell(8,0)
        };

        Cell[] expected = this.grid.getColumn(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getSquareReturnsCorrectCells(){
        Cell[] actual = {
            this.grid.getCell(0,0), this.grid.getCell(0,1), this.grid.getCell(0,2),
            this.grid.getCell(1,0), this.grid.getCell(1,1), this.grid.getCell(1,2),
            this.grid.getCell(2,0), this.grid.getCell(2,1), this.grid.getCell(2,2)
        };

        Cell[] expected = this.grid.getSquare(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void isSolvedwithEmptyCells(){
        grid = new Grid("023456789123456789123456789123456789123456789123456789123456789123456789123456789");
    
        assertFalse(grid.isSolved());
    }

    @Test
    public void isSolved(){
        grid = new Grid("123456789123456789123456789123456789123456789123456789123456789123456789123456789");
    
        assertTrue(grid.isSolved());
    }

    @Test
    public void isSolvedwithWrongValue(){
        grid = new Grid("923456789123456789123456789123456789123456789123456789123456789123456789123456789");
    
        assertFalse(grid.isSolved());
    }
}