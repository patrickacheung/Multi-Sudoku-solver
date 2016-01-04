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
    private final int sudokuSize = 9;
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
            int count = sudokuSize;
            String temp = "";
            String read;

            while((read = in.readLine()) != null)
            {
                if(count != 0){
                    temp += read;
                    count--;
                }
                else{
                    push(temp);
                    temp = "";
                    count = 9;
                }
            }
            //if it cant successfully parse then failToParse = SOMETHING and return false
            //failToParse = "ERROR";
            return false;
        } catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }//end parse

    /**
     * Converts string to int and pushes digits into puzzle list
     * @param s text to be pushed into puzzle list
     */
    private void push(String s){

    }//end push

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
