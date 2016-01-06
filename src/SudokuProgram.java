/**
 * Main program that runs the input, output, and sudoku solving
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-26.
 */
import java.util.ArrayList;

class SudokuProgram {
    public static void main(String[] args){
        SudokuParser parser = new SudokuParser();

        if(parser.parse()) {
            ArrayList<int[][]> puzzleList = parser.get();
            ArrayList<int[][]> solList = new ArrayList<>();

            //loop through each puzzle and solve
            for(int[][] puzzle: puzzleList){
                SudokuSolver solver = new SudokuSolver();
                solver.solve(puzzle);
                solList.add(solver.get());
            }

            //Output out = new Output(solList);
            //out.out();
            System.out.println("Solutions outputted into \"solutions.txt\"");
        }
    }// end main
}// end SudokuProgram
