/**
 * Parses Sudoku puzzles from a text file and returns a list of Sudoku puzzles to be solved
 * @author Patrick Cheung
 * @version 1.1.2
 * Created by patch on 2015-12-31.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuParser {
    private final int sudokuSize = 9;
    private ArrayList<int[][]> sudokuList;
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
            int count = sudokuSize; // max row of column size of sudoku puzzle
            sudokuList = new ArrayList<int[][]>();
            String rowString = "";
            String read;

            while((read = in.readLine()) != null)
            {
                if(count != 0){
                    rowString += read; //add each character read to string
                    count--; //decrease count to scan through a single row of the puzzle
                }
                else{
                    push(rowString);
                    //reset and scan next puzzle
                    rowString = "";
                    count = sudokuSize;
                }
            }
            //if it cant successfully parse then failToParse = SOMETHING and return false
            //failToParse = "ERROR";
            return true;
        } catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }//end parse

    /**
     * Converts string to int and pushes digits into puzzle list
     * @param s text to be pushed into puzzle list
     */
    private void push(String s){
        int[][] temp = new int[sudokuSize][sudokuSize];
        String stringRow = "";

        //iterate through the entire puzzle
        for(int i = 1, row = 0; i <= s.length(); ++i){
            //obtain 9 digits
            if((i % (sudokuSize + 1)) != 0) {
                stringRow += s.charAt(i - 1);
            }
            else{
                //insert the 9 digits into a 2D 9x9 int array aka "the sudoku grid"
                for (int k = 0; k < sudokuSize; ++k) {
                    temp[row][k] = Integer.parseInt(Character.toString(stringRow.charAt(k)));
                }
                stringRow = ""; //reset the row
                ++row; //iterate to next row
            }
        }
        sudokuList.add(temp);
    }//end push

    /**
     * Returns an arraylist of sudoku puzzles
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
