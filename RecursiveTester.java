/*  Student information for assignment:
 *
 *  Number of slip days used: 2
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: vr8546
 *  email address: varunsatishrao@gmail.com
 *  Grader name: Rohit
 *  Section number: 51352
 *  
 *
 *  Student 2 no second student
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Section number:
 *
 */


import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester {
    public static void main(String[] args) {
        Recursive r = new Recursive();

        

        //        // try the Sierpinski triangle, uncomment when ready
        //        r.drawTriangles(400, 15, 360);
        //
        //        // try the Sierpinski Carpet, uncomment when ready
        //        r.drawCarpet(729, 4);

        // also try this
        //      r.drawCarpet(729, 1);
       

        studentTests(r);

    }

    // pre: r != null
    // post: run student test
    private static void studentTests(Recursive r) {
        // CS314 students put your tests here
    	if(r == null) {
    		throw new IllegalArgumentException("r cannot equal null.");
    	}
    	

    	String actualBinary = r.getBinary(1);
        String expectedBinary = "1";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 1 passed. get binary.");
        else
            System.out.println( "Test 1 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);


        actualBinary = r.getBinary(2);
        expectedBinary = "10";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 2 passed. get binary.");
        else
            System.out.println( "Test 2 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);

        actualBinary = r.getBinary(87);
        expectedBinary = "1010111";
        if( actualBinary.equals(expectedBinary) )
            System.out.println( "Test 3 passed. get binary.");
        else
            System.out.println( "Test 3 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);

        String actualRev = r.revString("a");
        String expectedRev = "a";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 4 passed. reverse string.");
        else
            System.out.println( "Test 4 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);


        actualRev = r.revString("Varun");
        expectedRev = "nuraV";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 5 passed. reverse string.");
        else
            System.out.println( "Test 5 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);
        
        actualRev = r.revString("");
        expectedRev = "";
        if( actualRev.equals(expectedRev) )
            System.out.println( "Test 6 passed. reverse string.");
        else
            System.out.println( "Test 6 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);


        int[] numsForDouble = {0, 0, 0, 0};
        int actualDouble = r.nextIsDouble(numsForDouble);
        int expectedDouble = 3;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 7 passed. next is double.");
        else
            System.out.println( "Test 7 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);


        numsForDouble = new int[]{-5, -10, 20};
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 1;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 8 passed. next is double.");
        else
            System.out.println( "Test 8 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);


        numsForDouble = new int[]{};
        actualDouble = r.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if(actualDouble == expectedDouble)
            System.out.println( "Test 9 passed. next is double.");
        else
            System.out.println( "Test 8 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);

        ArrayList<String> mnemonics = r.listMnemonics("0");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("0");
        if( mnemonics.equals(expected))
            System.out.println( "Test 10 passed. Phone mnemonics.");
        else
            System.out.println( "Test 10 failed. Phone mnemonics.");

        mnemonics = r.listMnemonics("25");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("AJ");
        expected.add("AK");
        expected.add("AL");
        expected.add("BJ");
        expected.add("BK");
        expected.add("BL");
        expected.add("CJ");
        expected.add("CK");
        expected.add("CL");
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 11 passed. Phone mnemonics.");
        else
            System.out.println( "Test 11 failed. Phone mnemonics.");
        
        mnemonics = r.listMnemonics("9");
        Collections.sort(mnemonics);
        expected.clear();
        expected.add("W");
        expected.add("X");
        expected.add("Y");
        expected.add("Z");
  
        Collections.sort(expected);
        if( mnemonics.equals(expected))
            System.out.println( "Test 12 passed. Phone mnemonics.");
        else
            System.out.println( "Test 12 failed. Phone mnemonics.");


        int[][] world = {{5,5,5,5,5,5},
                		 {5,5,5,5,5,5},
                		 {5,5,5,5,5,5},
                		 {5,5,4,4,5,5},
                		 {5,5,3,3,5,5},
                		 {5,5,2,2,5,5},
                		 {5,5,5,1,5,5},
                		 {5,5,5,-2,5,5}};

        if( r.canFlowOffMap(world,0,1))
            System.out.println( "Test 13 passed. can flow off map.");
        else
            System.out.println( "Test 13 failed. can flow off map.");

        if( !r.canFlowOffMap(world,2,2))
            System.out.println( "Test 14 passed. can flow off map.");
        else
            System.out.println( "Test 14 failed. can flow off map.");


        world = new int[][]
                          {{10, 10, 10, 10, 10, 10, 10},
                		   {10, 10, 10,  5, 10, 10, 10},
                		   {10, 10, 10,  6, 10, 10, 10},
                		   {10, 10, 10,  7, 10, 10, 10},
                		   {5,   6,  7,  8,  7,  6, 10},
                		   {10, 10, 10,  7, 10, 10, 10},
                		   {10, 10, 10,  6, 10, 10, 10},
                		   {10, 10, 10,  5, 10, 10, 10},
                		   {10, 10, 10, 10, 10, 10, 10},
                          };

        if( !r.canFlowOffMap(world,6,3))
            System.out.println( "Test 15 passed. can flow off map.");
        else
            System.out.println( "Test 15 failed. can flow off map.");



        int[] abilities = {0, Integer.MAX_VALUE};
        if(r.minDifference(2, abilities) == Integer.MAX_VALUE)
            System.out.println( "Test 17 passed. min difference.");
        else
            System.out.println( "Test 17 failed. min difference.");
        
        abilities = new int[]{0, Integer.MIN_VALUE};
        if(r.minDifference(2, abilities) == Integer.MIN_VALUE)
            System.out.println( "Test 18 passed. min difference.");
        else
            System.out.println( "Test 18 failed. min difference.");
        
        abilities = new int[]{0, 0, 0, 1};
        if(r.minDifference(3, abilities) == 1)
            System.out.println( "Test 19 passed. min difference.");
        else
            System.out.println( "Test 19 failed. min difference.");


        String puzzle1 = "550070000600195000098000060800060003400803001700020006060000280000419005000080079";
        int[][] board = stringToBoard(puzzle1);
        int[][] result = r.getSudokoSolution(board);
        String actualBoard = boardToString(result);
        String expectedBoard = "550070000600195000098000060800060003400803001700020006060000280000419005000080079";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 19 passed. sudoko solver.");
        else {
            System.out.println("Test 19 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }


        String puzzle2 = "000000000000000000008000000000000000000000000000000000000000000000000000000000000";
        board = stringToBoard(puzzle2);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "147238569259167348368459127471382695582691473693574281714823956825916734936745812";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 20 passed. sudoko solver.");
        else {
            System.out.println("Test 20 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            System.out.println(actualBoard);
            printBoard(result);
        }


        String puzzle3 = "660010300008003500500002001003000007106070403400000200200300004004900600007080000";
        assert puzzle3.length() == 81;
        board = stringToBoard(puzzle3);
        result = r.getSudokoSolution(board);
        actualBoard = boardToString(result);
        expectedBoard = "660010300008003500500002001003000007106070403400000200200300004004900600007080000";
        if(actualBoard.equals(expectedBoard))
            System.out.println( "Test 21 passed. sudoko solver.");
        else {
            System.out.println("Test 21 failed. sudoku solver:");
            System.out.println("Expected board:");
            printBoard(stringToBoard(expectedBoard));
            System.out.println();
            System.out.println("Actual board:");
            printBoard(result);
        }


    }

    private static String boardToString(int[][] board) {
        StringBuilder result = new StringBuilder(81);
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[r].length; c++)
                result.append(board[r][c]);
        return result.toString();
    }

    private static int[][] stringToBoard(String puzzle) {
        int[][] result = new int[Recursive.BOARD_SIZE][Recursive.BOARD_SIZE];
        int index = 0;
        for(int r = 0; r < result.length; r++)
            for(int c = 0; c < result.length; c++, index++)
                result[r][c] = puzzle.charAt(index) - '0';
        return result;
    }

    private static void printBoard(int[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}