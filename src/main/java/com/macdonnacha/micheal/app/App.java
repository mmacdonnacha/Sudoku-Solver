package com.macdonnacha.micheal.app;

import com.macdonnacha.micheal.app.sudoku.Grid;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String numbers = "006481300020000040700000009800090004600342001500060002300000005090000070005716200";
        Grid g = new Grid(numbers);
        System.out.println(g);
        System.out.println(numbers);
        System.out.println("\n\n" + g.solutionAsSingleLine());
    }
}
