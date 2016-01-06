/**
 * Parses Sudoku puzzles from a text file and returns a list of Sudoku puzzles to be solved
 * @author Patrick Cheung
 * @version 1.3.1
 * Created by patch on 2015-12-31.
 */
import org.apache.commons.lang3.math.NumberUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

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
     * @return true if puzzles were parsed successfully
     */
    public boolean parse(){
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))){
            int count = sudokuSize; // max row of column size of sudoku puzzle
            sudokuList = new ArrayList<int[][]>();
            String stringPuzzle = ""; //stores sudoku puzzle as one string
            String read; //input from text file
            int linesRead = 0;

            while((read = in.readLine()) != null)
            {
                ++linesRead;
                if(count != 0){
                    stringPuzzle += read; //add each character read to string

                    //if not a digit or empty file throw exception
                    if(!NumberUtils.isDigits(stringPuzzle))
                        throw new DataFormatException("Illegal characters in " + fileName);

                    --count; //decrease count to scan through a single row of the puzzle
                }
                else{
                    push(stringPuzzle);
                    //reset and scan next puzzle
                    stringPuzzle = "";
                    count = sudokuSize;
                }
            }
            if(linesRead == 0)
                throw new DataFormatException(fileName + " is empty");
        } catch(IOException | DataFormatException e){
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }//end parse

    /**
     * Converts string to int and rearranges to sudoku puzzle format
     * Formatted puzzle is pushed into puzzle list
     * @param s text to be pushed into puzzle list
     */
    private void push(String s){
        int[][] puzzle = new int[sudokuSize][sudokuSize];

        //break single line puzzle into 9 substrings(rows)
        for(int row = 0, multi = 2, start = 0, end = sudokuSize; row < sudokuSize; ++row, ++multi){
            String substringRow = s.substring(start, end);
            start = end;
            end = sudokuSize * multi;

            //fill row with digits
            for(int i = 0; i < sudokuSize; ++i){
                puzzle[row][i] = Integer.parseInt(Character.toString(substringRow.charAt(i)));
            }
        }
        //print to check
        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
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
