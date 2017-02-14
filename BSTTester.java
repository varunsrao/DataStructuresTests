/*  Student information for assignment:
 *
 *  UTEID: vr8546
 *  email address: varunsatishrao@gmail.com
 *  Grader name: Rohit
 *  Number of slip days I am using: 0
 */

/*
 * Place results of experiments here:
 * BST| For N = 1000: average time is 7.216447E-4, average height is 20, average size is 1000
BST| For N = 2000: average time is 4.787113E-4, average height is 24, average size is 2000
BST| For N = 4000: average time is 7.984003999999999E-4, average height is 26, average size is 4000
BST| For N = 8000: average time is 0.0016832452000000002, average height is 30, average size is 8000
BST| For N = 16000: average time is 0.0034554682000000002, average height is 32, average size is 16000
BST| For N = 32000: average time is 0.008371337, average height is 34, average size is 32000
BST| For N = 64000: average time is 0.019163164099999998, average height is 37, average size is 63999
BST| For N = 128000: average time is 0.0451321534, average height is 39, average size is 127999
BST| For N = 256000: average time is 0.1085551149, average height is 45, average size is 255991
BST| For N = 512000: average time is 0.29365239719999997, average height is 45, average size is 511972
BST| For N = 1024000: average time is 0.7498349555, average height is 49, average size is 1023876

For each value of N what is the minimum possible tree height, assuming N unique values are inserted into the tree?
log2(N + 1) - 1

TreeSet| For N = 1000: average time is 6.488892E-4, average size is 1000
TreeSet| For N = 2000: average time is 5.882669E-4, average size is 2000
TreeSet| For N = 4000: average time is 6.024891E-4, average size is 4000
TreeSet| For N = 8000: average time is 0.0013668895, average size is 8000
TreeSet| For N = 16000: average time is 0.0029702235, average size is 16000
TreeSet| For N = 32000: average time is 0.0076609812, average size is 31999
TreeSet| For N = 64000: average time is 0.016083029300000003, average size is 63999
TreeSet| For N = 128000: average time is 0.042983130200000004, average size is 127998
TreeSet| For N = 256000: average time is 0.11736298549999999, average size is 255992
TreeSet| For N = 512000: average time is 0.2992064441, average size is 511968
TreeSet| For N = 1024000: average time is 0.7168890297, average size is 1023875

The TreeSet is about as fast as my implementation of the BST

*****

BST| For sorted N = 1000: average time is 0.0022609343, average height is 999, average size is 1000
BST| For sorted N = 2000: average time is 0.0103917824, average height is 1999, average size is 2000
BST| For sorted N = 4000: average time is 0.0455305091, average height is 3999, average size is 4000
BST| For sorted N = 8000: average time is 0.1958135982, average height is 7999, average size is 8000
BST| For sorted N = 16000: average time is 0.8120171608, average height is 15999, average size is 16000
BST| For sorted N = 32000: average time is 3.5643681422, average height is 31999, average size is 32000
BST| For sorted N = 64000: average time is 12.98845734, average height is 63999, average size is 64000

I estimate that the time for 128,000, 256,000, and 512,000, and 1,024,000 sorted integers is 51.95382936, 207.81531744, 831.26126976, and 3325.04507904 seconds respectively when adding to BST

TreeSet| For sorted N = 1000: average time is 0.0014647561999999999
TreeSet| For sorted N = 2000: average time is 2.444445E-4
TreeSet| For sorted N = 4000: average time is 4.730668E-4
TreeSet| For sorted N = 8000: average time is 8.587114999999999E-4
TreeSet| For sorted N = 16000: average time is 0.0017195564
TreeSet| For sorted N = 32000: average time is 0.0038756461
TreeSet| For sorted N = 64000: average time is 0.0081861814

The TreeSet is a lot faster. This is because the TreeSet uses a red-black tree and this implementation does not.
 */

