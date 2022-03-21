///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA5Tester
// File:               PA5Tester.java
// Quarter:            Winter 2020
//
// Author:             Rachel Chung
// Instructor's Name:  Christine Alvarado, Greg Miranda
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Arrays;
import java.util.Random;

public class PA5Tester {

    // Seed passed to random generator to match the expected output
    private static int SEED = 2017;

    /**
    * Main method runs a series of test on the Board object.
    *
    * @param args (not used)
    */
    public static void main(String[] args)
    {

        PA5Tester solver = new PA5Tester();

        System.out.println("\n\n*************** Testing PA5 *****************");

        int score = 0;
        score += solver.testPrintBoard();
        score += solver.testCanMove();
        score += solver.testMove();

        System.out.println("*************************************************");


    }

    /************************ TEST PRINT BOARD ************************/

    /**
     * Test the board's printBoard  method.
     *
     * @return 1 if the tests pass, 0 if they fail
     */
    private int testPrintBoard()
    {
        System.out.println("Testing printBoard method .......................");

        Board board1 = new Board(new Random(SEED), new int[][]{
                {2, 4, 0, 0},
                {0, 0, 8, 4},
                {0, 16, 0, 4},
                {1024, 2, 4, 256}});

        System.out.println("\nPrinting current board ......................\n");
        board1.printBoard();
        System.out.println("\nPrinting board after moving UP ..............\n");
        board1.printBoard(board1.UP);
        System.out.print("\nPrinting board to see previous ");
        System.out.println("board remains ........\n");
        board1.printBoard();
        System.out.println("\nPrinting board after moving LEFT ............\n");
        board1.printBoard(board1.LEFT);
        System.out.print("\nPrinting board to see previous ");
        System.out.println("board remains ........\n");
        board1.printBoard();
        System.out.println("\n***********************************************");
        return 0;
    }

    /************************ TEST CAN MOVE ************************/

