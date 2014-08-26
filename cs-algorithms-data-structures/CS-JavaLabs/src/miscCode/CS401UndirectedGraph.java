package miscCode;

import java.util.Vector;
import java.util.Iterator;

/* 
 * Example of an undirected graph.  This program will print out the
 * graph, listing the vertices and the edges. */

public class CS401UndirectedGraph
{
	public static void main(String[] args)
	{
		new CS401UndirectedGraph().run();

		return;
	}

	public void run()
	{
		/*
		 * The following matrix is a representation of the undirected 
		 * graph below:
		 * 
		 *   Chicago --------- New York    In the matrix below, the indexes are
		 *      |              |     |     are as follows:
		 *      |       +------+     |     0: Chicago
		 *      |      /             |     1: New York
		 *      |     /              |     2: Atlanta
		 *   Dallas -+         Atlanta     3: Dallas
		 *                                
		 * If there is a connection between two adjacent cities, the 
		 * cell will contain a 1, otherwise a 0.  A value of -1 in the
		 * cell denotes that the cities are not neighbors.
		 */
		int graph[][] = { { -1,  1,  0,  1 },
				{  1, -1,  1,  1 },
				{  0,  1, -1,  0 },
				{  1,  1,  0, -1 } };

		int max_row = 4;
		int max_col = 4;
		Vertex[] vertices = new Vertex[max_row];

		

		for (int i = 0; i < max_row; i++)  {
			// Go through each row and collect all [i,col] = 1 (neighbors)
			Vector<Integer> v = new Vector<Integer>(max_row);
			for (int j = 0; j < max_col; j++)  {
				if (graph[i][j] == 1)  {
					v.add(j);
				}
			}
			vertices[i] = new Vertex(Vertex.get_vertex_name(i), v);
			v = null; // Allow garbage collection
		}

		// Now print out the graph
		for (int i = 0; i < max_row; i++)  {
			System.out.println(vertices[i]);
		}
	}
	
	//--------------------------------------------------------------------
	static class Vertex  {
		public String name;
		public int state; /* 0: undiscovered; 1: discovered; 2: visited */
		public Vector<Integer> neighbours;

		public Vertex(String name, Vector<Integer> n)  {
			this.name = name;
			neighbours = n;
			state = 0;
		}

		public static int get_vertex_index(String name)  {
			if (name.equals("Chicago"))
				return 0;
			else if (name.equals("New York"))
				return 1;
			else if (name.equals("Atlanta"))
				return 2;
			else if (name.equals("Dallas"))
				return 3;
			else
				return -1;
		}

		public static String get_vertex_name(int index)  {
			if (index == 0)
				return "Chicago";
			else if (index == 1)
				return "New York";
			else if (index == 2)
				return "Atlanta";
			else if (index == 3)
				return "Dallas";
			else 
				return null;
		}

		public String toString()       {
			StringBuffer s = new StringBuffer();
			Iterator<Integer> itr = neighbours.iterator();

			s.append("Edge: " + name + "\n");
			s.append("   Neighbours: ");
			while (itr.hasNext())  {
				s.append(get_vertex_name(itr.next()) + "(" + state + ")");
				if (itr.hasNext())  {
					s.append(", ");
				}
			}

			return s.toString();
		}
	} // Class Edge
}