/**
 * Test class for binary search tree
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BSTTester {

	public static void main(String[] args) {

		  int testCounter = 0;
		  
		  BinarySearchTree<String> t = new BinarySearchTree<String>();
		  
		  Object actual = t.size(); Object expected = 0; testOut(actual,
		  expected, ++testCounter, "constructor, empty");
		  
		  actual = t.getAll(); expected = new ArrayList<String>();
		  testOut(actual, expected, ++testCounter, "constructor, empty");
		  
		  t.add("A"); actual = t.add("A"); expected = false; testOut(actual,
		  expected, ++testCounter, "add, return correctly?");
		  
		  actual = t.size(); expected = 1; testOut(actual, expected,
		  ++testCounter, "add, correct size?");
		  
		  t.add("B"); t.add("F"); t.add("E"); actual = t.remove("F"); expected
		  = true; testOut(actual, expected, ++testCounter,
		  "remove, correct return");
		  
		  t.remove("F"); actual = t.size(); expected = 3; testOut(actual,
		  expected, ++testCounter, "remove, correct size");
		  
		  actual = t.isPresent("A"); expected = true; testOut(actual, expected,
		  ++testCounter, "isPresent");
		  
		  actual = t.isPresent("D"); expected = false; testOut(actual,
		  expected, ++testCounter, "isPresent");
		  
		  t.add("D"); t.add("D"); actual = t.size(); expected = 4;
		  testOut(actual, expected, ++testCounter, "size");
		  
		  t.remove("D"); t.remove("D"); actual = t.size(); expected = 3;
		  
		  testOut(actual, expected, ++testCounter, "size");
		  
		  actual = t.height(); expected = 2; testOut(actual, expected,
		  ++testCounter, "height");
		  
		  t.add("G"); t.add("F"); t.add("E"); t.add("R"); t.add("I"); actual =
		  t.height(); expected = 5; testOut(actual, expected, ++testCounter,
		  "height");
		  
		  BinarySearchTree<Integer> t2 = new BinarySearchTree<Integer>();
		  actual = t2.getAll(); expected = new ArrayList<Integer>();
		  testOut(actual, expected, ++testCounter, "getAll");
		  
		  t2 = new BinarySearchTree<Integer>(); t2.add(5); t2.add(11);
		  t2.add(-1); t2.add(4); actual = t2.getAll().toString();
		  
		  expected = "[-1, 4, 5, 11]"; testOut(actual, expected, ++testCounter,
		  "getAll");
		  
		  actual = t2.max(); expected = 11; testOut(actual, expected,
		  ++testCounter, "max");
		  
		  t2.remove(11); actual = t2.max(); expected = 5; testOut(actual,
		  expected, ++testCounter, "max");
		  
		  actual = t2.min(); expected = -1; testOut(actual, expected,
		  ++testCounter, "min");
		  
		  t2.add(-2); actual = t2.min(); expected = -2; testOut(actual,
		  expected, ++testCounter, "min");
		  
		  t2.iterativeAdd(-2); actual = t2.iterativeAdd(-2); expected = false;
		  testOut(actual, expected, ++testCounter, "iterativeAdd");
		  
		  t2.iterativeAdd(15); actual = t2.size(); expected = 5;
		  testOut(actual, expected, ++testCounter, "iterativeAdd");
		  
		  actual = t2.get(0); expected = -2; testOut(actual, expected,
		  ++testCounter, "getkth");
		  
		  actual = t2.get(4); expected = 15; testOut(actual, expected,
		  ++testCounter, "getkth");
		  
		  actual = t2.getAllLessThan(0).toString(); expected = "[-2, -1]";
		  testOut(actual, expected, ++testCounter, "getAllLessThan");
		  
		  actual = t2.getAllLessThan(5).toString(); expected = "[-2, -1, 4]";
		  testOut(actual, expected, ++testCounter, "getAllLessThan");
		  
		  actual = t2.getAllGreaterThan(0).toString(); expected = "[4, 5, 15]";
		  testOut(actual, expected, ++testCounter, "getAllGreaterThan");
		  
		  actual = t2.getAllGreaterThan(5).toString(); expected = "[15]";
		  testOut(actual, expected, ++testCounter, "getAllGreaterThan");
		  
		  actual = t2.numNodesAtDepth(15); expected = 0; testOut(actual,
		  expected, ++testCounter, "numNodesAtDepth");
		  
		  actual = t2.numNodesAtDepth(1); expected = 2; testOut(actual,
		  expected, ++testCounter, "numNodesAtDepth");
	}

	private static void experiment() {
		/*int n = 1000;
		while (n <= 1_024_000) {
			Random r = new Random();
			Stopwatch st = new Stopwatch();
			int totalSize = 0;
			int totalHeight = 0;
			st.start();
			for (int i = 0; i < 10; i++) {
				BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
				for (int j = 0; j < n; j++) {
					b.add(new Integer(r.nextInt()));

				}
				totalSize += b.size();
				totalHeight += b.height();
			}
			st.stop();
			System.out.println("BST| For N = " + n + ": average time is " + st.time() / 10 + ", average height is "
					+ totalHeight / 10 + ", average size is " + totalSize / 10);
			n *= 2;
		}

		n = 1000;
		while (n <= 1_024_000) {
			Random r = new Random();
			Stopwatch st = new Stopwatch();
			int totalSize = 0;
			st.start();
			for (int i = 0; i < 10; i++) {
				TreeSet<Integer> b = new TreeSet<Integer>();
				for (int j = 0; j < n; j++) {
					b.add(new Integer(r.nextInt()));

				}
				totalSize += b.size();
			}
			st.stop();
			System.out.println("TreeSet| For N = " + n + ": average time is " + st.time() / 10 + ", average size is "
					+ totalSize / 10);
			n *= 2;
		}

		n = 1000;
		while (n <= 64_000) {
			Stopwatch st = new Stopwatch();
			int totalSize = 0;
			int totalHeight = 0;
			st.start();
			for (int i = 0; i < 10; i++) {
				BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
				for (int j = 0; j < n; j++) {
					b.add(j);

				}
				totalSize += b.size();
				totalHeight += b.height();
			}
			st.stop();
			System.out.println("BST| For sorted N = " + n + ": average time is " + st.time() / 10
					+ ", average height is " + totalHeight / 10 + ", average size is " + totalSize / 10);
			n *= 2;
		} 

		n = 1000;
		while (n <= 64_000) {
			Stopwatch st = new Stopwatch();
			int totalSize = 0;
			st.start();
			for (int i = 0; i < 10; i++) {
				TreeSet<Integer> b = new TreeSet<Integer>();
				for (int j = 0; j < n; j++) {
					b.add(j);

				}
				totalSize += b.size();
			}
			st.stop();
			System.out.println("TreeSet| For sorted N = " + n + ": average time is " + st.time() / 10);
			n *= 2;
		}*/

	}

	private static void testOut(Object actual, Object expected, int testNum, String msg) {
		if (actual.equals(expected)) {
			System.out.printf("Passed test %02d: %s.%n", testNum, msg);
		} else {
			System.out.println("***FAILED test*** " + testNum + ": " + msg);
			System.out.println("\tExpected: " + expected);
			System.out.println("\tActual: " + actual);
		}
	}
}