///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA4
// Files:              PA4.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Matthew Vandenberg
// Email:              mvandenberg@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                  If pair programming is allowed:
//                  1. Read PAIR-PROGRAMMING policy
//                  2. Choose a partner wisely
//                  3. Complete this section for each program file
//
// Pair Partner:        Not used
// Email:               NA
// Instructors's Name:  NA
// Lab Section:         NA
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:         None
//
// Online sources:   None
//////////////////////////// 80 columns wide //////////////////////////////////
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;


/**
 * Solve mazes based on an input file
 * @author Matthew Vandenberg
 */
public class PA4 {

    /**
     * Read maze into a 2D array of MazePont objects, given a file
     * @param fileToRead File to read
     * @return MazePoint[][] representing the input file
     * @throws IOException Thrown if file does not exist
     */
    public MazePoint[][] readMaze(String fileToRead) throws IOException
    {

        Scanner fileScanner = new Scanner(new File(fileToRead));
        int numRows = fileScanner.nextInt();
        int numCols = fileScanner.nextInt();
        
        MazePoint[][] maze = new MazePoint[numRows][numCols];

        // For each line of the file, it represents a new row in the 2d array
        for (int i = 0; i < numRows; i++) {
            int colCount = 0;
            // We insert the character array as long as the scanner doesn't 
            // hit a space
            while (colCount < numCols) {
                String nextCharacter = fileScanner.next();
                if (nextCharacter.equals(" ")) continue;
                maze[i][colCount] = new MazePoint(nextCharacter.equals("X"));
                colCount++;
            }
        }

        fileScanner.close();

        return maze;
    }

    /**
     * Escape from the maze, from top left to bottom right corners.
     * For each character that is included in the escape path, replace with '*'
     * @param maze Maze to escape from.
     */
    public void escapeFromMaze(MazePoint [][] maze){
        // Based on the two example input files, I'll assume that back tracking
        // is not required for this assignment

        // First, check lengths to ensure they are at least 1
        if (maze.length <= 0 || maze[0].length <= 0) {
            System.out.println("Dimensions too small!");
            return;
        }

        boolean solved = false;
        int currentRow = 0, currentColumn = 0;
        while (!solved) {
            // Define simple boolean variables to determine particular events

            // If there is no more space to the right of current position, 
            // or there is a wall to the right
            boolean rightBlocked = currentColumn + 1 == maze[currentRow].length
             || maze[currentRow][currentColumn + 1].isWall();

            // If there is no more space to the bottom of the current position,
            // or there is a wall below
            boolean bottomBlocked = currentRow + 1 == maze.length 
            || maze[currentRow+1][currentColumn].isWall();

            if (maze[currentRow][currentColumn] == null) {
                System.out.println("Maze has null elements, cannot continue!");
                return;
            }
            maze[currentRow][currentColumn].setToPath();

            if (rightBlocked && bottomBlocked) {
                System.out.println("Solved!");
                solved = true;
                break;
            }

            if (rightBlocked && !bottomBlocked) {
                // Go down
                currentRow++;
            }

            if (!rightBlocked && bottomBlocked) {
                // Go right
                currentColumn++;
            }


        }
        
    }

    /**
    * Print the maze as a 2D grid.  You should call this method from
    * testRead and testEscape, as well as from main.
    *
    * Precondition: The maze is not null.
    * Postcondition: The maze has been printed and is unmodified.
    *
    * @param maze The maze to be printed.
    */
    private void printMaze(MazePoint[][] maze)
    {
        for (MazePoint[] arr : maze) System.out.println(Arrays.toString(arr));
    }

    /**
    * Compare two maze arrays.  Return true if they have .  You should call
    * this method from testRead and testEscape.
    *
    * Precondition: The mazes are not null and have the same size.
    * Postcondition: The mazes are not modified.
    *
    * @param maze1 the first maze to compare.
    * @param maze2 the second maze to compare.
    * @return true if the mazes contain all the same symbols and false otherwise
    */
    private boolean mazeMatch(MazePoint[][] maze1, MazePoint[][] maze2)
    {
        for (int i = 0; i < maze1.length; i++) {
            for (int j = 0; j < maze1[0].length; j++) {
                if (!maze1[i][j].symbolMatch(maze2[i][j])) return false;
            }
        }
        return true;
    }

