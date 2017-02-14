import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;

public class BSTTests {

	public static void main(String[] args) {
		BinarySearchTree<String> smallTree = new BinarySearchTree<>();

		completeTest(smallTree.size() == 0, "empty list has size 0");
		completeTest(smallTree.height() == -1, "empty list has height -1");

		completeTest(smallTree.add("B"), "addition of new element returns true");
		completeTest(!smallTree.add("B"), "addition of existing element returns false");
		completeTest(smallTree.size() == 1, "list size increased");
		completeTest(smallTree.isPresent("B"), "check for presence of element");

		smallTree.add("A");
		smallTree.add("C");
		smallTree.add("D");

		completeTest(smallTree.remove("B"), "remove returns true on removal");
		completeTest(smallTree.size() == 3, "list size reflects actual size after multiple removals and additions");
		completeTest(!smallTree.remove("X"), "remove returns false on non-existant element");
		completeTest(smallTree.size() == 3, "attempted remove of non-existant element leaves list unchanged");

		completeTest(!smallTree.isPresent("B"), "check for presence of former element");

		completeTest(smallTree.height() == 1, "height of tree");
		smallTree.printTree();
		completeTest(smallTree.min().equals("A"), "minimum");
		completeTest(smallTree.max().equals("D"), "maximum");

		completeTest(smallTree.get(1).equals("C"), "get value");
		completeTest(smallTree.get(2).equals("D"), "get last element");

		BinarySearchTree<Integer> numberTree = new BinarySearchTree<>();
		TreeSet<Integer> numberSet = new TreeSet<>();
		Random r = new Random();
		for (int i = 0; i < 5000; i++) {
			int number = r.nextInt();
			numberTree.add(number);
			numberSet.add(number);
		}

		completeTest(numberSet.containsAll(numberTree.getAll()), "get all elements");

		int somePosition = (int)(Math.random()*(numberTree.size()));
		int somePivot = numberTree.get(somePosition);
		completeTest(numberSet.subSet(Integer.MIN_VALUE, true, somePivot, false)
		.containsAll(numberTree.getAllLessThan(somePivot)), "get all elements less than "+somePivot);
		completeTest(numberSet.subSet(somePivot, false, Integer.MAX_VALUE, true)
		.containsAll(numberTree.getAllGreaterThan(somePivot)), "get all elements greater than "+somePivot);
		completeTest(numberTree.get(somePosition).equals(numberSet.toArray()[somePosition]), "get element at position "+somePosition);

		int someDepth = (int)(Math.random()*(numberTree.height()-2))+1;
		completeTest(numberTree.numNodesAtDepth(someDepth) > 1, "number of nodes at depth "+someDepth);
		completeTest(numberSet.first().equals(numberTree.min()), "min of large tree");
		completeTest(numberSet.last().equals(numberTree.max()), "max of large tree");

		smallTree = new BinarySearchTree<>();
		smallTree.add("B");
		smallTree.add("A");
		smallTree.add("D");
		smallTree.add("C");
		smallTree.add("E");
		smallTree.add("F");
		/* Tree is:
		 *     B
		 *  A´   `D
		 *      C´ `E
		 *           `F */
		ArrayList<String> expectedContents = new ArrayList<>();
		for (int letter = 65; letter <= 70; letter++) {
			// Add letters A-F in sorted order
			expectedContents.add(new String(new byte[]{(byte)letter}));
		}

		completeTest(smallTree.height() == 3, "height of tree");
		completeTest(smallTree.numNodesAtDepth(2) == 2, "number of nodes at depth");
		completeTest(smallTree.numNodesAtDepth(3) == 1, "number of nodes at lowest level");
		completeTest(smallTree.getAll().equals(expectedContents), "get all values");
		completeTest(smallTree.getAllLessThan("A").size() == 0, "get less than excludes value");
		completeTest(smallTree.getAllGreaterThan("B").equals(expectedContents.subList(2, 6)), "get greater than excludes");

		// and we're done with simple tests! wrap it up
		int testCount = testNum - 1;
		System.out.println("\nPassed "+passedTests+" out of "+testCount+" tests.");
		if (passedTests < testCount) System.out.println("One or more tests have FAILED!");
		else System.out.println("All tests PASSED!");
	}

	// incrementing test number
	private static int testNum = 1;
	// number of passed tests
	private static int passedTests = 0;

	/**
	* Print the result of the test and count results.
	* <br>pre: none
	* @param boolean passed: whether or not the experiment passed
	* @param String description: short description of the test
	* @return void
	*/
	private static void completeTest(boolean passed, String description) {
		System.out.println((passed ? "Passed" : "FAILED")+" test "+testNum
		+" ("+description+")");
		testNum++;
		if (passed) passedTests++;
		else if (passedTests == testNum - 2) System.out.println("\nTHIS IS THE FIRST FAILED TEST!\nFollowing tests may fail not because of incorrect code but because of reasons related to this test!\n");
	}
}