    /**
     * Test the board's canMove method.
     * @return 1 if the tests pass, 0 if they fail
     */
    private int testCanMove()
    {
        System.out.println("Testing canMove method......................");

        /*
         * BOARDS THAT CAN MOVE
         */
        System.out.println("Testing boards that can move.");
        // Board that can simply move left
        Board board = new Board(new Random(SEED), new int[][]{
                {0, 0, 0, 0},
                {0, 4, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}});

        if (board.canMove(board.LEFT)) {
            System.out.println("Board moved left successfully. Passed.");
        }
        else {
            System.out.println("FAILED! Board should be able to move left:");
            board.printBoard();
            return 0;
        }
        // Board that can simply move down
        if (board.canMove(board.DOWN)) {
            System.out.println("Board moved down successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move down:");
            board.printBoard();
            return 0;
        }
        // Board that can simply move right
        if (board.canMove(board.RIGHT)) {
            System.out.println("Board moved right successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move right:");
            board.printBoard();
            return 0;
        }
        // Board that can simply move up
        if (board.canMove(board.UP)) {
            System.out.println("Board moved up successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move up: ");
            board.printBoard();
            return 0;
        }

        /*
        * BOARD THAT CAN ONLY BE MOVED BY ADDING
        */
        System.out.println("Testing Boards that can only be moved via adding");
        Board boardUpAdd = new Board(new Random(SEED), new int[][]{
            {0, 4, 0, 0},
            {0, 4, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        if (boardUpAdd.canMove(board.UP)) {
            System.out.println("Board moved up successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move up: ");
            boardUpAdd.printBoard();
            return 0;
        }
        Board boardDownAdd = new Board(new Random(SEED), new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 4, 0, 0},
            {0, 4, 0, 0}
        });
        if (boardDownAdd.canMove(board.DOWN)) {
            System.out.println("Board moved down successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move down: ");
            boardDownAdd.printBoard();
            return 0;
        }
        Board boardLeftAdd = new Board(new Random(SEED), new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {4, 4, 0, 0},
            {0, 0, 0, 0}
        });
        if (boardLeftAdd.canMove(board.LEFT)) {
            System.out.println("Board moved left successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move left: ");
            boardLeftAdd.printBoard();
            return 0;
        }
        Board boardRightAdd = new Board(new Random(SEED), new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {4, 4, 0, 0},
            {0, 0, 0, 0}
        });
        if (boardRightAdd.canMove(board.RIGHT)) {
            System.out.println("Board moved right successfully. Passed.");
        } else {
            System.out.println("FAILED! Board should be able to move right: ");
            boardRightAdd.printBoard();
            return 0;
        }
        /*
        * BOARD THAT CANNOT BE MOVED AT ALL
        */
        Board boardNotLeftUp = new Board(new Random(SEED), new int[][]{
            {4, 2, 0, 0},
            {2, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        });
        if (boardNotLeftUp.canMove(board.LEFT)) {
            System.out.println("FAILED! Board should NOT be able to move left: ");
            boardNotLeftUp.printBoard();
            return 0;
        } else {
            System.out.println("Board avoided left successfully.");
        }
        if (boardNotLeftUp.canMove(board.UP)) {
            System.out.println("FAILED! Board should NOT be able to move up: ");
            boardNotLeftUp.printBoard();
            return 0;
        } else {
            System.out.println("Board avoided up successfully.");
        }
        Board boardNotRightDown = new Board(new Random(SEED), new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 2},
            {0, 0, 2, 4}
        });
        if (boardNotRightDown.canMove(board.RIGHT)) {
            System.out.println("FAILED! Board should NOT be able to move right: ");
            boardNotRightDown.printBoard();
            return 0;
        } else {
            System.out.println("Board avoided right successfully.");
        }
        if (boardNotRightDown.canMove(board.DOWN)) {
            System.out.println("FAILED! Board should NOT be able to move down: ");
            boardNotRightDown.printBoard();
            return 0;
        } else {
            System.out.println("Board avoided down successfully.");
        }

        System.out.println("ALL MOVE TESTS Passed!");
        return 1;
    }

    /************************ TEST MOVE ************************/
    /**
     * Test the board's move method.
     * TODO: Add tests to this method.
     * @return 1 if the tests pass, 0 if they fail
     */
    public int testMove()
    {
        System.out.println("Testing move method.........................");
        // int passed = 1;

        // FIRST SET OF PASSES
        Board board_left = new Board(new Random(SEED), new int[][]{
            {0, 2, 2, 0},
            {0, 0, 16, 8},
            {2, 128, 128, 32},
            {16, 16, 16, 16}});

        board_left.move(board_left.LEFT);
        if (!isEqualArray(boardToArray(board_left), new int[][]{
                {4, 0, 0, 0},
                {16, 8, 0, 0},
                {2, 256, 32, 0},
                {32, 32, 0, 0}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.LEFT) implemented incorrectly");
            return 0;
        } else {
            System.out.println("FIRST LEFT PASSED!");
        }

        Board board_right = new Board(new Random(SEED), new int[][]{
                {2, 4, 8, 2},
                {2, 4, 8, 2},
                {2, 4, 8, 0},
                {2, 4, 8, 2}});

        board_right.move(board_right.RIGHT);
        if (!isEqualArray(boardToArray(board_right), new int[][]{
                {2, 4, 8, 2},
                {2, 4, 8, 2},
                {0, 2, 4, 8},
                {2, 4, 8, 2}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.RIGHT) is implemented incorrectly");
            return 0;
        } else {
            System.out.println("FIRST RIGHT PASSED!");
        }

        Board board_up = new Board(new Random(SEED), new int[][]{
            {0, 8, 4, 8},
            {0, 0, 128, 8},
            {2, 8, 128, 256},
            {0, 0, 2, 64}});

        board_up.printBoard();
        board_up.move(board_up.UP);
        if (!isEqualArray(boardToArray(board_up), new int[][]{
                {2, 16, 4, 16},
                {0, 0, 256, 256},
                {0, 0, 2, 64},
                {0, 0, 0, 0}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.UP) implemented incorrectly");
            board_up.printBoard();
            return 0;
        } else {
            System.out.println("FIRST UP PASSED!");
        }

        Board board_down = new Board(new Random(SEED), new int[][]{
            {2, 0, 0, 2},
            {2, 0, 8, 2},
            {2, 4, 8, 0},
            {2, 4, 0, 2}});

        board_down.move(board_down.DOWN);
        if (!isEqualArray(boardToArray(board_down), new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 2},
                {4, 8, 16, 4}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.DOWN) implemented incorrectly");
            return 0;
        } else {
            System.out.println("FIRST DOWN PASSED!");
        }

        // SECOND SET OF TESTS
        board_left = new Board(new Random(SEED), new int[][]{
            {0, 2, 2, 8},
            {0, 2, 16, 8},
            {0, 128, 128, 32},
            {32, 0, 16, 16}});

        board_left.move(board_left.LEFT);
        if (!isEqualArray(boardToArray(board_left), new int[][]{
                {4, 8, 0, 0},
                {2, 16, 8, 0},
                {256, 32, 0, 0},
                {32, 32, 0, 0}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.LEFT) implemented incorrectly");
            return 0;
        } else {
            System.out.println("SECOND LEFT PASSED!");
        }

        board_right = new Board(new Random(SEED), new int[][]{
                {2, 4, 8, 2},
                {2, 4, 8, 2},
                {0, 4, 8, 0},
                {2, 4, 8, 0}});

        board_right.move(board_right.RIGHT);
        if (!isEqualArray(boardToArray(board_right), new int[][]{
                {2, 4, 8, 2},
                {2, 4, 8, 2},
                {0, 0, 4, 8},
                {0, 2, 4, 8}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.RIGHT) is implemented incorrectly");
            return 0;
        } else {
            System.out.println("SECOND RIGHT PASSED!");
        }

        board_up = new Board(new Random(SEED), new int[][]{
            {0, 8, 4, 8},
            {2, 0, 64, 8},
            {0, 8, 64, 256},
            {2, 0, 2, 64}});

        board_up.printBoard();
        board_up.move(board_up.UP);
        if (!isEqualArray(boardToArray(board_up), new int[][]{
                {4, 16, 4, 16},
                {0, 0, 128, 256},
                {0, 0, 2, 64},
                {0, 0, 0, 0}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.UP) implemented incorrectly");
            board_up.printBoard();
            return 0;
        } else {
            System.out.println("SECOND UP PASSED!");
        }

        board_down = new Board(new Random(SEED), new int[][]{
            {2, 4, 8, 2},
            {2, 4, 8, 2},
            {2, 4, 8, 2},
            {2, 4, 8, 2}});

        board_down.move(board_down.DOWN);
        if (!isEqualArray(boardToArray(board_down), new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 8, 16, 4},
                {4, 8, 16, 4}})) {
            System.out.println("FAILED!");
            System.out.println("move(Board.DOWN) implemented incorrectly");
            return 0;
        } else {
            System.out.println("SECOND DOWN PASSED!");
        }

        System.out.println("All Move Tests Passed!");
        return 1;
    }

    /**
     * Creates int[][] given a board object.  Helper method to make sure
     * tests are working correctly.
     *
     * @return the array representation of the board's grid.
     */
    private int[][] boardToArray(Board board) {
        if (board == null) {
            return null;
        }
        int[][] array = new int[board.GRID_SIZE][board.GRID_SIZE];
        for (int r = 0; r < board.GRID_SIZE; r++) {
            for (int c = 0; c < board.GRID_SIZE; c++) {
                array[r][c] = board.getTileValue(r, c);
            }
        }
        return array;
    }

    /**
     * Compares two 2D int arrays.  Helper method to make sure
     * tests are working correctly.
     *
     * Precondition: The arrays are the same size and not null.
     *
     * @return true if the arrays contain all the same values, false otherwise
     */
    private boolean isEqualArray(int[][] grid1, int[][] grid2) {
        for (int r = 0; r < grid1.length; ++r) {
            for (int c = 0; c < grid1.length; ++c) {
                if (grid1[r][c] != grid2[r][c])
                    return false;
            }
        }
        return true;
    }
}
