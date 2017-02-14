import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//  CodeCamp.java - CS314 Assignment 1 - Tester class

/*  Student information for assignment:
 *
 *  Name: Varun Rao
 *  email address: varunsatishrao@gmail.com	
 *  UTEID: vr8546
 *  Section 5 digit ID: 51352
 *  Grader name: Rohit
 *  Number of slip days used on this assignment: 0
 */


/* CS314 Students: place results of shared birthdays experiments in this comment.
The average number of people with shared birthdays with 182 people and 365 days is 45

Num people: 2, number of experiments with one or more shared birthday: 118 percentage: 0
 ... 

Num people: 3, number of experiments with one or more shared birthday: 433 percentage: 0
 ... 

Num people: 4, number of experiments with one or more shared birthday: 792 percentage: 1
 ... 

Num people: 5, number of experiments with one or more shared birthday: 1313 percentage: 2
 ... 

Num people: 6, number of experiments with one or more shared birthday: 1970 percentage: 3
 ... 

Num people: 7, number of experiments with one or more shared birthday: 2743 percentage: 5
 ... 

Num people: 8, number of experiments with one or more shared birthday: 3734 percentage: 7
 ... 

Num people: 9, number of experiments with one or more shared birthday: 4723 percentage: 9
 ... 

Num people: 10, number of experiments with one or more shared birthday: 5935 percentage: 11
 ... 

Num people: 11, number of experiments with one or more shared birthday: 6912 percentage: 13
 ... 

Num people: 12, number of experiments with one or more shared birthday: 8241 percentage: 16
 ... 

Num people: 13, number of experiments with one or more shared birthday: 9659 percentage: 19
 ... 

Num people: 14, number of experiments with one or more shared birthday: 11171 percentage: 22
 ... 

Num people: 15, number of experiments with one or more shared birthday: 12740 percentage: 25
 ... 

Num people: 16, number of experiments with one or more shared birthday: 14231 percentage: 28
 ... 

Num people: 17, number of experiments with one or more shared birthday: 15629 percentage: 31
 ... 

Num people: 18, number of experiments with one or more shared birthday: 17289 percentage: 34
 ... 

Num people: 19, number of experiments with one or more shared birthday: 19240 percentage: 38
 ... 

Num people: 20, number of experiments with one or more shared birthday: 20587 percentage: 41
 ... 

Num people: 21, number of experiments with one or more shared birthday: 22190 percentage: 44
 ... 

Num people: 22, number of experiments with one or more shared birthday: 24091 percentage: 48
 ... 

Num people: 23, number of experiments with one or more shared birthday: 25191 percentage: 50
 ... 

Num people: 24, number of experiments with one or more shared birthday: 27045 percentage: 54
 ... 

Num people: 25, number of experiments with one or more shared birthday: 28212 percentage: 56
 ... 

Num people: 26, number of experiments with one or more shared birthday: 29869 percentage: 59
 ... 

Num people: 27, number of experiments with one or more shared birthday: 31338 percentage: 62
 ... 

Num people: 28, number of experiments with one or more shared birthday: 32924 percentage: 65
 ... 

Num people: 29, number of experiments with one or more shared birthday: 34169 percentage: 68
 ... 

Num people: 30, number of experiments with one or more shared birthday: 35284 percentage: 70
 ... 

Num people: 31, number of experiments with one or more shared birthday: 36558 percentage: 73
 ... 

Num people: 32, number of experiments with one or more shared birthday: 37698 percentage: 75
 ... 

Num people: 33, number of experiments with one or more shared birthday: 38819 percentage: 77
 ... 

Num people: 34, number of experiments with one or more shared birthday: 39752 percentage: 79
 ... 

Num people: 35, number of experiments with one or more shared birthday: 40766 percentage: 81
 ... 

Num people: 36, number of experiments with one or more shared birthday: 41493 percentage: 82
 ... 

Num people: 37, number of experiments with one or more shared birthday: 42397 percentage: 84
 ... 

Num people: 38, number of experiments with one or more shared birthday: 43192 percentage: 86
 ... 

Num people: 39, number of experiments with one or more shared birthday: 43891 percentage: 87
 ... 

Num people: 40, number of experiments with one or more shared birthday: 44644 percentage: 89
 ... 

Num people: 41, number of experiments with one or more shared birthday: 45261 percentage: 90
 ... 

Num people: 42, number of experiments with one or more shared birthday: 45746 percentage: 91
 ... 

Num people: 43, number of experiments with one or more shared birthday: 46336 percentage: 92
 ... 

Num people: 44, number of experiments with one or more shared birthday: 46645 percentage: 93
 ... 

Num people: 45, number of experiments with one or more shared birthday: 47077 percentage: 94
 ... 

Num people: 46, number of experiments with one or more shared birthday: 47470 percentage: 94
 ... 

Num people: 47, number of experiments with one or more shared birthday: 47702 percentage: 95
 ... 

Num people: 48, number of experiments with one or more shared birthday: 48053 percentage: 96
 ... 

Num people: 49, number of experiments with one or more shared birthday: 48316 percentage: 96
 ... 

Num people: 50, number of experiments with one or more shared birthday: 48534 percentage: 97
 ... 

Num people: 51, number of experiments with one or more shared birthday: 48697 percentage: 97
 ... 

Num people: 52, number of experiments with one or more shared birthday: 48892 percentage: 97
 ... 

Num people: 53, number of experiments with one or more shared birthday: 49062 percentage: 98
 ... 

Num people: 54, number of experiments with one or more shared birthday: 49177 percentage: 98
 ... 

Num people: 55, number of experiments with one or more shared birthday: 49335 percentage: 98
 ... 

Num people: 56, number of experiments with one or more shared birthday: 49414 percentage: 98
 ... 

Num people: 57, number of experiments with one or more shared birthday: 49496 percentage: 98
 ... 

Num people: 58, number of experiments with one or more shared birthday: 49571 percentage: 99
 ... 

Num people: 59, number of experiments with one or more shared birthday: 49664 percentage: 99
 ... 

Num people: 60, number of experiments with one or more shared birthday: 49692 percentage: 99
 ... 

Num people: 61, number of experiments with one or more shared birthday: 49758 percentage: 99
 ... 

Num people: 62, number of experiments with one or more shared birthday: 49823 percentage: 99
 ... 

Num people: 63, number of experiments with one or more shared birthday: 49819 percentage: 99
 ... 

Num people: 64, number of experiments with one or more shared birthday: 49851 percentage: 99
 ... 

Num people: 65, number of experiments with one or more shared birthday: 49887 percentage: 99
 ... 

Num people: 66, number of experiments with one or more shared birthday: 49905 percentage: 99
 ... 

Num people: 67, number of experiments with one or more shared birthday: 49901 percentage: 99
 ... 

Num people: 68, number of experiments with one or more shared birthday: 49929 percentage: 99
 ... 

Num people: 69, number of experiments with one or more shared birthday: 49951 percentage: 99
 ... 

Num people: 70, number of experiments with one or more shared birthday: 49960 percentage: 99
 ... 

Num people: 71, number of experiments with one or more shared birthday: 49969 percentage: 99
 ... 

Num people: 72, number of experiments with one or more shared birthday: 49969 percentage: 99
 ... 

Num people: 73, number of experiments with one or more shared birthday: 49975 percentage: 99
 ... 

Num people: 74, number of experiments with one or more shared birthday: 49990 percentage: 99
 ... 

Num people: 75, number of experiments with one or more shared birthday: 49994 percentage: 99
 ... 

Num people: 76, number of experiments with one or more shared birthday: 49985 percentage: 99
 ... 

Num people: 77, number of experiments with one or more shared birthday: 49988 percentage: 99
 ... 

Num people: 78, number of experiments with one or more shared birthday: 49994 percentage: 99
 ... 

Num people: 79, number of experiments with one or more shared birthday: 49998 percentage: 99
 ... 

Num people: 80, number of experiments with one or more shared birthday: 49994 percentage: 99
 ... 

Num people: 81, number of experiments with one or more shared birthday: 49996 percentage: 99
 ... 

Num people: 82, number of experiments with one or more shared birthday: 49993 percentage: 99
 ... 

Num people: 83, number of experiments with one or more shared birthday: 49997 percentage: 99
 ... 

Num people: 84, number of experiments with one or more shared birthday: 49999 percentage: 99
 ... 

Num people: 85, number of experiments with one or more shared birthday: 49998 percentage: 99
 ... 

Num people: 86, number of experiments with one or more shared birthday: 49999 percentage: 99
 ... 

Num people: 87, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 88, number of experiments with one or more shared birthday: 49998 percentage: 99
 ... 

Num people: 89, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 90, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 91, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 92, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 93, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 94, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 95, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 96, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 97, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 98, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 99, number of experiments with one or more shared birthday: 50000 percentage: 100
 ... 

Num people: 100, number of experiments with one or more shared birthday: 50000 percentage: 100


*/

 
public class CodeCampTester {

