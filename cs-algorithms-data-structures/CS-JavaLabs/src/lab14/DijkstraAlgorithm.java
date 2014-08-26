package lab14;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;


/** Dijkstra's Algorithm
S and V-S are sets; a set can be approximated by using a container 
in Java.  You can use an ArrayList, a Vector, or one of your
Linked List classes you wrote earlier, or even a simple array.

d[] is a simple array of cumulative distance from the source
vertex to the vertex under consideration (here, index 0 is 
the first vertex, index 1 is the second vertex, and so on).

p[] is a simple array that holds the predecessor node for the 
vertex under consideration (here, index 0 is the first vertex, 
index 1 is the second vertex, and so on).

w(u,v) is the cost (or weight) of the edge connecting vertices
u and v.

Infinity below can be approximated by a large number, largest 
than any of the costs in your graph.

procedure Dijkstra_SP

 Initialize S with start vertex, s, and V-S with remaining vertices.
 For all v in V-S do
    set p[v] to s.
    if there is an edge (s,v)
       set d[v] to w(s,v).
    else
       set d[v] to infinity.
 done

 while V-S is not empty do
    For all u in V-S, find the smallest d[u].
    Remove u from V-S and add u to S.
    For all v adjacent to u in V-S do
       if d[u] + w(u,v) < d[v] then
          Set d[v] to d[u] + w(u,v).
          Set p[v] to u.
       End if
    done
 done 

End procedure

 * @author Allen
 *
 */
public class DijkstraAlgorithm {
	
	
	
	public DijkstraAlgorithm(WeightedGraph g, int start) {
		

		Vertex[] vertices = g.createGraph();
		
		boolean[] seen = new boolean[g.getNumVertices()]; //seen it

		int[] p = new int[g.getNumVertices()]; //holds previous node
		double[] d = new double[g.getNumVertices()]; //holds total distance
	    ArrayList<Vertex> vertexQueue = new ArrayList<Vertex>();
	    for (int k = 0; k < g.getNumVertices(); k++){
	    	vertexQueue.add(vertices[k]);
	    }
	    Stack<Edge> s = new Stack<Edge>(); //stores path
		
		/*
		 * For all v in V-S do
		    set p[v] to s.
		    if there is an edge (s,v)
		       set d[v] to w(s,v).
		    else
		       set d[v] to infinity.
		 	done
		 */

		
		for (int i = 0; i < g.getNumVertices(); i++) {
			PriorityQueue<Edge> edges = vertices[start].getEdges();
			p[i] = start;
			if (!edges.isEmpty()) {
				if (edges.peek().getDest() == i )
					d[i] = edges.peek().getWeight(); //set to proper weight
					edges.remove(); //removed head
			}//if there is an edge to vertices
			else
				d[i] = 2000;			
			
		}
		
//		while V-S is not empty do
//		    For all u in V-S, find the smallest d[u].
//		    Remove u from V-S and add u to S.
//		    For all v adjacent to u in V-S do
//		       if d[u] + w(u,v) < d[v] then
//		          Set d[v] to d[u] + w(u,v).
//		          Set p[v] to u.
//		       End if
//		    done
//		 done 
       vertexQueue.add(vertices[start]);
       Edge e1 = new Edge();
       
		while (!s.isEmpty()) {
		    // Visit each edge exiting u
		    for (Edge e : vertices[start].getEdges()) {	
		    	if (e1.compareTo(e) == 1) {
		    		e1 = e;
		    	}
		    }//find smallest distance/weight
		    Vertex v = vertices[e1.getDest()];
			Vertex u = vertexQueue.remove(start);
			s.push(e1);
		    System.out.println(e1.toString());

			
	        double weight = e1.getWeight();
	        double distance = u.getEdges().peek().getWeight() + weight;
	        if (distance < d[e1.getDest()]) {
	        	vertexQueue.remove(v);
		    weight = distance ;
		    p[start] = u.getAdjMatrixNum();
		    vertexQueue.add(v);
		    
	        }
           }
        }
	
//	public void djAlgorithm(Vertex source) {
//
//		
//       double[] distance = new double[numVertices];
//        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
//      	vertexQueue.add(source);
//
//		while (!vertexQueue.isEmpty()) {
//		    Vertex u = vertexQueue.poll();
//
//	            // Visit each edge exiting u
//	            for (Edge e : u.getEdges())
//	            {
//	                Vertex v = vertices[e.getDest()];
//	                double weight = e.getWeight();
//	                double distanceThroughU = d[u.getAdjMatrixNum()] + weight;
//			if (distanceThroughU < v.minDistance) {
//			    vertexQueue.remove(v);
//			    v.minDistance = distanceThroughU ;
//			    v.getEdges().peek().getDest() = u;
//			    vertexQueue.add(v);
//			}
//	            }
//	        }
//	    }
//
//	    public static List<Vertex> getShortestPathTo(Vertex target)
//	    {
//	        List<Vertex> path = new ArrayList<Vertex>();
//	        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
//	            path.add(vertex);
//	        Collections.reverse(path);
//	        return path;
//	    }
//
//	}
}
	
	