    /**
     * Given a filename, create the maze and compare to ensure that the read
     * matches what is expected.
     * @param fileToRead The file to read maze from
     * @param expected Expected maze to get when reading from file
     * @return If mazes match, true, otherwise false
     * @throws IOException Thrown if file does not exist
     */
    public boolean testRead(String fileToRead, MazePoint[][] expected)
    throws IOException
    {
        MazePoint[][] actual = readMaze(fileToRead);
        System.out.println("Expected Maze: ");
        printMaze(expected);
        System.out.println("Actual Maze: ");
        printMaze(actual);

        if (!mazeMatch(expected, actual)) {
            System.out.println("Warning: The mazes did not match!");
            return false;
        }
        System.out.println("Read Test Passed!");
        return true;
    }

    /**
     * Similar to testRead(), solve maze and compare with what's expected
     * @param maze Maze to solve
     * @param expectedSolution Maze to compare solution with
     * @return If mazes match, true, otherwise false
     */
    public boolean testEscape(MazePoint[][] maze,
                              MazePoint[][] expectedSolution) {

        escapeFromMaze(maze);
        System.out.println("Expected Escaped Maze: ");
        printMaze(expectedSolution);
        System.out.println("Actual Escaped Maze: ");
        printMaze(maze);

        if (!mazeMatch(expectedSolution, maze)) {
            System.out.println("Warning: Solution did not pass correctly!");
            return false;
        } 

        System.out.println("Escape Test Passed!");
        return true;
    }

