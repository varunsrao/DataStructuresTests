import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
 *
 *  On my honor, Varun, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: vr8546
 *  email address: varunsatishrao@gmail.com
 *  Grader name: Rohit
 *  Number of slip days I am using: 0
 */

public class AnagramFinderTester {

    
    private static final String testCaseFileName = "testCaseAnagrams.txt";
    private static final String dictionaryFileName = "d3.txt";

    /**
     * main method that executes tests.
     * @param args Not used.
     */
    public static void main(String[] args) {

    	cs314StudentTestsForLetterInventory();
    	weirdAnagrams();
        // tests on the anagram solver itself
        boolean displayAnagrams = getChoiceToDisplayAnagrams();
        AnagramSolver solver = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
        runAnagramTests(solver, displayAnagrams);
    }

    
    private static void cs314StudentTestsForLetterInventory() {
        // CS314 Students, delete the above tests when you turn in your assignment
        // CS314 Students add your LetterInventory tests here. 
    	LetterInventory lets1 = new LetterInventory("A");
        Object expected = 1;
        Object actual = lets1.size();
        showTestResults(expected, actual, 1, " size of LetterInventory with 1 letter, tests constructor");
        
        expected = "a";
        actual = "a";
        showTestResults(expected, actual, 2, " toString of LetterInventory with 1 letter, tests constructor");
        
        expected = 1;
        actual = lets1.get('a');
        showTestResults(expected, actual, 3, " get of LetterInventory");
        
        expected = 0;
        actual = lets1.get('Z');
        showTestResults(expected, actual, 4, " get of LetterInventory");
        
        lets1 = new LetterInventory("kappa");
        expected = 5;
        actual = lets1.size();
        showTestResults(expected, actual, 5, " size of LetterInventory");
        
        lets1 = lets1.add(new LetterInventory("Z"));
        expected = 6;
        actual = lets1.size();
        showTestResults(expected, actual, 6, " size of LetterInventory");
        
        expected = false;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, 7, " isEmpty of LetterInventory");
        
