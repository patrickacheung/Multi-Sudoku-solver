/**
 * Parses Sudoku puzzles from a text file and returns a list of Sudoku puzzles to be solved
 * @author Patrick Cheung
 * @version 1.3.5
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
            String stringPuzzles = ""; //stores all of the puzzles in text file
            String read; //input from text file
            int linesRead = 0;
            sudokuList = new ArrayList<>();

            while((read = in.readLine()) != null){
                linesRead++;
                //special case where text file only has a new line
                if(read.length() == 0 && linesRead == 1)
                    throw new DataFormatException("Illegal characters in " + fileName);

                //exception for illegal characters: covers -> "" and non digits allows parse when
                //"" is occurred due to spacing between puzzles
                if(!NumberUtils.isDigits(read) && linesRead == 1)
                    throw new DataFormatException("Illegal characters in " + fileName);

                //add each line of puzzle from text file
                stringPuzzles += read;
            }
            if(linesRead == 0)
                throw new DataFormatException(fileName + " is empty");

            //break full puzzle set into individual puzzles
            for(int start = 0, end = 0, multi = 1; end < stringPuzzles.length(); ++multi){
                end = sudokuSize * sudokuSize * multi;
                String stringPuzzle = stringPuzzles.substring(start, end); //one puzzle in a single string
                push(stringPuzzle); //push into array, convert to "grid" format
                start = end; //switch to next puzzle
            }
            return true;
        } catch(IOException | DataFormatException e){
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
