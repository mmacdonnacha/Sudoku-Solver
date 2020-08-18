package com.macdonnacha.micheal.app;

import com.macdonnacha.micheal.app.sudoku.Grid;
import com.macdonnacha.micheal.app.sudoku.Cell;

import com.macdonnacha.micheal.app.solver.*;

public class App 
{
    public static void main( String[] args )
    {
        String numbers = "006481300020000040700000009800090004600342001500060002300000005090000070005716200";
        Grid g = new Grid(numbers);
        System.out.println(g);
        System.out.println(numbers);
        System.out.println("\n\n" + g.solutionAsSingleLine());


        System.out.println(g.getCell(0, 2));
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(g.getCell(0, 0));
        // removingUniqueValuesFromRow(g);
    }



    // public static void removingUniqueValuesFromRow(Grid g){
    //     Cell cell = g.getCell(0, 2);
    //     CleanUp.cleanUpRow(g, cell);
    //     Cell cell2 = g.getCell(0, 0);
    //     int value = cell.value();

    //    boolean val = cell2.getPossibleCandidates().contains("" + value);
    //    System.out.println("Val: " + val + "\n");
    //    System.out.println(cell2.getPossibleCandidates());
    //    }
    
}
