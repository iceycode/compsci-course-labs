package lab14;

import java.util.PriorityQueue;

public class AdjMatrix {
	
	private int numRows;
	private int numCols;
	private int graph[][];

	public AdjMatrix(int numVertices, PriorityQueue<Edge> edges) {
		createAdjMatrix(numVertices, edges);
	}
	
	public int[][] createAdjMatrix(int vertices, PriorityQueue<Edge> edges) {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (j == edges.peek().getDest()) {
					this.graph[i][j] = (int) edges.peek().getWeight();
				}//add weight value
			}
		}
		return graph;
	}

}
