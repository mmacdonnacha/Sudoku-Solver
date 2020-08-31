package com.macdonnacha.app;

import com.macdonnacha.app.sudoku.Grid;
import com.macdonnacha.app.solver.Solver;

public class App {
    public static void main(String[] args) {
        String[] numbers = {
            "006481300020000040700000009800090004600342001500060002300000005090000070005716200",
            "008571900000403000100090008810000025304000601520000073200050004000704000001932500",
            "002000400090405070300090006040701020005000800060908050700010002030204010001000500"
        };

        String[] solutions = {
            "956481327123679548748253619832195764679342851514867932367924185291538476485716293",
            "438571962962483157157296348819367425374825691526149873293658714685714239741932586",
            "172386495698425371354197286843751629915642837267938154786513942539264718421879563"
        };
        
        Grid g;
        
        for(int i=0; i<numbers.length; i++){
            g = new Grid(numbers[i]);
            Solver solver = new Solver(g);
            solver.solve();
            if(g.solutionAsSingleLine().equals(solutions[i]))
                System.out.println("Sudoku " + i + " solved.");
            else{
                System.out.println("Sudoku " + i + " not solved.");
                System.out.println(g.solutionAsSingleLine());
                System.out.println(solutions[i]);
                System.out.println(g);
            }
        }
        
        // System.out.println(g);

        // System.out.println(g.fullGridInfo());

        
        // System.out.println("\n" + g.fullGridInfo());
        // System.out.println(g);
    }
}