    /**
    * Run unit tests.  You will add to this method.
    * Prints a message indicating whether all tests passed or failed.
    * The method will abort on the first failed test.
    * @return true if all unit tests pass.  false if at least one test fails.
    */
    public boolean unitTests() throws IOException {
        // Manually create the expected maze to match file input1
        MazePoint[][] expected = new MazePoint[3][3];
        expected[0][0] = new MazePoint(false);
        expected[0][1] = new MazePoint(false);
        expected[0][2] = new MazePoint(true);
        expected[1][0] = new MazePoint(true);
        expected[1][1] = new MazePoint(false);
        expected[1][2] = new MazePoint(false);
        expected[2][0] = new MazePoint(true);
        expected[2][1] = new MazePoint(true);
        expected[2][2] = new MazePoint(false);

        if (!this.testRead("input1", expected)) {
            System.out.println("Read test 1 failed.");
            return false;
        } else {
          System.out.println("Read test 1 passed!");
        }

        // Input 2
        MazePoint[][] expected2 = new MazePoint[4][8];
        expected2[0][0] = new MazePoint(false);
        expected2[0][1] = new MazePoint(true);
        expected2[0][2] = new MazePoint(true);
        expected2[0][3] = new MazePoint(false);
        expected2[0][4] = new MazePoint(true);
        expected2[0][5] = new MazePoint(true);
        expected2[0][6] = new MazePoint(true);
        expected2[0][7] = new MazePoint(true);
        expected2[1][0] = new MazePoint(false);
        expected2[1][1] = new MazePoint(false);
        expected2[1][2] = new MazePoint(false);
        expected2[1][3] = new MazePoint(false);
        expected2[1][4] = new MazePoint(true);
        expected2[1][5] = new MazePoint(false);
        expected2[1][6] = new MazePoint(true);
        expected2[1][7] = new MazePoint(false);
        expected2[2][0] = new MazePoint(true);
        expected2[2][1] = new MazePoint(true);
        expected2[2][2] = new MazePoint(true);
        expected2[2][3] = new MazePoint(false);
        expected2[2][4] = new MazePoint(true);
        expected2[2][5] = new MazePoint(true);
        expected2[2][6] = new MazePoint(true);
        expected2[2][7] = new MazePoint(false);
        expected2[3][0] = new MazePoint(false);
        expected2[3][1] = new MazePoint(true);
        expected2[3][2] = new MazePoint(false);
        expected2[3][3] = new MazePoint(false);
        expected2[3][4] = new MazePoint(false);
        expected2[3][5] = new MazePoint(false);
        expected2[3][6] = new MazePoint(false);
        expected2[3][7] = new MazePoint(false);

        if (!this.testRead("input2", expected2)) {
            System.out.println("Read test 2 failed.");
            return false;
        } else {
            System.out.println("Read test 2 passed!");
        }

        // Input 3
        MazePoint[][] expected3 = new MazePoint[2][7];
        expected3[0][0] = new MazePoint(false);
        expected3[0][1] = new MazePoint(false);
        expected3[0][2] = new MazePoint(false);
        expected3[0][3] = new MazePoint(false);
        expected3[0][4] = new MazePoint(false);
        expected3[0][5] = new MazePoint(false);
        expected3[0][6] = new MazePoint(true);
        expected3[1][0] = new MazePoint(true);
        expected3[1][1] = new MazePoint(true);
        expected3[1][2] = new MazePoint(true);
        expected3[1][3] = new MazePoint(true);
        expected3[1][4] = new MazePoint(true);
        expected3[1][5] = new MazePoint(false);
        expected3[1][6] = new MazePoint(false);

        if (!this.testRead("input3", expected3)) {
            System.out.println("Read test 3 failed.");
            return false;
        } else {
            System.out.println("Read test 3 passed!");
        }

        // Input 4
        MazePoint[][] expected4 = new MazePoint[3][4];
        expected4[0][0] = new MazePoint(false);
        expected4[0][1] = new MazePoint(false);
        expected4[0][2] = new MazePoint(true);
        expected4[0][3] = new MazePoint(true);
        expected4[1][0] = new MazePoint(true);
        expected4[1][1] = new MazePoint(false);
        expected4[1][2] = new MazePoint(true);
        expected4[1][3] = new MazePoint(true);
        expected4[2][0] = new MazePoint(false);
        expected4[2][1] = new MazePoint(false);
        expected4[2][2] = new MazePoint(false);
        expected4[2][3] = new MazePoint(false);

        if (!this.testRead("input4", expected4)) {
            System.out.println("Read test 4 failed.");
            return false;
        } else {
            System.out.println("Read test 4 passed!");
        }


        // At this point readMaze is working, so we can use it.
        MazePoint[][] maze1 = this.readMaze("input1");

        // Modify the expected maze from above to have the path
        expected[0][0].setToPath();
        expected[0][1].setToPath();
        expected[1][1].setToPath();
        expected[1][2].setToPath();
        expected[2][2].setToPath();

        if (!this.testEscape(maze1, expected)) {
            System.out.println("Escape test 1 failed.");
            return false;
        }
        else {
            System.out.println("Escape test 1 passed!");
        }

        // Test 2
        MazePoint[][] maze2 = this.readMaze("input2");
        expected2[0][0].setToPath();
        expected2[1][0].setToPath();
        expected2[1][1].setToPath();
        expected2[1][2].setToPath();
        expected2[1][3].setToPath();
        expected2[2][3].setToPath();
        expected2[3][3].setToPath();
        expected2[3][4].setToPath();
        expected2[3][5].setToPath();
        expected2[3][6].setToPath();
        expected2[3][7].setToPath();

        if (!this.testEscape(maze2, expected2)) {
            System.out.println("Escape test 2 failed.");
            return false;
        }
        else {
            System.out.println("Escape test 2 passed!");
        }

        // Test 3
        MazePoint[][] maze3 = this.readMaze("input3");
        expected3[0][0].setToPath();
        expected3[0][1].setToPath();
        expected3[0][2].setToPath();
        expected3[0][3].setToPath();
        expected3[0][4].setToPath();
        expected3[0][5].setToPath();
        expected3[1][5].setToPath();
        expected3[1][6].setToPath();

        if (!this.testEscape(maze3, expected3)) {
            System.out.println("Escape test 3 failed.");
            return false;
        }
        else {
            System.out.println("Escape test 3 passed!");
        }

        // Test 4
        MazePoint[][] maze4 = this.readMaze("input4");
        expected4[0][0].setToPath();
        expected4[0][1].setToPath();
        expected4[1][1].setToPath();
        expected4[2][1].setToPath();
        expected4[2][2].setToPath();
        expected4[2][3].setToPath();

        if (!this.testEscape(maze4, expected4)) {
            System.out.println("Escape test 4 failed.");
            return false;
        }
        else {
            System.out.println("Escape test 4 passed!");
        }
        

        return true;
    }


    /**
     * Run Unit Tests, and then ask user for the mazes they'd like to solve
     * @param args not used
     * @throws IOException A file does not exist
     */
    public static void main(String[] args) throws IOException
    {
        PA4 solver = new PA4();

        // Perform unitTest first
        if (solver.unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }

        // Part 3 - User input
        Scanner kbd = new Scanner(System.in);
        String userInput = "";
        while (true) {
            System.out.println("Enter a maze to solve. \"End\" to stop.");
            userInput = kbd.nextLine();
            if (userInput.equalsIgnoreCase("end")) {
                break;
            } else if (userInput.contains("input")) {
                MazePoint[][] currentMaze = solver.readMaze(userInput);
                System.out.println("Maze before solution: ");
                solver.printMaze(currentMaze);
                System.out.println("Maze after solution: ");
                solver.escapeFromMaze(currentMaze);
                solver.printMaze(currentMaze);
            } else {
                System.out.println("Input not recognized!");
            }
        }
        kbd.close();

        System.out.println("Program Terminated");
    }
}
