/**
 * A standard sudoku solver using recursive backtracking
 * @author Patrick Cheung
 * @version 2.5
 * Created by patch on 2015-12-26.
 */
class SudokuSolver {
    private final int N; //standard sudoku grid of size NxN
    private final int E; //empty cell
    private int[][] sudokuGrid;

    //constructor
    public SudokuSolver(){
        N = 9; //9x9 grid
        E = 0; //0 means empty cell
    }// end SudokuSolver

    /**
     * Checks if number inserted appears twice in its 3x3 subgrid
     * @param grid - sudoku array to be evaluated
     * @param num - number to be inserted and evaluated
     * @param row - row where number will be inserted
     * @param col - col where number will be inserted
     * @return true if number doesn't appear twice in its 3x3 subgrid and false if it does
     */
    private boolean checkSubgrid(int[][] grid, int num, int row, int col){
        //mod 3 to determine the (0,0) coordinate of the subgrid
        row = row - (row % 3);
        col = col - (col % 3);

        //iterate and check entire subgrid for duplicate digit
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                if(grid[i + row][j + col] == num)
                    return false;
        return true;
    }// end checkSubgrid

    /**
     * Checks if number inserted appears twice in the same column
     * @param grid - sudoku array to be evaluated
     * @param num - number to be inserted and evaluated
     * @param col - col where number will be inserted
     * @return true if number doesn't appear twice in the same column and false if it does
     */
    private boolean checkCol(int[][] grid, int num, int col){
        //iterate and check entire column for duplicate digit
        for(int i = 0; i < N; ++i)
            if(grid[i][col] == num)
                return false;
        return true;
    }// end checkCol

    /**
     * Checks if number inserted appears twice in the same row
     * @param grid - sudoku array to be evaluated
     * @param num - number to be inserted and evaluated
     * @param row - row where number will be inserted
     * @return true if number doesn't appear twice in the same row and false if it does
     */
    private boolean checkRow(int[][] grid, int num, int row){
        //iterate and check entire row for duplicate digit
        for(int i = 0; i < N; ++i)
            if(grid[row][i] == num)
                return false;
        return true;
    }// end checkRow

    /**
     * Checks if number inserted does not appear twice in the same row, column, and subgrid according to standard
     * sudoku rules.
     * @param grid - sudoku array
     * @param num - number to be inserted
     * @param row - row where number will be inserted
     * @param col - column where number will be inserted
     * @return true if number does not appear twice in same row, column, and subgrid and false if it appears twice
     */
    private boolean isValid(int[][] grid, int num, int row, int col){
        return checkRow(grid, num, row) && checkCol(grid, num, col) && checkSubgrid(grid, num, row, col);
    }// end isValid

    /**
     * Searches the grid for an empty cell and updates the static row and col variables and true is returned.
     * If no empty cell exits, false is returned.
     * @param grid - sudoku grid to be evaluated
     * @param row - row index in 2D array
     * @param col - col index in 2D array
     * @return true if an empty cell is found and false if there are no empty cells
     */
    private boolean findEmptyCell(int[][] grid, Row row, Col col){
        //noinspection ConstantConditions
        for(row.rowIndex = 0; row.rowIndex < N; ++row.rowIndex)
            //noinspection ConstantConditions
            for (col.colIndex = 0; col.colIndex < N; ++col.colIndex)
                if (grid[row.rowIndex][col.colIndex] == E)
                    return true;
        return false;
    }// end findEmptyCell

    /**
     * Attempts to solve sudoku grid by finding an empty cell, tries a digit from 1-9 that is valid and attempts to
     * complete the rest of the grid recursively. Reverts changes if that digit is invalid and continuously cycles
     * through the digits until 1-9 fails for that cell.
     * @param grid - the array to be solved
     * @return true if puzzle is solvable and false if it is not
     */
    private boolean solvePuzzle(int[][] grid){
        sudokuGrid = grid.clone();
        Row r = new Row();
        Col c = new Col();

        //no empty cells mean the puzzle is already solved
        if(!findEmptyCell(sudokuGrid,r, c))
            return true; //solved

        //cycle through possible digits
        for(int tryNum = 1; tryNum <= N; ++tryNum){
            if(isValid(grid, tryNum, r.rowIndex, c.colIndex)){
                grid[r.rowIndex][c.colIndex] = tryNum;

                //if current tryNum works, try to recursively fill the rest
                if(solvePuzzle(sudokuGrid))
                    return true;

                //if it fails, rollback and set all previous filled to empty
                sudokuGrid[r.rowIndex][c.colIndex] = E;
            }
        }
        return false; //triggers backtracking (try next possible digit that would be valid)
    }// end solve

    /**
     * Function for printing grid
     */
    public void printSolution(){
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j) {
                System.out.print(sudokuGrid[i][j] + " ");
            }
            System.out.println();
        }
    }// end printSolution

    /**
     * Returns the solution to the sudoku puzzle if solvable and an empty puzzle if unsolvable
     * @param puzzle - puzzle to be solved
     * @return solved sudoku grid
     */
    public int[][] solve(int[][] puzzle){
        if(!solvePuzzle(puzzle))
            return new int[0][0];
        return sudokuGrid;
    }// end get

    //private inner classes
    /**
     * Row of sudoku grid for the sake of encapsulation
     */
    private class Row {
        public int rowIndex;
    }// end Row

    /**
     * Col of sudoku grid for the sake of encapsulation
     */
    private class Col {
        public int colIndex;
    }// end Col
}// end SudokuSolver
