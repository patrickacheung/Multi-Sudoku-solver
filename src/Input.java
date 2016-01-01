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
        sudokuList = (ArrayList<E>)new SudokuParser(FNAME).get();
    }

    public Input(String fileName){
        sudokuList = (ArrayList<E>)new SudokuParser(fileName).get();
    }

    /**
     *
     * @return
     */
    public E get(){
        return (E)sudokuList;
    }
}// end Input
