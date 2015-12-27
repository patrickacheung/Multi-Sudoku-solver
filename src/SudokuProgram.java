/**
 * Main program that runs the input, output, and sudoku solving
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-26.
 */
public class SudokuProgram {
    public static void main(String[] args){
        //0 means empty cell
        int[][] grid = {{8, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 3, 6, 0, 0, 0, 0, 0},
                        {0, 7, 0, 0, 9, 0, 2, 0, 0},
                        {0, 5, 0, 0, 0, 7, 0, 0, 0},
                        {0, 0, 0, 0, 4, 5, 7, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 3, 0},
                        {0, 0, 1, 0, 0, 0, 0, 6, 8},
                        {0, 0, 8, 5, 0, 0, 0, 1, 0},
                        {0, 9, 0, 0, 0, 0, 4, 0, 0}};

        SudokuSolver solve = new SudokuSolver();

        if(solve.solveSudoku(grid))
            solve.printSolution();
        else
            System.out.println("No Solution Exists.");
    }// end main
}// end SudokuProgram
