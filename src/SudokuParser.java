/**
 *
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-31.
 */
import java.io.BufferedReader;
import java.util.ArrayList;

public class SudokuParser {
    private ArrayList<int[][]> sudokuList;
    private BufferedReader in;

    //constructor
    public SudokuParser(String fileName){
        sudokuList = null;
        in = null;
        parse();
    }

    private void parse(){

    }
}// end SudokuParser
