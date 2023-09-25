import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }

        // create the list of sets for each row (this.rows)
        // ...
        Set<Integer> row1 = new HashSet<>();
        Set<Integer> row2 = new HashSet<>();
        Set<Integer> row3 = new HashSet<>();
        Set<Integer> row4 = new HashSet<>();
        Set<Integer> row5 = new HashSet<>();
        Set<Integer> row6 = new HashSet<>();
        Set<Integer> row7 = new HashSet<>();
        Set<Integer> row8 = new HashSet<>();
        Set<Integer> row9 = new HashSet<>();

        
        

        for (int i = 0; i < 9; i++){
            row1.add(this.grid[0][i]);
            row2.add(this.grid[1][i]);
            row3.add(this.grid[2][i]);
            row4.add(this.grid[3][i]);
            row5.add(this.grid[4][i]);
            row6.add(this.grid[5][i]);
            row7.add(this.grid[6][i]);
            row8.add(this.grid[7][i]);
            row9.add(this.grid[8][i]);
        }
        
        this.rows.add(row1);
        this.rows.add(row2);
        this.rows.add(row3);
        this.rows.add(row4);
        this.rows.add(row5);
        this.rows.add(row6);
        this.rows.add(row7);
        this.rows.add(row8);
        this.rows.add(row9);
        
        // create the list of sets for each col (this.cols)
        // ...

        Set<Integer> col1 = new HashSet<>();
        Set<Integer> col2 = new HashSet<>();
        Set<Integer> col3 = new HashSet<>();
        Set<Integer> col4 = new HashSet<>();
        Set<Integer> col5 = new HashSet<>();
        Set<Integer> col6 = new HashSet<>();
        Set<Integer> col7 = new HashSet<>();
        Set<Integer> col8 = new HashSet<>();
        Set<Integer> col9 = new HashSet<>();


        for (int i = 0; i < 9; i++){
            col1.add(this.grid[0][i]);
            col2.add(this.grid[1][i]);
            col3.add(this.grid[2][i]);
            col4.add(this.grid[3][i]);
            col5.add(this.grid[4][i]);
            col6.add(this.grid[5][i]);
            col7.add(this.grid[6][i]);
            col8.add(this.grid[7][i]);
            col9.add(this.grid[8][i]);
        }

        this.cols.add(col1);
        this.cols.add(col2);
        this.cols.add(col3);
        this.cols.add(col4);
        this.cols.add(col5);
        this.cols.add(col6);
        this.cols.add(col7);
        this.cols.add(col8);
        this.cols.add(col9);


        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        // ...

        Set<Integer> sqr1 = new HashSet<>();
        Set<Integer> sqr2 = new HashSet<>();
        Set<Integer> sqr3 = new HashSet<>();
        Set<Integer> sqr4 = new HashSet<>();
        Set<Integer> sqr5 = new HashSet<>();
        Set<Integer> sqr6 = new HashSet<>();
        Set<Integer> sqr7 = new HashSet<>();
        Set<Integer> sqr8 = new HashSet<>();
        Set<Integer> sqr9 = new HashSet<>();

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                sqr1.add(this.grid[j][i]);
                sqr2.add(this.grid[j][i+3]);
                sqr3.add(this.grid[j][i+6]);
                sqr4.add(this.grid[j+3][i]);
                sqr5.add(this.grid[j+3][i+3]);
                sqr6.add(this.grid[j+3][i+6]);
                sqr7.add(this.grid[j+6][i]);
                sqr8.add(this.grid[j+6][i+3]);
                sqr9.add(this.grid[j+6][i+6]);
            }
        }

        // create a hash set for [1..9] (this.nums)
        // ...
        nums = new HashSet<>();
        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        
        // ...

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            // ...

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                // ...
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}