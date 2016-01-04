/**
 * Parses Sudoku puzzles from a text file and returns a list of Sudoku puzzles to be solved
 * @author Patrick Cheung
 * @version 1.1
 * Created by patch on 2015-12-31.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuParser {
    private final ArrayList<int[][]> sudokuList;
    private final String fileName;
    private String failToParse;

    //constructor
    public SudokuParser(){
        sudokuList = null;
        failToParse = null;
        fileName = "puzzles.txt";
    }

    public SudokuParser(String fileName){
        sudokuList = null;
        failToParse = null;
        this.fileName = fileName;
    }

    /**
     * Parses text file and returns and fills arraylist of list of puzzles
     * @return true if parse was successful and false if it was not
     */
    public boolean parse(){
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            String s;
            //Pending
            //if it cant successfully parse then failToParse = SOMETHING and return false
            return true;
        } catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }//end parse

    /**
     * Retruns an arraylist of sudoku puzzles
     * @return an arraylist of sudoku puzzles if parse was successful, else returns a null arraylist
     */
    public ArrayList<int[][]> get(){
        return sudokuList;
    }//end get

    /**
     * Returns reason for parsing failure as a String
     * @return string text of failure reason or a null string if parse was successful
     */
    public String fail(){
        return failToParse;
    }//end fail
}// end SudokuParser
