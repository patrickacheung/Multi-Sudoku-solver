/**
 * Outputs puzzles into the text file "solutions.txt"
 * @author Patrick Cheung
 * @version 1.0
 * Created by patch on 2015-12-27.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Output {
    private String fileName;

    //constructor
    public Output(ArrayList<int[][]> sol){
        fileName = "solutions.txt";
    }

    /**
     *
     */
    public void out(){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){

        } catch(IOException e){
            e.getMessage();
        }
    }//end out
}// end Output
