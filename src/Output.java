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
    private ArrayList<int[][]> sol;

    //constructor
    public Output(ArrayList<int[][]> sol){
        fileName = "solutions.txt";
        this.sol = sol;
    }
/*
    // TODO:
            //test the solutions
            for(int[][] sol: solList){
        if(sol.length == 0)
            System.out.println("No solution exists.\n");
        else{
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    */
    /**
     *
     */
    public void out(){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){

        } catch(IOException e){
            e.getMessage();
        }
    }// end out
}// end Output
