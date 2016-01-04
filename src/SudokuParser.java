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
    private final ArrayList<int[][]> sudokuList;
    private final String fileName;

    //constructor
    public SudokuParser(){
        sudokuList = null;
        fileName = "puzzles.txt";
    }

    public SudokuParser(String fileName){
        sudokuList = null;
        this.fileName = fileName;
    }

    /**
     *
     * @return
     */
    public boolean parse(){
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            String s;
            //Pending
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
}// end SudokuParser
