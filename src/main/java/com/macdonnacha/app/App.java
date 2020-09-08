package com.macdonnacha.app;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.solver.Solver;

public class App {
    public static void main(String[] args) {

        // true  : No printing every step to screen
        // false : Print every step to screen
        boolean silentFlag = false; 

        if(args.length == 1 && args[0].length() == 81){

            Grid g = new Grid(args[0], silentFlag);

            System.out.println("Initial state: \n" + g.fullGridInfo());
            Solver solver = new Solver(g);
            solver.solve();

            if (g.isSolved()) {
                System.out.println("\n\nCompleted state: \n" + g.fullGridInfo());
            } else {
                System.out.println("\n\nUnable to complete: \n" + g.fullGridInfo());
            }
        }else if(args.length == 2 && args[0].equals("-s") && args[1].length() == 81){
            silentFlag = true;
            Grid g = new Grid(args[1], silentFlag);

            System.out.println("Initial state: \n" + g);
            Solver solver = new Solver(g);
            solver.solve();

            if (g.isSolved()) {
                System.out.println("\n\nCompleted state: \n" + g);
            } else {
                System.out.println("\n\nUnable to complete: \n" + g);
            }
        } else {
            String output = "Usage: java -jar sudoku-solver-1.0-SNAPSHOT [-s] sudoku_puzzle\n"
                    + "\n\tsudoku_puzzle: the sudoku puzzle writen as a single line e.g 0020004300904050703000900060407010...\n" 
                    + "\n\t-s: silent mode, turn off printing of step by step details\n";
            System.out.println(output);
        }
    }
}