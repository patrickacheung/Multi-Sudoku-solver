/**
 * Parses Sudoku puzzles from a text file and returns a list of Sudoku puzzles to be solved
 * @author Patrick Cheung
 * @version 1.1.1
 * Created by patch on 2015-12-31.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class SudokuParser {
    private final int sudokuSize = 9;
    private final String fileName;
    private ArrayList<int[][]> sudokuList;

    //constructor
    public SudokuParser(){
        sudokuList = null;
        fileName = "puzzles.txt";
    }

    /**
     * Parses text file and converts text into sudoku puzzles
     * @return true if parse was successful and false if it was not
     */
    public boolean parse(){
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            int count = sudokuSize; // max row of column size of sudoku puzzle
            sudokuList = new ArrayList<int[][]>();
            String stringPuzzle = ""; //stores sudoku puzzle as one string
            String read; //input from text file

            while((read = in.readLine()) != null)
            {
                //if not digit or newline return false
                //if it cant successfully parse then failToParse = SOMETHING and return false
                //failToParse = "ERROR";
                if(count != 0){
                    stringPuzzle += read; //add each character read to string
                    count--; //decrease count to scan through a single row of the puzzle
                }
                else{
                    push(stringPuzzle);
                    //reset and scan next puzzle
                    stringPuzzle = "";
                    count = sudokuSize;
                }
            }
            return true;
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }//end parse

    /**
     * Converts string to int and rearranges to sudoku puzzle format
     * Formatted puzzle is pushed into puzzle list
     * @param s text to be pushed into puzzle list
     */
    private void push(String s){
        int[][] puzzle = new int[sudokuSize][sudokuSize];
        String stringRow = "";

        //iterate through the entire puzzle
        for(int i = 1, row = 0; i <= s.length(); ++i){
            //obtain 9 digits
            if((i % (sudokuSize + 1)) != 0){
                stringRow += s.charAt(i - 1);
            }
            else{
                //insert the 9 digits into a 2D 9x9 int array aka "the sudoku grid"
                for (int k = 0; k < sudokuSize; ++k){
                    puzzle[row][k] = Integer.parseInt(Character.toString(stringRow.charAt(k)));
                }
                stringRow = ""; //reset the row
                ++row; //iterate to next row
            }
        }
        sudokuList.add(puzzle);
    }//end push

    /**
     * Returns an arraylist of sudoku puzzles
     * @return an arraylist of sudoku puzzles if parse was successful, else returns a null arraylist
     */
    public ArrayList<int[][]> get(){
        return sudokuList;
    }//end get
}// end SudokuParser
