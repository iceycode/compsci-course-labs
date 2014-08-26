package lab13;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.Iterator;

import lab13.GraphLetters.Vertex;

/** GraphLetters.java class
 * 
 * contains methods for Depth-first and 
 * Breadth-first traversal
 * 
 * 
 * 
 *  
 * @author Allen Jagoda Lab13
 *
 */

public class GraphLetters extends DepthFirst {
	
	public static void main(String[] args)
	{
		new GraphLetters().run();
	}

	public void run() {
	    breadthFirst(createGraph());
	    depthFirstIter(createGraph());
	   // new depthFirst(createGraph()); 
	}
	
	/** creates a graph & returns list of elements in it
	 * 
	 * @return
	 */
	public Vertex[] createGraph(){
		  /* constructing a graph using matrices
		   * If there is a connection between two adjacent LETTERS, the 
	       * cell will contain a num > 1, otherwise a 0.  A value of -1 in the
	       * cell denotes that the cities are not neighbors.
	       * 
	       * GRAPH (with weights b/w nodes):
	       * E+---12-------+B--------18-----+F----2---+C
	       * +				+				 +		   +
	       * |				|				/		   |
	       * |				|			   |		   |
	       * |				|			   |		   10
	       * 24				8			   8	       |
	       * |				|			   |		   +
	       * |				|			   |          H <+---11---I
	       * |				|			   /
	       * +				+			  +
	       * G+---12----+A(start)+---10--+D
	       * 
	       * NOTE: I is the only unidirectional node
	       */
		
		int cols = 9;
		int rows = 9;
		//adjacency matrix
				         //A B C D E F G H I
	    int graph[][] = { {0,8,0,10,0,0,12,0,0}, //A
	                      {8,0,0,0,12,18,0,0,0}, //B
	                      {0,0,0,0,0,2,0,10,0},  //C
	                      {10,0,0,0,0,8,0,0,0},  //D
	                      {0,12,0,0,0,0,24,0,0}, //E
	                      {0,18,2,8,0,0,0,0,0},  //F
	                      {12,0,0,0,0,0,24,0,0}, //G
	                      {0,0,10,0,0,0,0,0,11}, //H
	                      {0,0,0,0,0,0,0,11,0}}; //I
	    
	    //initialize stores vertices
	    Vertex[] vertices = new Vertex[rows]; 

	    //Go through each row and collect all [i,col] >= 1 (neighbors)
	    int weight = 0; //weight of the neighbor
	    for (int i = 0; i < rows; i++)  {
	    	Vector<Integer> vec = new Vector<Integer>(rows);
			for (int j = 0; j < cols; j++)  {
				if (graph[i][j] >= 1)  {
					vec.add(j);
					weight = j;
				}//is a neighbor
			}
			vertices[i] = new Vertex(Vertex.getVertexName(i), vec);
			vertices[i].state = weight;
			vec = null; // Allow garbage collection
		}
	    return vertices;
	}
	
