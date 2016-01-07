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
    private final int sudokuSize = 9;
    private String fileName;
    private ArrayList<int[][]> sol;

    //constructor
    public Output(ArrayList<int[][]> sol){
        fileName = "solutions.txt";
        this.sol = sol;
    }

    /**
     * Outputs solutions into text file
     */
    public void out(){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){
            for(int[][] sols: sol){
                if(sols.length == 0){
                    out.write("No solution exists.");
                    out.newLine();
                }
                else{
                    for (int i = 0; i < sudokuSize; ++i){
                        for (int j = 0; j < sudokuSize; ++j){
                            out.write(sols[i][j] + " ");
                        }
                        out.newLine();
                    }
                    out.newLine();
                }
            }
        } catch(IOException e){
            e.getMessage();
        }
    }// end out
}// end Output
