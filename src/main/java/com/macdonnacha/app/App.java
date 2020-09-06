package com.macdonnacha.app;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.solver.Solver;

public class App {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: sudoku-solver-1.0-SNAPSHOT <sudoku puzzle>");
        } else {

            Grid g = new Grid(args[1]);
            
            System.out.println("Initial state: \n" + g);
            Solver solver = new Solver(g);
            solver.solve();
            if (g.isSolved()) {
                System.out.println("\n\nCompleted state: \n" + g);
            } else {
                System.out.println("\n\nUnable to complete: \n" + g);
            }

        }
    }
}