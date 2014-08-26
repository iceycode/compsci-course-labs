package lab14;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimTree extends WeightedGraph{
	
	private PriorityQueue<Edge> edges;
	
	protected BinarySearchTree<Vertex> tree;
	protected WeightedGraph graph; 
	
	/* start vertex ---> stores edge ---> end
	 * 
	 */
	public PrimTree(WeightedGraph graph, int startVertex) { 
		this.graph = new WeightedGraph(); //creates a new graph
		
		Vertex[] vertices = graph.createGraph(); //all the vertices
		
		int numVertices = graph.getNumVertices();
		
		System.out.println("Start vertex : " + vertices[startVertex].getVertexName(startVertex).toString());
		primMST(numVertices, vertices, startVertex);
		
	}//non-default constructor
	
	/** Prim's Modified/Optimized Span Tree 
	 * 
	 */
	public void primMST(int numVertices, Vertex[] vertices, int startVertex) {
		
		double cost = 0; 	   //cost of minimal spanning tree
		boolean[] seen = new boolean[numVertices];

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); //stores entire path
		
		edges = vertices[startVertex].getEdges();
		
		Edge e2 = edges.peek();
		Edge ePrev = edges.peek();
		int nextVertex = e2.getSrc();

		for (int i = 0; i < 6; i++) {
			edges = vertices[nextVertex].getEdges(); //update edges
			
			for (int j = 0; j < edges.size(); j++) {
				Edge e1 = edges.peek(); 
				if (!seen[e1.getDest()]  ) {
					if (e2.getWeight() > e1.getWeight()) {
						e2 = e1;
					}
					seen[e2.getSrc()] = true;
				}
				else {
					edges.remove();	   //removes the head since it was seen
					e2 = edges.peek(); //stores new head at e2
					for (Edge e3 : edges) {
						if (!seen[e2.getDest()] ) {
							if (e2.getWeight() > e3.getWeight()) {
								e2 = e3;
							}
						}
						break;
					}//compares all edges to new one
				}
			}//finds the smallest weighted edge in graph
			pq.add(e2);
			seen[e2.getDest()] = true;
			seen[e2.getSrc()] = true;
			
			cost += e2.getWeight(); //gets the cost

			nextVertex = e2.getDest(); //change to next graph vertex

			addEdgePath(e2);  //adds to tree
			
			System.out.println(e2.toString());
		}//finds all the shortest paths and places into tree
		System.out.println("Total cost: "+ cost);
		cost = 0;
	}
	
	public void addEdgePath(Edge edge) {

	}
	
	public boolean checkCycling(int src, Edge e2) {
		if (src == e2.getDest())  
			return true;
		else
			return false;
	}

	
}