    public static void main(String[] args){
        final String newline = System.getProperty("line.separator");
        // CS314 Students: add tests here.
        //CodeCamp.bDayExperiment();
        //test 1, hamming distance
        int[] h1 = {};
        int[] h2 = {};
        int expected = 0;
        int actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("Test 1 hamming distance: expected value: " + 
                expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 1, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 1, hamming distance");
        
        // test 2, hamming distance
        h1 = new int[10000];
        h2 = new int[10000];
        expected = 0;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 2 hamming distance: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 2, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 2, hamming distance");
        
        // test 3, hamming distance
        h1 = new int[] {3, 5, 2};
        h2 = new int[] {3, 6, 2};
        expected = 1;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println(newline + "Test 3 hamming distance: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 3, hamming distance");
        else
            System.out.println(" ***** FAILED ***** test 3, hamming distance");
        
        //test 4, isPermutation
        int[] a = {5, 3, 6};
        int[] b = {3, 6};
        boolean expectedBool = false;
        boolean actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 4 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 4, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 4, isPermutation");

        //test 5, is Permutation
        b = new int[]{};
        a = new int[]{};
        expectedBool = true;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 5 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 5, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 5, isPermutation");
        
        //test 6, is Permutation
        a = new int[]{10, 15, 7};
        b = new int[]  {7, 15, 6};
        expectedBool = false;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 6 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 6, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 6, isPermutation");    
        
        
        //test 7, is Permutation
        a = new int[100000];
        b = new int[100000];
        expectedBool = true;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 7 isPermutation: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 7, isPermutation");
        else
            System.out.println(" ***** FAILED ***** test 7, isPermutation");   
        
        
        
        
        
        // test 8, mostVowels
        String[] sList = {"aaaeyiuoaaa", "aieoxiju"};
        int expectedResult = 0;
        int actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 8 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 8, mostVowels");
        else
            System.out.println("***** FAILED ***** test 8, mostVowels");

        
        // test 9, mostVowels
        sList = new String[] {newline, "potAtO", "string", ""};
        expectedResult = 1;
        actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 9 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 9, mostVowels");
        else
            System.out.println("***** FAILED ***** test 9, mostVowels");
        
        
       // test 10, mostVowels
        sList = new String[] {null, null, "a", "a", null};
        expectedResult = 2;
        actualResult = CodeCamp.mostVowels(sList);
        System.out.println(newline + "Test 10 mostVowels: expected result: " 
                + expectedResult + ", actual result: " + actualResult);
        if( actualResult == expectedResult )
            System.out.println("passed test 10, mostVowels");
        else
            System.out.println("***** FAILED ***** test 10, mostVowels"); 
        
        
        
 
        
        //test 11, sharedBirthdays, simple test
        int pairs = CodeCamp.sharedBirthdays(1, 2);
        System.out.println(newline + "Test 11 shared birthdays: expected: 0, actual: " + pairs);
        int expectedShared = 0;
        if( pairs == expectedShared )
            System.out.println("passed test 11, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 11, shared birthdays");
 
   
        //test 12, sharedBirthdays, stress test
        pairs = CodeCamp.sharedBirthdays(100000, 200);
        System.out.println(newline + "Test 12 shared birthdays - stress test. (Is solution slow?) : expected: > 0" +
                ", actual: " + pairs);
        if( pairs > 0 )
            System.out.println("passed test 12, shared birthdays");
        else
            System.out.println("***** FAILED ***** test 12, shared birthdays. " +
                    "Expected at least 1 pair. Value returned: " + pairs);
        
        
 
        
        //test 13, queensAreASafe
        char[][] board = { {'.', '.', '.'},
                          {'q', '.', 'q'},
                          {'.', '.', '.'}};
        
        expectedBool = false;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 13 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 13, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 13, queensAreSafe");

        //test 14, queensAreASafe
        board = new char[][]{{'.', '.', '.', 'q'},
                             {'.', '.', '.', '.'},
                             {'.', '.', 'q', '.'},
                             {'.', '.', '.', '.'}};
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 14 queensAreSafe: expected value: " 
                + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
            System.out.println(" passed test 14, queensAreSafe");
        else
            System.out.println(" ***** FAILED ***** test 14, queensAreSafe");
        
        

                
        // test 15, getValueOfMostValuablePlot
        int[][] city = {{0, 100, -7, -2, -1},
                          {9, 2, -6, 2, 0},
                          {-4, -6, 5, 1, 0},
                          {-1, -8, 0, -2, 1},
                          {-10, 1, -1, -5, -6},
                          {-15, -1, -1, -5, 4}};
        
        expected = 111;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 15 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 15, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 15, getValueOfMostValuablePlot");


        // test 16, getValueOfMostValuablePlot
        city[0][2] = 8;
        expected = 113;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 16 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 16, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 16, getValueOfMostValuablePlot");
        
        
        // test 17, getValueOfMostValuablePlot
        city = new int[][]{{1},
        				   {2}};
        expected = 3;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 17 getValueOfMostValuablePlot: expected value: " 
                + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 17, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 17, getValueOfMostValuablePlot");
        
        
        // test 18, getValueOfMostValuablePlot
        city = new int[60][60];
        Random rand = new Random();
        for(int row = 0; row < city.length; row++) {
            for(int col = 0; col < city[row].length; col++) {
                city[row][col] = rand.nextInt(200) - 100;
            }
        }
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println("\nTest 18 getValueOfMostValuablePlot: expected value: > 0" 
                    + ", actual value: " + actual);
        if( actual > 0 )          
            System.out.println(" passed test 18, getValueOfMostValuablePlot");
        else
            System.out.println(" ***** FAILED ***** test 18, getValueOfMostValuablePlot");
        
        // DELETE THE ABOVE TESTS IN THE VERSION OF THE FILE YOU TURN IN
        
        
        
    } // end of main method
    
    // pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if(list == null)
            throw new IllegalArgumentException("list parameter may not be null.");
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for(int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
}