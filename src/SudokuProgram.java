/**
 * Main program that runs the input, output, and sudoku solving
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-26.
 */
import java.util.ArrayList;

public class SudokuProgram {
    public static void main(String[] args){
        SudokuParser parser = new SudokuParser();

        if(parser.parse()){
            ArrayList<int[][]> puzzleList = parser.get();
            if(puzzleList == null)
                System.out.println("Error with input file.");
            else{
                //Output out = new Output(puzzleList);
                //test case before output
                for(int[][] sol: puzzleList){
                    for(int i = 0; i < 9; ++i){
                        for(int j = 0; j < 9; ++j){
                            System.out.print(sol[i][j]);
                        }
                        System.out.println();
                    }
                }
                System.out.println("Solutions outputted in to \"solutions.txt\"");
            }
        }
        else
            System.out.println("Missing input file.");
    }// end main
}// end SudokuProgram
