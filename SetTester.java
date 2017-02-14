/*  Student information for assignment:
 *
 *  On MY honor, Varun Rao, this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 2
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: vr8546
 *  email address: varunsatishrao@gmail.com
 *  Grader name: Rohit
 *  Section number: 51352
 *  
 *  Student 2 NO SECOND STUDENT
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Section number:
 *  
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/*
CS 314 Students, put your results to the experiments and answers to
questions here:
+-----------+-----------------+--------------------------+----------------+------------------+--------------+--------------+
| file size | number of words | number of distinct words | SortedSet time | UnsortedSet time | HashSet time | TreeSet time |
+-----------+-----------------+--------------------------+----------------+------------------+--------------+--------------+
| 6kb       | 488             | 143                      | 0.006954231    | 0.002033781      | 7.4089E-4    | .001544447   |
| 29x       | 62.2x           | 44.26x                   | 11.3x          | 117.33x          | 10.51x       | 22.67x       |
| 2x        | 2x              | 1.5x                     | 1x             | 2x               | 5x           | 1.3          |
| 2x        | 2x              | 1.43x                    | 2.4x           | 2.2x             | 2.2          | 1.99         |
+-----------+-----------------+--------------------------+----------------+------------------+--------------+--------------+

1.	SortedSet: HashSet: O(N), TreeSet: (NlogM), UnsortedSet: O(NM), SortedSet: O(NM)

2. O(N) for our sets. O(1) for HashSet. O(logN) for TreeSet.

3. TreeSet is in asciibetical order, HashSet is not

CS314 Students, why is it unwise to implement all three of the
intersection, union, and difference methods in the AbstractSet class:

You must implement the method in terms of one of the other methods, so if you implemented all three, it would be turtles all the way down

*/

public class SetTester {

	public static void main(String[] args) {

		// Unsorted
		int testCounter = 0;
		UnsortedSet<Integer> us1 = new UnsortedSet<Integer>();


		Object expected = "()";
		Object actual = us1.toString();
		testOut(actual, expected, ++testCounter, "constructor for UnsortedSet");

		us1.add(1);
		us1.add(2);
		us1.add(2);
		us1.add(3);
		expected = "(1, 2, 3)";
		actual = us1.toString();
		testOut(actual, expected, ++testCounter, "add for UnsortedSet");

		UnsortedSet<Integer> us2 = new UnsortedSet<Integer>();
		us2.add(1);
		us2.add(2);
		us1 = (UnsortedSet<Integer>) us1.intersection(us2);
		expected = "(1, 2)";
		actual = us1.toString();
		testOut(actual, expected, ++testCounter, "intersection for UnsortedSet");

		Iterator<Integer> it = us1.iterator();
		it.next();
		it.remove();
		it.next();
		it.remove();
		expected = "()";
		actual = us1.toString();
		testOut(actual, expected, ++testCounter, "iterator for UnsortedSet");

		actual = us1.size();
		testOut(actual, 0, ++testCounter, "size for UnsortedSet");

		us1.add(1);
		us1.add(7);
		ISet<Integer> result = new UnsortedSet<Integer>();
		result.add(1);
		result.add(2);
		result.add(7);
		expected = result;
		actual = us1.union(us2);
		testOut(actual, result, ++testCounter, "union for UnsortedSet");

		// SortedSet

		SortedSet<Integer> ss1 = new SortedSet<Integer>();

		expected = "()";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "empty constructor for SortedSet");

		ss1 = new SortedSet<Integer>(us1);
		expected = "(1, 7)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "constructor with set param for SortedSet");

		ss1.add(3);
		expected = 1;
		actual = ss1.min();
		testOut(actual, expected, ++testCounter, "min for SortedSet");

		expected = 7;
		actual = ss1.max();
		testOut(actual, expected, ++testCounter, "max for SortedSet");

		ss1.add(1);
		ss1.add(4);
		expected = "(1, 3, 4, 7)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "add for SortedSet");

