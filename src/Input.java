/**
 *
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-27.
 */
import java.util.ArrayList;

public class Input<E> {
    private final String FNAME = "puzzles.txt";
    private String fileName;
    private ArrayList<E> sudokuList;
    private SudokuParser parser;

    //constructor
    public Input(){
        sudokuList = null;
        parser = null;
        fileName = FNAME;
        run();
    }

    public Input(String fileName){
        sudokuList = null;
        parser = null;
        this.fileName = fileName;
        run();
    }

    /**
     *
     */
    private void run(){
        sudokuList = (ArrayList<E>)new SudokuParser(fileName).get();
    }//end run

    /**
     *
     * @return
     */
    public E get(){
        return (E)sudokuList;
    }//end get
}// end Input
