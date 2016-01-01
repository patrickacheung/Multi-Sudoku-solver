/**
 * Parses Sudoku puzzles from a text file and returns a list of Sudoku puzzles to be solved
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-31.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuParser {
    private ArrayList<int[][]> sudokuList;
    private String fileName;

    //constructor
    public SudokuParser(String fileName){
        sudokuList = null;
        this.fileName = fileName;
        //parse();
        test();
    }

    private void test(){
        int[][] grid = {{8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}};
        sudokuList.add(grid); //cannot add to null array right?
    }

    /**
     * Parses text file and returns a list of puzzles
     * @return a list of puzzles
     */
    private void parse(){
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            String s;
        } catch(IOException e){
            e.printStackTrace();
        }
    }//end parse

    /**
     *
     */
    public ArrayList<int[][]> get(){
        return (ArrayList<int[][]>)sudokuList.clone();
    }//end get
}// end SudokuParser