		ss1.clear();
		expected = "()";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "clear for SortedSet");

		ss1.add(3);
		SortedSet<Integer> ss2 = new SortedSet<Integer>();
		ss2.add(1);
		ss2.add(3);
		ss2.add(5);
		ss1.addAll(ss2);
		expected = "(1, 3, 5)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "addAll for SortedSet");

		ss1.addAll(us1);
		expected = "(1, 3, 5, 7)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "addAll for SortedSet");

		us1.add(-6);
		ss1 = (SortedSet<Integer>) ss1.intersection(us1);
		expected = "(1, 7)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "intersection for SortedSet");

		Iterator<Integer> it1 = ss1.iterator();
		while (it1.hasNext()) {
			it1.next();
			it1.remove();
		}
		expected = "()";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "iterator for SortedSet");

		ss1.add(4);
		expected = 1;
		actual = ss1.size();
		testOut(actual, expected, ++testCounter, "size for SortedSet");

		ss2.add(-1);
		ss1.remove(4);
		ss1 = (SortedSet<Integer>) ss1.union(ss2);
		expected = "(-1, 1, 3, 5)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "union for SortedSet");
		
		

		ss1.remove(-1);
		expected = "(1, 3, 5)";
		actual = ss1.toString();
		testOut(actual, expected, ++testCounter, "remove for SortedSet");

		ss2.clear();
		ss2.add(1);
		ss2.add(3);
		ss2.add(5);
		expected = true;
		actual = ss1.equals(ss2) && !ss1.equals(us2);
		testOut(actual, expected, ++testCounter, "equals for SortedSet");
		
		ss2.remove(3);
		expected = true;
		actual = ss1.containsAll(ss2) && !ss1.containsAll(us2);
		testOut(actual, expected, ++testCounter, "containsAll for SortedSet");

		// AbstractSet
		AbstractSet<Integer> as1 = new UnsortedSet<Integer>();
		as1.clear();
		as1.addAll(ss1);
		expected = "(1, 3, 5)";
		actual = as1.toString();
		testOut(actual, expected, ++testCounter, "addAll for AbstractSet");

		expected = true;
		actual = as1.contains(3) && !as1.contains(15);
		testOut(actual, expected, ++testCounter, "contains for AbstractSet");

		ss2.add(11);
		ss1.remove(1);
		expected = true;
		actual = as1.containsAll(ss1) && !as1.containsAll(ss2);
		testOut(actual, expected, ++testCounter, "containsAll for AbstractSet");

		as1.clear();
		expected = "()";
		actual = as1.toString();
		testOut(actual, expected, ++testCounter, "clear for AbstractSet");

		expected = 0;
		actual = as1.size();
		testOut(actual, expected, ++testCounter, "size for AbstractSet");

		as1.add(1);
		ss1.clear();
		ss1.add(1);
		expected = true;
		actual = as1.equals(ss1) && !as1.equals(ss2);
		testOut(actual, expected, ++testCounter, "equals for AbstractSet");

		as1.add(5);
		as1.add(11);
		as1 = (AbstractSet<Integer>) as1.difference(ss1);
		expected = "(5, 11)";
		actual = as1.toString();
		testOut(actual, expected, ++testCounter, "difference for AbstractSet");

		as1.remove(5);
		as1.add(11);
		expected = "(11)";
		actual = as1.toString();
		testOut(actual, expected, ++testCounter, "remove for AbstractSet");

		// CS314 Students. Uncomment this section when ready to
		// run your experiments

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Unable to change look and feel");
		}
		Scanner sc = new Scanner(System.in);
		String response = "";
		do {
			largeTest();
			System.out.print("Another file? Enter y to do another file: ");
			response = sc.next();
		} while (response != null && response.length() > 0 && response.substring(0, 1).equalsIgnoreCase("y"));

	}

	private static void testOut(Object actual, Object expected, int testNum, String msg) {
		if (actual.equals(expected)) {
			System.out.printf("Passed test %02d: %s.%n", testNum, msg);
		} else {
			System.out.println("FAILED test " + testNum + ": " + msg);
			System.out.println("\tExpected: " + expected);
			System.out.println("\tActual: " + actual);
		}
	}

	/*
	 * Method asks user for file and compares run times to add words from file
	 * to various sets, including CS314 UnsortedSet and SortedSet and Java's
	 * TreeSet and HashSet.
	 */
	private static void largeTest() {
		System.out.println();
		System.out.println("Opening Window to select file. You may have to minimize other windows.");
		String text = convertFileToString();
		System.out.println();
		System.out.println("***** CS314 SortedSet: *****");
		processTextCS314Sets(new SortedSet<String>(), text);
		System.out.println("****** CS314 UnsortedSet: *****");
		processTextCS314Sets(new UnsortedSet<String>(), text);
		System.out.println("***** Java HashSet ******");
		processTextJavaSets(new HashSet<String>(), text);
		System.out.println("***** Java TreeSet ******");
		processTextJavaSets(new TreeSet<String>(), text);
	}

	/*
	 * pre: set != null, text != null Method to add all words in text to the
	 * given set. Words are delimited by white space. This version for CS314
	 * sets.
	 */
	private static void processTextCS314Sets(ISet<String> set, String text) {
		Stopwatch s = new Stopwatch();
		Scanner sc = new Scanner(text);
		int totalWords = 0;
		s.start();
		while (sc.hasNext()) {
			totalWords++;
			set.add(sc.next());
		}
		s.stop();
		sc.close();

		showResultsAndWords(set, s, totalWords, set.size());
	}

	/*
	 * pre: set != null, text != null Method to add all words in text to the
	 * given set. Words are delimited by white space. This version for Java
	 * Sets.
	 */
	private static void processTextJavaSets(Set<String> set, String text) {
		Stopwatch s = new Stopwatch();
		Scanner sc = new Scanner(text);
		int totalWords = 0;
		s.start();
		while (sc.hasNext()) {
			totalWords++;
			set.add(sc.next());
		}
		s.stop();
		sc.close();

		showResultsAndWords(set, s, totalWords, set.size());
	}

	/*
	 * Show results of add words to given set.
	 */
	private static <E> void showResultsAndWords(Iterable<E> set, Stopwatch s, int totalWords, int setSize) {

		System.out.println("Time to add the elements in the text to this set: " + s.toString());
		System.out.println("Total number of words in text including duplicates: " + totalWords);
		System.out.println("Number of distinct words in this text " + setSize);

		System.out.print("Enter y to see the contents of this set: ");
		Scanner sc = new Scanner(System.in);
		String response = sc.next();

		if (response != null && response.length() > 0 && response.substring(0, 1).equalsIgnoreCase("y")) {
			for (Object o : set)
				System.out.println(o);
		}
		System.out.println();
	}

	/*
	 * Ask user to pick a file via a file choosing window and convert that file
	 * to a String. Since we are evalutatin the file with many sets convert to
	 * string once instead of reading through file multiple times.
	 */
	private static String convertFileToString() {
		// create a GUI window to pick the text to evaluate
		JFileChooser chooser = new JFileChooser(".");
		StringBuilder text = new StringBuilder();
		int retval = chooser.showOpenDialog(null);

		chooser.grabFocus();

		// read in the file
		if (retval == JFileChooser.APPROVE_OPTION) {
			File source = chooser.getSelectedFile();
			try {
				Scanner s = new Scanner(new FileReader(source));

				while (s.hasNextLine()) {
					text.append(s.nextLine());
					text.append(" ");
				}

				s.close();
			} catch (IOException e) {
				System.out.println("An error occured while trying to read from the file: " + e);
			}
		}

		return text.toString();
	}
}