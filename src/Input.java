/**
 * Passes text file to parser and returns an arraylist of objects
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-27.
 */
import java.util.ArrayList;

public class Input<E> {
    private String fileName;
    private ArrayList<E> list;
    private SudokuParser parser;

    //constructor
    public Input(){
        final String FNAME = "puzzles.txt";
        list = null;
        parser = null;
        fileName = FNAME;
        run();
    }

    public Input(String fileName){
        list = null;
        parser = null;
        this.fileName = fileName;
        run();
    }

    /**
     * Parses text file and returns an arraylist of objects
     */
    private void run(){
        //need to figure this out - there is potential error due to unchecked casting
        list = (ArrayList<E>)new SudokuParser(fileName).get();
    }//end run

    /**
     * Returns an arraylist of objects
     * @return arraylist of objects
     */
    public ArrayList<E> get(){
        return list;
    }//end get
}// end Input
