package lab14;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

public class WeightedGraph {
	

	private int numVertices; //number of vertices
	private int numEdges; //number of edges
	private int adjMatrix[][]; //adjacency matrix

	
	public WeightedGraph() {
		createGraph();
	}
	
	public Vertex[] createGraph() {
		/* Initial graph:
		 * 
                           A
                          / \
                         / | \
                      6 /  |  \ 5
                       /   |   \
                      /    |    \
                     B     | 1   C 
                    | \    |    / |
                    |  \   |   /  |
                    |   \  |  /   |
                  3 |  5 \ | / 5  | 2
                    |     \|/     |
                    |      D      |
                    |     / \     |
                    +  6 /   \ 4  +
                    \   /     \  /
                     \ /       \/
                      E+-------+F
                           5
		 */
		
		int rows = 6;
		int cols = 6;
		this.numVertices = rows;
		Vertex[] vertices = new Vertex[rows]; 
		
		
		  				 //A  B  C  D  E  F
	    int graph[][] = { 
	    		   /*A*/  {0, 6, 5, 1, 0, 0 }, //A
	               /*B*/  {6, 0, 0, 5, 3, 0 }, //B
	               /*C*/  {5, 0, 0, 5, 0, 2 },  //C
	               /*D*/  {1, 5, 5, 0, 6, 4 },  //D
	               /*E*/  {0, 3, 0, 6, 0, 5 }, //E
	               /*F*/  {0, 0, 2, 4, 5, 0 }  /*F*/ }; 
	    
	    
	    this.adjMatrix = graph;	  
	    int weight = 0;// for weights
	    
	    for (int i = 0; i < rows; i++) {
	    	Vector<Integer> vectors = new Vector<Integer>();
	    	PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
	    	for (int j = 0; j < cols; j++) {
		    	if (adjMatrix[i][j] > 0) {
		    		vectors.add(j);
		    		weight = adjMatrix[i][j];
		    		Edge e = new Edge(i, j, weight);
		    		edges.add(e); 
		    		numEdges++;
		    	}
	    	}
	    	vertices[i] = new Vertex(getVertexName(i), vectors, edges);
	    	vectors = null; //clear the vector list
	    }
		return vertices;
	    
	} //default weighted graph
	
	//creates graph with V vertices
	public WeightedGraph(Vertex v, Edge e) {
		// TODO Auto-generated constructor stub
	}
	

	public int getVertexIndex(String name)  {
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

   public String getVertexName(int index)  {
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
	    
   private class WeightedGraphIterator implements Iterator<Integer>, Iterable<Integer>{

			@Override
			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
   }
   
		
//**************SETTERS & GETTERS******************//
		
   public int getNumVertices() {
	   return numVertices;
   }

   public void setNumVertices(int numVertices) {
	   this.numVertices = numVertices;
   }

   public int getNumEdges() {
	   return numEdges;
   }

   public void setNumEdges(int numEdges) {
	   this.numEdges = numEdges;
   }

   public int[][] getAdjMatrix() {
	   return adjMatrix;
   }

   public void setAdjMatrix(int[][] adjMatrix) {
	   this.adjMatrix = adjMatrix;
   }
}
