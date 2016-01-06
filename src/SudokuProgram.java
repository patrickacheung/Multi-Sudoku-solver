/**
 * Main program that runs the input, output, and sudoku solving
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-26.
 */
import java.util.ArrayList;

class SudokuProgram {
    public static void main(String[] args){
        final String F = "ERROR";
        SudokuParser parser = new SudokuParser();

        if(parser.parse()){
            ArrayList<int[][]> puzzleList = parser.get();
            //Output out = new Output(puzzleList);
            //test case before output
            for(int[][] sol: puzzleList){
                if(sol != null) {
                    for (int i = 0; i < 9; ++i) {
                        for (int j = 0; j < 9; ++j) {
                            System.out.print(sol[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
            System.out.println("Solutions outputted into \"solutions.txt\"");
        }
    }// end main
}// end SudokuProgram
