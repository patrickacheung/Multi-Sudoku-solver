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

        if(parser.parse()){
            ArrayList<int[][]> puzzleList = parser.get();
            ArrayList<int[][]> solList = new ArrayList<>();

            //loop through each puzzle and solve
            for(int[][] puzzle: puzzleList){
                SudokuSolver solver = new SudokuSolver();
                solList.add(solver.get(puzzle));
            }

            /**
             * Testing purposes only
             */
            //test the solutions
            for(int[][] sol: solList){
                if(sol.length == 0)
                    System.out.println("No solution exists.\n");
                else{
                    for (int i = 0; i < 9; ++i) {
                        for (int j = 0; j < 9; ++j) {
                            System.out.print(sol[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }

            //output solutions
            Output out = new Output(solList);
            out.out();
            System.out.println("Solutions outputted into \"solutions.txt\"");
        }
    }// end main
}// end SudokuProgram
