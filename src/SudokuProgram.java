import java.util.ArrayList;

/**
 * Main program that runs the input, output, and sudoku solving
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-26.
 */
public class SudokuProgram {
    public static void main(String[] args){
        Input input = new Input();
        ArrayList<int[][]> test = (ArrayList<int[][]>)input.get();
        //do i need a check?

        /*for(int[][] i: test){
            for(int x = 0; x < 9; ++x)
                for(int y = 0; y< 9; ++y)
                    System.out.println(i[x][y]);
        }*/
    }// end main
}// end SudokuProgram
