/*  Student information for assignment:
 *
 *  On my honor, Varun Rao, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Varun Rao
 *  email address: varunsatishrao@gmail.com	
 *  UTEID: vr8546
 *  Section 5 digit ID: 51352
 *  Grader name: Rohit
 *  Number of slip days used on this assignment: 0
 */

// Experiment results. CS314 students, place your experiment
// results here:
/*
 * 
	Adding at end: both are about the same. LinkedList is O(1) and ArrayList is amortized O(1)
	Adding at front: LinkedList is faster. LinkedList is O(1) and ArrayList is O(N)
	Removing from front: LinkedList is faster. LinkedList is O(1) while ArrayList is O(N)
	Getting random: ArrayList is faster. LinkedList is O(N) while ArrayList is O(1)
	Getting all using iterator: ArrayList faster, but they are both O(1) 
	Getting all using get method: ArrayList is faster. ArrayList is O(1) while LinkedList is O(N)
 */

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<String>();
		Object[] actual;
		Object[] expected;

		// CS314 students. Add your tests here:
		// test 1 - 3, addFirst
		System.out.println("\nTest 1 addFirst");
		list.makeEmpty();
		list.addFirst("A");
		if (list.toString().equals("[A]"))
			System.out.println("Passed test 1");
		else
			System.out.println("Failed test 1");
		// test 2
		System.out.println("\nTest 2 addFirst");
		list.addFirst("A");
		if (list.toString().equals("[A, A]"))
			System.out.println("Passed test 2");
		else
			System.out.println("Failed test 2");
		// test 3
		System.out.println("\nTest 3 addFirst");
		list.addFirst("B");
		if (list.toString().equals("[B, A, A]"))
			System.out.println("Passed test 3");
		else
			System.out.println("Failed test 3");

		// test 4 - 6, addLast
		System.out.println("\nTest 4 addLast");
		list.makeEmpty();
		list.addLast("A");
		if (list.toString().equals("[A]"))
			System.out.println("Passed test 4");
		else
			System.out.println("Failed test 4");
		// test 5
		System.out.println("\nTest 5 addLast");
		list.addLast("A");
		if (list.toString().equals("[A, A]"))
			System.out.println("Passed test 5");
		else
			System.out.println("Failed test 5");
		// test 6
		System.out.println("\nTest 6 addLast");
		list.addLast("B");
		if (list.toString().equals("[A, A, B]"))
			System.out.println("Passed test 6");
		else
			System.out.println("Failed test 6");

		// test 7 - 9, remove first
		System.out.println("\nTest 7 removeFirst");
		if (list.removeFirst().equals("A") && list.size() == 2)
			System.out.println("Passed test 7");
		else
			System.out.println("Failed test 7");
		// test 8
		System.out.println("\nTest 8 removeFirst");
		if (list.removeFirst().equals("A") && list.size() == 1)
			System.out.println("Passed test 8");
		else
			System.out.println("Failed test 8");
		// test 9
		System.out.println("\nTest 9 removeFirst");
		if (list.removeFirst().equals("B") && list.size() == 0)
			System.out.println("Passed test 9");
		else
			System.out.println("Failed test 9");

		System.out.println("\nTest extra : remove(Object)");
		list.makeEmpty();
		list.add("A");
		if (list.remove("A") && list.size() == 0)
			System.out.println("Passed test extra");
		else
			System.out.println("Failed test extra");

		// test 10 - 12, remove last
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println("\nTest 10 removeLast");
		if (list.removeLast().equals("D") && list.size() == 3)
			System.out.println("Passed test 10");
		else
			System.out.println("Failed test 10");
		// test 8
		System.out.println("\nTest 11 removeLast");
		if (list.removeLast().equals("C") && list.size() == 2)
			System.out.println("Passed test 11");
		else
			System.out.println("Failed test 11");
		// test 9
		System.out.println("\nTest 12 removeLast");
		if (list.removeLast().equals("B") && list.size() == 1)
			System.out.println("Passed test 12");
		else
			System.out.println("Failed test 12");

		System.out.println("\nTest 0.8: remove(Object)");
		list.makeEmpty();
		list.add("A");
		if (list.remove("A") && list.size() == 0)
			System.out.println("Passed test 0.8");
		else
			System.out.println("Failed test 0.8");

		// test 13 - 15, remove last
		list.makeEmpty();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println("\nTest 13 removeLast");
		if (list.removeLast().equals("D") && list.size() == 3)
			System.out.println("Passed test 13");
		else
			System.out.println("Failed test 13");
		// test 14
		System.out.println("\nTest 14 removeLast");
		if (list.removeLast().equals("C") && list.size() == 2)
			System.out.println("Passed test 14");
		else
			System.out.println("Failed test 14");
		// test 15
		System.out.println("\nTest 15 removeLast");
		if (list.removeLast().equals("B") && list.size() == 1)
			System.out.println("Passed test 15");
		else
			System.out.println("Failed test 15");

		// test 16 - 18, add
		list.makeEmpty();
		list.add("A");
		System.out.println("\nTest 16 add");
		if (list.toString().equals("[A]"))
			System.out.println("Passed test 16");
		else
			System.out.println("Failed test 16");
		// test 17
		list.add("B");
		System.out.println("\nTest 17 add");
		if (list.toString().equals("[A, B]"))
			System.out.println("Passed test 17");
		else
			System.out.println("Failed test 17");
		// test 18
		list.add("C");
		System.out.println("\nTest 18 add");
		if (list.toString().equals("[A, B, C]"))
			System.out.println("Passed test 18");
		else
			System.out.println("Failed test 18");

		// test 19 - 21, insert
		list.insert(0, "A");
		System.out.println("\nTest 19 insert");
		if (list.toString().equals("[A, A, B, C]"))
			System.out.println("Passed test 19");
		else
			System.out.println("Failed test 19");
		// test 20
		list.insert(3, "B");
		System.out.println("\nTest 20 insert");
		if (list.toString().equals("[A, A, B, B, C]"))
			System.out.println("Passed test 20");
		else
			System.out.println("Failed test 20");
		// test 21
		list.insert(1, "C");
		System.out.println("\nTest 21 insert");
		if (list.toString().equals("[A, C, A, B, B, C]"))
			System.out.println("Passed test 21");
		else
			System.out.println("Failed test 21");

		// test 22 - 27, set and toString
		list.set(0, "A");
		System.out.println("\nTest 22 and 23: set and toString");
		if (list.toString().equals("[A, C, A, B, B, C]"))
			System.out.println("Passed test 22 and 23");
		else
			System.out.println("Failed test 22 and 23");
		// test 24, 24
		list.set(3, "R");
		System.out.println("\nTest 24 and 25: set and toString");
		if (list.toString().equals("[A, C, A, R, B, C]"))
			System.out.println("Passed test 24 and 25");
		else
			System.out.println("Failed test 24 and 25");

		// test 26, 27
		list.set(2, "C");
		System.out.println("\nTest 26 and 27: set and toString");
		if (list.toString().equals("[A, C, C, R, B, C]"))
			System.out.println("Passed test 26 and 27");
		else
			System.out.println("Failed test 26 and 27");

		// test 28 - 30, get
		System.out.println("\nTest 28 get");
		if (list.get(0).equals("A"))
			System.out.println("Passed test 28");
		else
			System.out.println("Failed test 28");
		// test 29
		System.out.println("\nTest 29 get");
		if (list.get(3).equals("R"))
			System.out.println("Passed test 29");
		else
			System.out.println("Failed test 29");
		// test 30
		System.out.println("\nTest 30 get");
		if (list.get(5).equals("C"))
			System.out.println("Passed test 30");
		else
			System.out.println("Failed test 30");

		// test 31 - 33, remove
		LinkedList<Integer> intList = new LinkedList<Integer>();
		intList.add(1);
		intList.add(24);
		intList.add(1);
		System.out.println("\nTest 31 remove(int pos)");
		if (list.remove(5).equals("C") && list.size() == 5)
			System.out.println("Passed test 31");
		else
			System.out.println("Failed test 31");
		// test 32
		System.out.println("\nTest 32 remove(int pos)");
		if (intList.remove(1).equals(24) && intList.size() == 2)
			System.out.println("Passed test 32");
		else
			System.out.println("Failed test 32");
		// test 33
		System.out.println("\nTest 33 remove(int pos)");
		if (intList.remove(0).equals(1))
			System.out.println("Passed test 33");
		else
			System.out.println("Failed test 33");

		// test 34 - 42, remove, equals, makeEmpty
		LinkedList<String> expectedStringList = new LinkedList<String>();
		LinkedList<Integer> expectedIntList = new LinkedList<Integer>();
		list.makeEmpty();
		intList.makeEmpty();
		list.add("A");
		list.add("B");
		intList.add(1);
		intList.add(24);
		expectedStringList.add("A");
		expectedStringList.add("B");
		expectedIntList.add(24);

		System.out.println("\nTest 31, 32, and 33, 34: remove(obj), equals, makeEmpty, size");
		if (!list.remove("C") && list.equals(expectedStringList) && list.size() == 2)
			System.out.println("Passed test 31, 32, and 33");
		else {
			System.out.println("Failed test 31, 32, and 33");
		}

		// test 32
		expectedStringList.removeFirst();
		System.out.println("\nTest 35, 36, 37, 38 remove(Object), equals, make empty, size");
		if (intList.remove(new Integer(1)) && intList.size() == 1 && intList.equals(expectedIntList)
				&& !intList.equals(expectedStringList))
			System.out.println("Passed test 35, 36, 37, 38");
		else
			System.out.println("Failed test 35, 36, 37, 38");
		// test 33
		intList.makeEmpty();
		intList.add(5);
		expectedIntList.makeEmpty();
		System.out.println("\nTest 39, 40, 41, 42 remove(Object), equals, size, makeEmpty");
		if (!intList.remove(new Integer(0)) && !intList.equals(expectedIntList) && intList.size() == 1)
			System.out.println("Passed test 39, 40, 41, 42");
		else
			System.out.println("Failed test 39, 40, 41, 42");

		System.out.println("\nTest 0.8: remove(Object)");
		list.makeEmpty();
		list.add("A");
		if (list.remove("A") && list.size() == 0)
			System.out.println("Passed test 0.8");
		else
			System.out.println("Failed test 0.8");

		// test 43-45
		System.out.println("\nTest 43: getSubList");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		IList<String> subList = list.getSubList(0, 2);
		if (subList.toString().equals("[A, B]"))
			System.out.println("Passed test 43");
		else
			System.out.println("Failed test 43");
		// 44
		System.out.println("\nTest 44: getSubList");
		subList = list.getSubList(0, 4);
		if (subList.toString().equals("[A, B, C, D]"))
			System.out.println("Passed test 44");
		else
			System.out.println("Failed test 44");
		// 45
		System.out.println("\nTest 45: getSubList");
		subList = list.getSubList(4, 4);
		if (subList.toString().equals("[]"))
			System.out.println("Passed test 45");
		else
			System.out.println("Failed test 45");

		// test 46 - 48 indexOf(Object)
		System.out.println("\nTest 46: indexOf(Object)");
		list.makeEmpty();
		list.add("A");
		list.add("B");
		list.add("A");
		list.add("B");
		if (list.indexOf("B") == 1)
			System.out.println("Passed test 46");
		else
			System.out.println("Failed test 46");
		// 47
		System.out.println("\nTest 47: indexOf(Object)");
		if (list.indexOf("A") == 0)
			System.out.println("Passed test 47");
		else {
			System.out.println("Failed test 47");
		}
		// 48
		System.out.println("\nTest 48: indexOf(Object)");
		if (list.indexOf("potato") == -1)
			System.out.println("Passed test 48");
		else {
			System.out.println("Failed test 48");
		}

		// test 49 - 51 indexOf(Object, int)
		System.out.println("\nTest 49: indexOf(Object, int)");
		if (list.indexOf("B", 1) == 1)
			System.out.println("Passed test 49");
		else
			System.out.println("Failed test 49");
		// 50
		System.out.println("\nTest 50: indexOf(Object, int)");
		if (list.indexOf("B", 2) == 3)
			System.out.println("Passed test 50");
		else {
			System.out.println("Failed test 50");
		}
		// 51
		System.out.println("\nTest 51: indexOf(Object, int)");
		if (list.indexOf("A", 3) == -1)
			System.out.println("Passed test 51");
		else {
			System.out.println("Failed test 51");
		}

		// test 52-63 iterator methods
		list.makeEmpty();
		list.add("A");
		list.add("B");
		list.add("C");
		Iterator<String> it = list.iterator();
		it.next();
		it.remove();
		System.out.println("\nTest 52, 53, 54, 55: iterator, hasNext, next, remove");
		if (it.hasNext() && it.next().equals("B")) {
			System.out.println("Passed test 50, 51, 52, 53");
		} else
			System.out.println("Failed test 50, 51, 52, 53");
		// 56, 57, 58, 59
		intList.makeEmpty();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Iterator<Integer> intIt = intList.iterator();
		intIt.next();
		intIt.next();
		intIt.next();
		intIt.remove();
		System.out.println("\nTest 56, 57, 58, 59: iterator, hasNext, next, remove");
		if (!intIt.hasNext() && intList.toString().equals("[1, 2]"))
			System.out.println("Passed test 56, 57, 58, 59");
		else {
			System.out.println("Failed test 56, 57, 58, 59");
			System.out.println(intList.toString());
			System.out.println(intIt.hasNext());
		}
		// 60, 61, 62, 63
		System.out.println("\nTest 60, 61, 62, 63: iterator, hasNext, next, remove");
		it = list.iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		if (list.size() == 0)
			System.out.println("Passed test 60, 61, 62, 63");
		else {
			System.out.println("Failed test 60, 61, 62, 63");
		}

		// test 64-66 remove range
		System.out.println("\nTest 64: removeRange");
		intList.makeEmpty();
		for (int i = 0; i < 7; i++) {
			intList.add(i);
		}
		intList.removeRange(0, 0);
		if (intList.toString().equals("[0, 1, 2, 3, 4, 5, 6]"))
			System.out.println("Passed test 64");
		else {
			System.out.println("Failed test 64");
			System.out.println(intList);
		}
		// 65
		intList.removeRange(2, 4);
		System.out.println("\nTest 65: removeRange");
		if (intList.toString().equals("[0, 1, 4, 5, 6]"))
			System.out.println("Passed test 65");
		else {
			System.out.println("Failed test 65");
			System.out.println(intList);
		}
		// 66
		intList.removeRange(0, 5);
		System.out.println("\nTest 66: removeRange");
		if (intList.toString().equals("[]") && list.size() == 0)
			System.out.println("Passed test 66");
		else {
			System.out.println("Failed test 66");
			System.out.println(intList);
		}
		
		// 67, equals
		intList.makeEmpty();
		list.makeEmpty();
		System.out.println("\nTest 67: equals");
		if (intList.equals(list))
			System.out.println("Passed test 67");
		else {
			System.out.println("Failed test 67");
		}
		
		// 68, equals
		intList.add(1);
		list.add("A");
		System.out.println("\nTest 67: equals");
		if (!intList.equals(list))
			System.out.println("Passed test 67");
		else {
			System.out.println("Failed test 67");
		}
		// CS314 Students:
		// uncomment the following line to run tests comparing
		// your LinkedList class to the java ArrayList class.
		// comparison();

	}

	private static Object[] toArray(LinkedList<String> list) {
		Object[] result = new Object[list.size()];
		System.out.println(list.size());
		Iterator<String> it = list.iterator();
		int index = 0;
		while (it.hasNext()) {
			result[index] = it.next();
			index++;
		}
		return result;
	}

	// pre: none
	private static boolean arraysSame(Object[] one, Object[] two) {
		boolean same;
		if (one == null || two == null) {
			same = (one == two);
		} else {
			// neither one or two are null
			assert one != null && two != null;
			same = one.length == two.length;
			if (same) {
				int index = 0;
				while (index < one.length && same) {
					same = (one[index].equals(two[index]));
					index++;
				}
			}
		}
		return same;
	}

	public static final int NUM_DOUBLINGS_OF_N = 5;
	private static final int NUM_REPEATS_OF_TEST = 100;

	// A method to be run to compare the LinkedList you are completing and the
	// Java ArrayList class
	public static void comparison() {
		Stopwatch s = new Stopwatch();

		int initialN = 30000;
		addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 2000;
		addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 10000;
		addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 2000;
		removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 5000;
		removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 10000;
		getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 1000;
		getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 50000;
		getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
		getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 100000;
		getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 1000;
		getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

	}

	// These pairs of method illustarte a failure to use polymorphism
	// If the students had implemented the Java list interface there
	// could be a single method. Also we could use function objects to
	// reduce the awful repitition of code.
	public static void addEndArrayList(Stopwatch s, int initialN, int numTests) {

		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<Integer>();
				s.start();
				for (int j = 0; j < n; j++)
					javaList.add(j);
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at end: ArrayList", totalTimes, initialN);
	}

	private static void showResults(String title, double[] times, int initialN) {
		System.out.println();
		System.out.println("Num Repeats: " + NUM_REPEATS_OF_TEST);
		System.out.println(title);
		for (double time : times) {
			System.out.print("N = " + initialN + ", total time: ");
			System.out.printf("%7.4f\n", time);

			initialN *= 2;
		}
		System.out.println();
	}

	public static void addEndLinkedList(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<Integer>();
				s.start();
				for (int j = 0; j < n; j++)
					studentList.add(j);
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at end: LinkedList", totalTimes, initialN);
	}

	public static void addFrontArrayList(Stopwatch s, int initialN, int numTests) {

		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<Integer>();
				s.start();
				for (int j = 0; j < n; j++)
					javaList.add(0, j);
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at front: ArrayList", totalTimes, initialN);
	}

	public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<Integer>();
				s.start();
				for (int j = 0; j < n; j++)
					studentList.insert(0, j);
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at front: LinkedList", totalTimes, initialN);
	}

	public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<String> javaList = new ArrayList<String>();
				for (int j = 0; j < n; j++)
					javaList.add(j + "");
				s.start();
				while (!javaList.isEmpty())
					javaList.remove(0);
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Removing from front: ArrayList", totalTimes, initialN);
	}

	public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<String> studentList = new LinkedList<String>();
				for (int j = 0; j < n; j++)
					studentList.add(j + "");
				s.start();
				while (studentList.size() != 0)
					studentList.removeFirst();
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("removing from front: LinkedList", totalTimes, initialN);
	}

	public static void getRandomArrayList(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			Random r = new Random();
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<Integer>();
				for (int j = 0; j < n; j++)
					javaList.add(j);
				s.start();
				for (int j = 0; j < n; j++) {
					total += javaList.get(r.nextInt(javaList.size()));
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting random: ArrayList", totalTimes, initialN);
	}

	public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			Random r = new Random();
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<Integer>();
				for (int j = 0; j < n; j++)
					studentList.add(j);
				s.start();
				for (int j = 0; j < n; j++) {
					total += studentList.get(r.nextInt(studentList.size()));
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting random: LinkedList", totalTimes, initialN);
	}

	public static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests) {

		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<Integer>();
				for (int j = 0; j < n; j++)
					javaList.add(j);
				Iterator<Integer> it = javaList.iterator();
				s.start();
				while (it.hasNext()) {
					total += it.next();
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
	}

	public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<Integer>();
				for (int j = 0; j < n; j++)
					studentList.add(j);
				Iterator<Integer> it = studentList.iterator();
				s.start();
				while (it.hasNext()) {
					total += it.next();
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
	}

	public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<Integer>();
				for (int j = 0; j < n; j++)
					javaList.add(j);

				s.start();
				int x = 0;
				for (int j = 0; j < javaList.size(); j++) {
					x += javaList.get(j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using get method: ArrayList", totalTimes, initialN);
	}

	public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<Integer>();
				for (int j = 0; j < n; j++)
					studentList.add(j);

				s.start();
				int x = 0;
				for (int j = 0; j < studentList.size(); j++) {
					x += studentList.get(j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using get method: LinkedList", totalTimes, initialN);
	}

	// for future changes
	private static interface ArrayListOp {
		public <E> void op(ArrayList<E> list, E data);
	}

	private ArrayListOp addAL = new ArrayListOp() {
		public <E> void op(ArrayList<E> list, E data) {
			list.add(data);
		}
	};

	private ArrayListOp addFrontAL = new ArrayListOp() {
		public <E> void op(ArrayList<E> list, E data) {
			list.add(0, data);
		}
	};

	private ArrayListOp removeFrontAL = new ArrayListOp() {
		public <E> void op(ArrayList<E> list, E data) {
			list.remove(0);
		}
	};

	private static interface LinkedListOp<E> {
		public void op(LinkedList<E> list);
	}
}