        lets1 = new LetterInventory("");
        expected = true;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, 8, " isEmpty of LetterInventory");
        
        expected = "";
        actual = lets1.toString();
        showTestResults(expected, actual, 9, " toString of LetterInventory");
        
        
        lets1 = new LetterInventory("ZAaaVH($@&#((())~~~\n\\n");
        expected = "aaahnvz";
        actual = lets1.toString();
        showTestResults(expected, actual, 10, " toString of LetterInventory");
        
        lets1.add(new LetterInventory("\n"));
        LetterInventory lets2 = new LetterInventory("aaahnvz");
        expected = true;
        actual = lets1.size() == 7;
        showTestResults(expected, actual, 11, " add of LetterInventory for size");
        
        lets2 = lets1.add(lets2);
        expected = "aaaaaahhnnvvzz";
        actual = lets2.toString();
        showTestResults(expected, actual, 12, " add of LetterInventory for toString");
        
        lets1 = lets2.subtract(new LetterInventory("\n"));
        expected = 14;
        actual = lets1.size();
        showTestResults(expected, actual, 13, " subtract of LetterInventory for size");
        
        lets1 = lets2.subtract(new LetterInventory("a"));
        expected = 13;
        actual = lets1.size();
        showTestResults(expected, actual, 14, " subtract of LetterInventory for size");
        
        lets1 = lets1.subtract(new LetterInventory("aaaaaahhnnvvzz"));
        expected = true;
        actual = lets1 == null;
        showTestResults(expected, actual, 15, " subtract of LetterInventory");
        
        expected = false;
        actual = lets2.equals(lets1);
        showTestResults(expected, actual, 16, " subtract of LetterInventory");
        
        lets1 = new LetterInventory("Varun");
        lets2 = new LetterInventory("Varun");
        expected = true;
        actual = lets2.equals(lets1);
        showTestResults(expected, actual, 17, " subtract of LetterInventory");
        
     	
    }
    
    private static void weirdAnagrams() {
    	//ArrayList<String> weirdDict = new ArrayList<String>(Arrays.asList(new String[]{"a", "b", "c", "va", "ru", "n", "v"}));
    	AnagramSolver sendHelp = new AnagramSolver(new ArrayList<String>(Arrays.asList(new String[]{"a", "b", "c", "va", "ru", "n", "v", "r", "u"})));
    	
    	
    	Object expected = 1;
        Object actual = sendHelp.getAnagrams("aa", 0).size();
        showTestResults(expected, actual, 1, " weirdDict test, aa");
        
        expected = 4;
        actual = sendHelp.getAnagrams("Varun", 0).size();
        showTestResults(expected, actual, 2, " weirdDict test, Varun");
        
        expected = 1;
        actual = sendHelp.getAnagrams("cab", 0).size();
        showTestResults(expected, actual, 3, " weirdDict test, cab");
        
        Stopwatch st = new Stopwatch();
        sendHelp = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
        expected = 4998;
        st.start();
        actual = sendHelp.getAnagrams("dark knight inception memento", 4).size();
        st.stop();
        showTestResults(expected, actual, 3, " weirdDict test, cab" + st.time());
    }
    
    

    private static boolean getChoiceToDisplayAnagrams() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter y or Y to display anagrams during tests: ");
        String response = console.nextLine();
        console.close();
        return response.length() > 0 && response.toLowerCase().charAt(0) == 'y';
    }

    private static boolean showTestResults(Object expected, Object actual, int testNum, String featureTested) {
        System.out.println("Test Number " + testNum + " testing " + featureTested);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);
        boolean passed = (actual == null && expected == null) || (actual != null && actual.equals(expected));
        if(passed)
            System.out.println("Passed test " + testNum);
        else
            System.out.println("!!! FAILED TEST !!! " + testNum);
        System.out.println();
        return passed;
    }

    /**
     * Method to run tests on Anagram solver itself.
     * pre: the files d3.txt and testCaseAnagrams.txt are in the local directory
     * 
     * assumed format for file is
     * <NUM_TESTS>
     * <TEST_NUM>
     * <MAX_WORDS>
     * <PHRASE>
     * <NUMBER OF ANAGRAMS>
     * <ANAGRAMS>
     */
    private static void runAnagramTests(AnagramSolver solver, boolean displayAnagrams) {
        int solverTestCases = 0;
        int solverTestCasesPassed = 0;
        Stopwatch st = new Stopwatch();
        try {
            Scanner sc = new Scanner(new File(testCaseFileName));
            final int NUM_TEST_CASES = Integer.parseInt(sc.nextLine().trim());
            System.out.println(NUM_TEST_CASES);
            for(int i = 0; i < NUM_TEST_CASES; i++) {
                // expected results
                TestCase currentTest = new TestCase(sc);
                solverTestCases++;
                st.start();
                // actual results
                List<List<String>> actualAnagrams = solver.getAnagrams(currentTest.phrase, currentTest.maxWords);
                st.stop();
                if(displayAnagrams) {
                    displayAnagrams("actual anagrams", actualAnagrams);
                    displayAnagrams("expected anagrams", currentTest.anagrams);
                }


                if(checkPassOrFailTest(currentTest, actualAnagrams))
                    solverTestCasesPassed++;
                System.out.println("Time to find anagrams: " + st.time());
            }
            sc.close();
        }
        catch(IOException e) {
            System.out.println("\nProblem while running test cases on AnagramSolver. Check" +
                    " that file testCaseAnagrams.txt is in the correct location.");
            System.out.println(e);
            System.out.println("AnagramSolver test cases run: " + solverTestCases);
            System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
        }
        System.out.println("\nAnagramSolver test cases run: " + solverTestCases);
        System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
    }


    // print out all of the anagrams in a list of anagram
    private static void displayAnagrams(String type,
            List<List<String>> anagrams) {

        System.out.println("Results for " + type);
        System.out.println("num anagrams: " + anagrams.size());
        System.out.println("anagrams: ");
        for(List<String> singleAnagram : anagrams)
            System.out.println(singleAnagram);
    }


    // determine if the test passed or failed
    private static boolean checkPassOrFailTest(TestCase currentTest,
            List<List<String>> actualAnagrams) {
        
        boolean passed = true;
        System.out.println();
        System.out.println("Test number: " + currentTest.testCaseNumber);
        System.out.println("Phrase: " + currentTest.phrase);
        System.out.println("Word limit: " + currentTest.maxWords);
        System.out.println("Expected Number of Anagrams: " + currentTest.anagrams.size());
        if(actualAnagrams.equals(currentTest.anagrams)) {
            System.out.println("Passed Test");
        }
        else{
            System.out.println("\n!!! FAILED TEST CASE !!!");
            System.out.println("Recall MAXWORDS = 0 means no limit.");
            System.out.println("Expected number of anagrams: " + currentTest.anagrams.size());
            System.out.println("Actual number of anagrams:   " + actualAnagrams.size());
            if(currentTest.anagrams.size() == actualAnagrams.size()) {
                System.out.println("Sizes the same, but either a difference in anagrams or anagrams not in correct order.");
            }
            System.out.println();
            passed = false;
        }  
        return passed;
    }

    // class to handle the parameters for an anagram test 
    // and the expected result
    private static class TestCase {

        private int testCaseNumber;
        private String phrase;
        private int maxWords;
        private List<List<String>> anagrams;

        // pre: sc is positioned at the start of a test case
        private TestCase(Scanner sc) {
            testCaseNumber = Integer.parseInt(sc.nextLine().trim());
            maxWords = Integer.parseInt(sc.nextLine().trim());
            phrase = sc.nextLine().trim();
            anagrams = new ArrayList<List<String>>();
            readAndStoreAnagrams(sc);
        }

        // pre: sc is positioned at the start of the resulting anagrams
        // read in the number of anagrams and then for each anagram:
        //  - read in the line
        //  - break the line up into words
        //  - create a new list of Strings for the anagram
        //  - add each word to the anagram
        //  - add the anagram to the list of anagrams
        private void readAndStoreAnagrams(Scanner sc) {
            int numAnagrams = Integer.parseInt(sc.nextLine().trim());
            for(int j = 0; j < numAnagrams; j++){
                String[] words = sc.nextLine().split("\\s+");
                ArrayList<String> anagram = new ArrayList<String>();
                for(String st : words)
                    anagram.add(st);
                anagrams.add(anagram);
            }
            assert anagrams.size() == numAnagrams : "Wrong number of angrams read or expected";
        }
    }
}