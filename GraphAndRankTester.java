
/*  Student information for assignment:
 *
 *  On my honor, Varun Rao, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: vr8546
 *  email address: varunsatishrao@gmail.com
 *  Grader name: Rohit
 *  Number of slip days I am using: 0
 */

/*
 * Question. The assignment presents three ways to rank teams using graphs.
 * The results, especially for the last two methods are reasonable.
 * However if all results from all college football teams are included
 * some unexpected results occur.
 * 
 * Suggest another way of method of ranking teams using the results
 * from the graph. Thoroughly explain your method. The method can build
 * on one of the three existing algorithms.
 * 
 * It seemed like the algorithm which used teams win/loss ratios was most 
 * effective in ranking teams of the three algorithms we used originally.
 * Thus I propose to build off of that system by considering the teams which 
 * each team is winning or losing to. Run the original algorithm once to get 
 * initial rankings, take into account who each team won and lost to. If a team 
 * beats a team which was strong the original rankings, then it is likely a good 
 * team. If it loses to a weak team, then that team is likely a weak team itself.
 * We can construct a new ratio to multiply the average path length through 
 * this. For example, once we have the results from method 2, we can multiply the 
 * path lengths by a/n where "a" is the losing teams ranking and n is the
 * number of teams. This way, teams are more rewarded for beating a more 
 * difficult opponent. 
 *
 */

public class GraphAndRankTester {

    public static void main(String[] args)  {
        System.out.println();
        testGraph();


        
        footballTester("2005ap_poll.txt", "div12005.txt", 6.8, 5.8, 3.0, 5);     
        footballTester("2008ap_poll.txt", "div12008.txt",13.7, 12.6, 6.3, 6);
        footballTester("2008ap_poll.txt", "games08.txt",22.6, 14, 8.2, 7);
        footballTester("2014ap_poll.txt", "div12014.txt", 10.1, 8.5, 4.2, 8);
        

        System.out.println();

    }
    
    private static void footballTester(String actual, String result, double unweightedRes, double weightedRes, double adjWeightedRes, int test) {
    	FootballRanker ranker = new FootballRanker(result, actual);
    	
    	boolean unweighted = unweightedRes == ranker.doUnweighted(true);
    	boolean weighted = ranker.doWeighted(true) == weightedRes;
    	boolean adjWeighted = ranker.doWeightedAndWinPercentAdjusted(true) == adjWeightedRes;
    	
    	if(unweighted)
    		System.out.println("Passed unweighted test " + test + "a.");
        else
            System.out.println("FAILED WEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected " + unweightedRes + " " + test + "c.");
    	
    	if(weighted)
    		System.out.println("Passed weighted test " + test + "b.");
        else
            System.out.println("FAILED WEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected " + weightedRes + " " + test + "c.");
    	
    	if(adjWeighted)
    		System.out.println("Passed doWeightedAndWinPercentAdjusted test " + test + "c.");
        else
            System.out.println("FAILED WEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected " + adjWeightedRes + " " + test + "c.");
            
    }


    private static void testGraph() {
        System.out.println("PERFORMING TEST ON SIMPLE GRAPH");
        String [][] edges =
               {{"R", "B", "1"},
                {"B", "C", "2"},
                {"B", "D", "4"},
                {"C", "D", "1"},
                {"R", "G", "1"},
                {"D", "F", "3"}};

        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
            g.addEdge(edge[1], edge[0], Integer.parseInt(edge[2]));
        }
        
        
        int test = 0;
        g.dijkstra("R");
        String actualPath = g.findPath("D").toString();
        String expected = "[R, B, C, D]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test. Test: " + ++test);
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath + ", test: " + ++test);
        
        g.dijkstra("F");
        actualPath = g.findPath("G").toString();
        expected = "[F, D, C, B, R, G]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test. Test: " + ++test);
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath + ", test: " + ++test);

        // find all paths using unweighted edges
        g.findAllPaths(false);
        int actualDiameter = g.getDiameter();
        if(actualDiameter == 4)
            System.out.println("Passed diameter test with weighted == false. Test: " + ++test);
        else
            System.out.println("Failed diameter test with weighted == false. Expected 4 got " + actualDiameter + ", test: " + ++test);

        g.findAllPaths(true);
        double costOfLongestShortestPath = g.costOfLongestShortestPath();
        double e = 8.0;
        if(costOfLongestShortestPath == e)
            System.out.println("Passed cost of longest shortest path test with weighted == true." + " Test: " + ++test);
        else
            System.out.println("Failed cost of longest shortest path test with weighted == false. Expected " + e + ", got " + costOfLongestShortestPath + ", test: " + ++test);

        System.out.println();
    }
}