	/** 
	 * Breadth-first traversal 
	 * - start at vertex
	 * - visit vertex, discover neighbors
	 * - discover all neighboring vertices
	 * - next, pick vertex & discover those neighbors
	 * - repeat 
	 * 
	 * PSEUDOCODE:
	 * start Queue = startVertex
	 * while: visitedNodes > totalNodes && queue is not empty
	 * 		
	 * 
	 * Tree is wider then it is deep
	 * Makes use of queues (first-in, first-out)
	 */
	public void breadthFirst(Vertex[] vertices ){
		
		Vertex temp = vertices[0];
		temp.state=1; //for tracking the visited nodes, visited/discovered A
		boolean[] seen = new boolean[vertices.length];
		Queue<Vertex> q = new LinkedList<Vertex>(); //queue for breadth first traversal
		
		q.add(temp); //root node added to queue
		seen[0] = true;
		System.out.println("Begin breadth first traversal: \n" + 
				q.toString());
				
		for (int i = 0; i < vertices.length; i++){
			temp = vertices[i];
			while (!q.isEmpty() ) {
	            Vertex v = q.remove();
	            for (int j : v.neighbors) {
	                if (!seen[j]) {
	                    q.add(vertices[j]);
	                    seen[j] = true;
	                    vertices[j].state=1;
	                }
	            }
	            System.out.println(q.toString());
        	}
		}
	}//breadthFirst traversal
	

//--------------------------------------------------------------------
	
/**
 * @param vertices
 */
public void depthFirstIter(Vertex[] vertices ){
	Stack<Vertex> s = new Stack<Vertex>();
	Vertex v = vertices[0];
	boolean[] visited = new boolean[vertices.length+1];
	boolean[] closed = new boolean[vertices.length]; //if tree node has 2 children
	System.out.println("Begin depth first traversal: \n" + s.toString()); //print stack

	v.state = 1;
	
	dft_r(vertices, s, visited, 0);
	
	
//	s.push(v);
//	visited[0]=true;
//	int i = 1;
//	
//	while (!s.isEmpty() && i<8) {
//		v = vertices[i];
//
//		if (!visited[i]){
//			visited[i] = true;
//			s.push(v);
//			for (int j : v.neighbors){
//				if (!visited[j]) {
//					v = vertices[j];
//					s.push(v);
//					visited[j] = true;
//				}
//				i = j;
//				//closed[j] = true;
//			}
//			//System.out.println(s.toString());
//		}
//		else
//			s.pop();
//		
//		//System.out.println(s.toString());
//
//	}
//    //System.out.println(s.toString());
}


/** RECURSIVE METHOD FOR Depth first traversal 
 * - THIS WORKS!!!
 *    ...PROBLEM - prints double before popping G & D & lastly A
 * @param vertices
 * @param s
 * @param visited
 * @param i
 */
public void dft_r (Vertex[] vertices, Stack<Vertex> s, boolean[] visited, int i) {
	Vertex v = vertices[i];
	s.push(v);

	while (!visited[i]) {
		visited[i] = true;

		for (int j : v.neighbors){
			dft_r(vertices, s, visited, j);
		}
	}
	
	s.pop();
	
	System.out.println(s.toString());	
}
	
//--------------------------------------------------------------------
	static class Vertex  {
		public String name;
		public int state; /* 0: undiscovered; 1: discovered; 2: visited */
		public Vector<Integer> neighbors;

		public Vertex(String name, Vector<Integer> n)  {
			this.name = name;
			neighbors = n;
			state = 0;
		}
		public String toString(){
		    StringBuffer s = new StringBuffer();
		    Iterator<Integer> itr = neighbors.iterator();

	       s.append("Edge: " + name + " ");
 
	       
	       return s.toString();
		}
	   
	       
	   public static int getVertexIndex(String name)  {
		   int index = -1;
		   //NOTE --- String switch case compliant only with Java 1.7
		   switch(name){
		   		case "A" : index = 0; break;
		   		case "B" : index = 1; break;
		   		case "C" : index = 2; break;
		   		case "D" : index = 3; break;
		   		case "E" : index = 4; break;
		   		case "F" : index = 5; break;
		   		case "G" : index = 6; break;
		   		case "H" : index = 7; break;
		   		case "I" : index = 8; break;
		   		default : break;
		   }//switch statement to return index
		   
		   return index;
	   }

	   public static String getVertexName(int index)  {
		   String name = null;
		   switch (index) {
		   		case 0: name = "A"; break;
		   		case 1: name = "B"; break;
		   		case 2: name = "C"; break;
		   		case 3: name = "D"; break;
		   		case 4: name = "E"; break;
		   		case 5: name = "F"; break;
		   		case 6: name = "G"; break;
		   		case 7: name = "H"; break;
		   		case 8: name = "I"; break;
		   		default: name = null; break;
		   }
		   
		   return name;
	   }
	}
}
	

