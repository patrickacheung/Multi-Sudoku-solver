/**
 *
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-27.
 */
import java.util.ArrayList;

public class Input<E> {
    private final String FNAME = "puzzles.txt";
    private ArrayList<E> sudokuList;
    private SudokuParser parser;

    //constructor
    public Input(){
        sudokuList = new parser(FNAME);
    }

    public Input(String fileName){
        sudokuList = new parser(fileName);
    }

    /**
     *
     * @return
     */
    public E get(){
        return (E)sudokuList;
    }
}// end Input
