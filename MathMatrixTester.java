import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: vr8546
 *  email address: varunsatishrao@gmail.com
 *  Grader name:  Rohit
 *  Number of slip days I am using: 0
 */



/* CS314 Students. Put your experiment results and
* answers to questions here.
* 
* Experiment results for add:
* 	elapsed time: 2.319651413 seconds for 1000x1000 size tests. Average time: .002319651413 s
	elapsed time: 8.272401212 seconds for 2000x2000 size tests. Average time: .008272401212 s
	elapsed time: 35.56327575 seconds for 4000x4000 size tests. Average time: .03556327575 s
	
  Experiment results for multiply:
	elapsed time: 1.195439913 seconds.for 210x210 dimensions. Average time: 0.01195439913
	elapsed time: 11.990199115 seconds.for 420x420 dimensions. Average time: 0.11990199115
	elapsed time: 219.751017888 seconds.for 840x840 dimensions. Average time: 2.19751017888


	Questions:
		1. Around 142.253103 seconds
		2. n^2, which my data seems to indicate is true
		3. Around 1758.0081431 seconds
		4. n^3, which my data roughly fits
		5. I can make a 4478x100000 matrix. This means the program is allocated around 1791.2 mb
*/

/**
 * A class to run tests on the MathMatrix class
 */ 
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        
        // CS314 Students. When ready delete the above tests 
        // and add your 24 tests here.
		int[][] data1 = { { 3, 2, 3 }, { 2, 6, 4 } };
		int[][] data2 = { { 5, 4, 3 }, { 5, 6, 8 } };
		int[][] e1;

		// test 1, specify size and values constructor
		MathMatrix mat1 = new MathMatrix(1, 3, 0);
		e1 = new int[][] { { 0, 0, 0 }};
		printTestResult(get2DArray(mat1), e1, 1, "Constructor with size and initial val specified.");
		
		// test 2, specify size and values constructor
		MathMatrix mat2 = new MathMatrix(1, 2, 5);
		e1 = new int[][] { { 5, 5 } };
		printTestResult(get2DArray(mat2), e1, 2, "Constructor with size and initial val specified.");

		// test 3, int[][] constructor, deep copy
		mat1 = new MathMatrix(data1);
		data1[0][0] = 2;
		// data1 altered. mat1 should be unchanged if deep copy made
		e1 = new int[][] { { 3, 2, 3 }, { 2, 6, 4 } };
		printTestResult(get2DArray(mat1), e1, 3,
				"constructor with one parameter of type int[][]. Testing deep copy made.");
		
		// test 4, int[][] constructor, deep copy, should test with new data1
		mat1 = new MathMatrix(data1);
		data1[0][2] = 2;
		// data1 altered. mat1 should be unchanged if deep copy made
		e1 = new int[][] { { 2, 2, 3 }, { 2, 6, 4 } };
		printTestResult(get2DArray(mat1), e1, 4,
				"constructor with one parameter of type int[][]. Testing deep copy made.");
		
		// test 5, changeElement method
		mat1.changeElement(0, 0, 5);
		e1 = new int[][] { { 5, 2, 3 }, { 2, 6, 4 } };
		printTestResult(get2DArray(mat1), e1, 5, "changeElement method. Testing if value changed.");

		// test 6, changeElement method
		mat1.changeElement(1, 2, 5);
		e1 = new int[][] { { 5, 2, 3 }, { 2, 6, 5 } };
		printTestResult(get2DArray(mat1), e1, 6, "changeElement method. Testing if value changed.");
				
		// test 7, numRows() method
		int expected = 2;
		if(mat1.numRows() == expected){		
			System.out.println("Test 7: numRows() method. Testing if correct number of rows...passed");
		}
		else{
			System.out.println("Test 7: numRows() method. Testing if correct number of rows...failed");
		}
		// test 8, numRows() method
		expected = 1;
		mat1 = new MathMatrix(1, 2, 3);
		if(mat1.numRows() == expected){		
			System.out.println("Test 8: numRows() method. Testing if correct number of rows...passed");
		}
		else{
			System.out.println("Test 8: numRows() method. Testing if correct number of rows...failed");
		}
		
		// test 9, numCols() method
		expected = 2;
		if (mat1.numCols() == expected) {
			System.out.println("Test 9: numCols() method. Testing if correct number of rows...passed");
		} 
		else {
			System.out.println("Test 9: numCols() method. Testing if correct number of rows...failed");
		}
		
		// test 10, numRows() method
		expected = 3;
		mat1 = new MathMatrix(1, 3, 3);
		if (mat1.numCols() == expected) {
			System.out.println("Test 10: numCols() method. Testing if correct number of rows...passed");
		} 
		else {
			System.out.println("Test 10: numCols() method. Testing if correct number of rows...failed");
		}
		
		// test 11, getVal() method
		expected = 3;
		if (mat1.getVal(0, 0) == expected) {
			System.out.println("Test 11: getVal() method. Testing if correct value...passed");
		} else {
			System.out.println("Test 11: getVal() method. Testing if correct value...failed");
		}
		
		// test 12, getVal() method
		expected = -1;
		mat1 = new MathMatrix(2, 1, -1);
		if (mat1.getVal(1, 0) == expected) {
			System.out.println("Test 12: getVal() method. Testing if correct value...passed");
		} else {
			System.out.println("Test 12: getVal() method. Testing if correct value...failed");
		}
		
		//tests 13 - 14, addition
		int[][] data3 = { { 3, 2, 3 }, { 2, 6, 4 } };
		int[][] data4 = { { 5, 4, 3 }, { 5, 6, 8 } };
        mat1 = new MathMatrix(data3);
        mat2 = new MathMatrix(data4);
        MathMatrix mat3 = mat1.add(mat1);
        e1 = new int[][] { { 3, 2, 3 }, { 2, 6, 4 } };
        printTestResult( get2DArray(mat1), e1, 13, "add method. Testing mat1 unchanged.");
        e1 = new int[][] { {6, 4, 6}, {4, 12, 8} };
        printTestResult( get2DArray(mat3), e1, 14, "add method. Testing mat3 correct result.");
        
		// tests 15 - 16, subtract
		mat3 = mat1.subtract(mat2);
		e1 = new int[][] { { 3, 2, 3 }, { 2, 6, 4 } };
		printTestResult(get2DArray(mat1), e1, 15, "subtract method. Testing mat1 unchanged.");
		e1 = new int[][] { { -2, -2, 0 }, { -3, 0, -4 } };
		printTestResult(get2DArray(mat3), e1, 16, "subtract method. Testing mat3 correct result.");
		
		// test 17, multiplication
		data1 = new int[][] { { 1, 0, -2 }, { 0, 3, -1 } };
		data2 = new int[][] { { 0, 3 }, { -2, -1 }, { 0, 4 } };
		mat2 = new MathMatrix(data2);
		mat1 = new MathMatrix(data1);
		mat3 = mat1.multiply(mat2);
		e1 = new int[][] { { 0, -5 }, { -6, -7 } };
		printTestResult(get2DArray(mat3), e1, 17, "multiply method");

		// test 18, multiplication
		data1 = new int[][] { {3, 4, 2} };
		data2 = new int[][] { {13, 9, 7, 15}, {8, 7, 4, 6}, {6, 4, 0, 3} };
		mat2 = new MathMatrix(data2);
		mat1 = new MathMatrix(data1);
		mat3 = mat1.multiply(mat2);
		e1 = new int[][] { {83, 63, 37, 75} };
		printTestResult(get2DArray(mat3), e1, 18, "multiply method");
		
		// test 19, scale
		mat1.scale(2);
		e1 = new int[][] { { 6, 8, 4 } };
		printTestResult(get2DArray(mat1), e1, 19, "scale method");
		
		// test 20, scale
		mat1.scale(-1);
		e1 = new int[][] { { -6, -8, -4 } };
		printTestResult(get2DArray(mat1), e1, 20, "scale method");
		
		// test 21, getTranspose
		mat1 = mat1.getTranspose();
		e1 = new int[][] { { -6 }, { -8 }, { -4 } };
		printTestResult(get2DArray(mat1), e1, 21, "getTranspose() method...");
		
		// test 22, getTranspose
		mat1 = new MathMatrix(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } });
		mat1 = mat1.getTranspose();
		e1 = new int[][] { { 1, 3, 5 }, { 2, 4, 6 } };
		printTestResult(get2DArray(mat1), e1, 22, "getTranspose() method...");
		
		// test 23, equals
		mat1 = new MathMatrix(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } });
		mat2 = new MathMatrix(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } });
		e1 = new int[][] { { 1, 3, 5 }, { 2, 4, 6 } };
		if (mat1.equals(mat2)) {
			System.out.println("Test 23: equals() method. Testing if correct value...passed");
		} else {
			System.out.println("Test 23: equals() method. Testing if correct value...failed");
		}
        
		// test 24, equals
		mat1 = new MathMatrix(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } });
		mat2 = new MathMatrix(new int[][] { { 1, 3 }, { 3, 4 }, { 5, 6 } });
		e1 = new int[][] { { 1, 3, 5 }, { 2, 4, 6 } };
		if (!mat1.equals(mat2)) {
			System.out.println("Test 24: equals() method. Testing if correct value...passed");
		} else {
			System.out.println("Test 24: equals() method. Testing if correct value...failed");
		}
		
		//test 25, toString()
        data1 = new int[][] {{10, 200, 101, -1565},
                          {1050, 10, 45, 4},
                          {1, -2, 4, -1000}};
        mat1 = new MathMatrix(data1);
        String eString = "|    10   200   101 -1565|\n|  1050    10    45     4|\n|     1    -2     4 -1000|\n";
        if( mat1.toString().equals( eString ) )
            System.out.println("passed test 25, toString method.");
        else
            System.out.println("failed test 25, toString method.");
        
      //test 26, toString()
        data1 = new int[][] {{10, 200, 101, -4},
                          {1050, 10, 45, 4},
                          {1, -2, 4, -1000}};
        mat1 = new MathMatrix(data1);
        eString = "|    10   200   101    -4|\n|  1050    10    45     4|\n|     1    -2     4 -1000|\n";
        if( mat1.toString().equals( eString ) )
            System.out.println("passed test 26, toString method.");
        else
            System.out.println("failed test 26, toString method.");
        
      //test 27, upperTriangular
        data1 = new int[][] {{1, 6, 3, 0}, {0, -3, 4, 1}, {0, 0, 8, -1}, {0, 0, 0, 12}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular())
            System.out.println("Passed test 27, upperTriangular method.");
        else
            System.out.println("Failed test 27, upperTriangular method.");
        
        //test 28, upperTriangular
        data1 = new int[][] {{1}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular())
            System.out.println("Passed test 28, upperTriangular method.");
        else
            System.out.println("Failed test 28, upperTriangular method.");  
        
        
		/*experimenter(1000, true);
		experimenter(2000, true);
		experimenter(4000, true);*/
		
		
		/*experimenter(200, false);
		experimenter(400, false);
		experimenter(800, false);*/
		
		//int[][] test = new int[4478][100000];
    	

    }
    
    private static void experimenter(int size, boolean add) {
		Random randNumGen = new Random(6201919);
		Stopwatch s = new Stopwatch();
		
		//code to time
		//make two new Math Matrices
		final int LIMIT = 1000;
        MathMatrix mat1 = createMat(randNumGen, size, size, LIMIT);
        MathMatrix mat2 = createMat(randNumGen, size, size, LIMIT);
        
		if (add) {
			//s.start();
			for (int i = 0; i < 1000; i++) {
				mat1.add(mat2);
			}
			//s.stop();
		} else {
			//s.start();
			for (int i = 0; i < 100; i++) {
				mat1.multiply(mat2);
			}
			//s.stop();
		}
		
		System.out.print(s.toString() + "for " + size + "x"  + size + " dimensions. ");
		if(add){
			System.out.println("Average time: " + s.time()/1000);
		}
		else{
			System.out.println("Average time: " + s.time()/100);
		}
	}

	// method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if(mat == null)
            throw new IllegalArgumentException("mat may not be null");
        
        int result = 0;
        final int ROWS =  mat.numRows();
        final int COLS = mat.numCols();
        for(int r = 0; r < ROWS; r++)
            for(int c = 0; c < COLS; c++) 
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
        return result;
    }
    
    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    private static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {
        
        if(randNumGen == null)
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        else if(rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
            		"rows: " + rows + ", cols: " + cols);
        
        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
        
        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
        System.out.print( "Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println( result );
    }

    // pre: m != null, m is at least 1 by 1 in size
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
                : "Violation of precondition: get2DArray";

        int[][] result = new int[m.numRows()][m.numCols()];
        for(int r = 0; r < result.length; r++)
        {   for(int c = 0; c < result[0].length; c++)
            {   result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
       //check precondition
        if( ( data1 == null ) || ( data1.length == 0 )
               || ( data1[0].length == 0 ) || !rectangularMatrix(data1)
               ||  ( data2 == null ) || ( data2.length == 0 )
               || ( data2[0].length == 0 ) || !rectangularMatrix(data2))
                throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");

        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while( result && row < data1.length ) {
            int col = 0;
            while( result && col < data1[0].length ) {
               result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        return MathMatrix.rectangularMatrix(mat);
    }
}
