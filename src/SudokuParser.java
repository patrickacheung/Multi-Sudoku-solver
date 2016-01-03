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
        parse();
    }

    /**
     * Parses text file and returns a list of puzzles
     */
    private void parse(){
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            String s;
            //Pending
        } catch(IOException e){
            e.printStackTrace();
        }
    }//end parse

    /**
     * Retruns an arraylist of sudoku puzzles
     * @return an arraylist of sudoku puzzles
     */
    public ArrayList<int[][]> get(){
        return sudokuList;
    }//end get
}// end SudokuParser
