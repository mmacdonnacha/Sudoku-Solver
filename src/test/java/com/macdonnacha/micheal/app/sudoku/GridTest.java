package com.macdonnacha.micheal.app.sudoku;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

}