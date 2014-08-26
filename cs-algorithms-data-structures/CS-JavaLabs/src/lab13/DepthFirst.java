package lab13;

import java.util.Stack;

import lab13.GraphLetters.Vertex;

public class DepthFirst {

	protected static class depthFirst{
		
		Stack<Vertex> s = new Stack<Vertex>();//stack for depth first traversal
	
		/**
		 * Depth-first traversal:
	
		 *  - start at vertex
		 *  - discover adjacent vertices
		 *  - pick one to visit (different from discover)
		 *  	add visitors to the stack
		 *  - if no more, backtrack
		 *      remove visitors from stack when backtracking
		 *  start over again
		 *  - tree created
		 *  
		 * Tree is deeper then it is wide
		 * Makes use of a stack (first-in, last-out)
		 * 
		 * 
		 */
		depthFirst(Vertex[] vertices){
			Vertex v = vertices[0]; //initial vertex
			boolean[] seen = new boolean[vertices.length];
			int index = 0;
			s.push(v);
			seen[index]=true; //set that root visited
			System.out.println("Begin depth first traversal: \n" + s.toString()); //print stack
			System.out.println(s.toString()); //print stack
	
			for (int i = 0; i < vertices.length; i++) {
				while (!s.isEmpty()){	
					for (int j = 1; j < vertices.length; j++){					
						if (vertices[j].state == 0 ){
							s.push(v);
							vertices[j].state=1;
							seen[j]=true;
							v = vertices[j];
						}
						System.out.println(s.toString()); //print stack
					}//discovering neighbors
					
					if (vertices[i].state ==1 && seen[i]==true) {
						vertices[i] = s.pop();
					}
	
				}		
				System.out.println(s.toString()); //print stack
	
			}
			dfs(vertices, 8, 0);
	
			for (int i = 0; i < vertices.length; i++){
				
				s.push(vertices[i]);
				
				while(!s.isEmpty()){
					if (vertices[i].state == 0){
						for (int j : vertices[i].neighbors){
							if (j > 0){
								s.push(vertices[i]);
								vertices[i].state = 1;
							}
						}
		
					}
					else{
						s.pop();
					}
				}
			}
			
			
		}
		
		public void dfs(Vertex[] v, int i, int state){
			
			
		}
		
	}

	public DepthFirst() {
		super();
	}

}