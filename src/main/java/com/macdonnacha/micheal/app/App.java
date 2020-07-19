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
        Grid g = new Grid();
        System.out.println(g);
        System.out.println("\n\n" + g.solutionAsLine());
    }
}
