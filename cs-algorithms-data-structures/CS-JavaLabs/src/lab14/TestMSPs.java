package lab14;

/** TestMSPs.java
 * 
 * Main application to test optimized Prim's algorithm
 * 
 * 
 * @author Allen
 *
 */

public class TestMSPs {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 6; i++) {
			WeightedGraph g= new WeightedGraph();
			primMST(g, i);
			djAlg(g, i);
			
		}		
	
	}	
	
	public static void primMST(WeightedGraph g, int start) {
		System.out.println("Begin Spanning Tree Prim: " );

		PrimTree pt = new PrimTree(g, start);
	}
	
	
	public static void djAlg(WeightedGraph g, int start) {
		System.out.println("Find shortest path from " + Vertex.getVertexName(start) );

		DijkstraAlgorithm dj = new DijkstraAlgorithm(g, start);
	}
}
