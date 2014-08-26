package lab13;

import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

/** Vertex.java class 
 * 
 * - class instance of Vertex
 * - used with GraphLetters
 * 
 * @author Allen
 *
 */

public class Vertex {
	private String name; //name of vertex
	private Vector<Integer> neighbors; //stores all neighbors
	
	
	public Vertex(){
		setName(" ");
		setNeighbors(null);
	}//default constructor
	
	/**
	 * 
	 * @param name
	 * @param n
	 */
	public Vertex(String name, Vector<Integer> n){
		setName(name);
		setNeighbors(n);
	}//non-default constructor

	public String toString(){
	    StringBuffer s = new StringBuffer();
 	    s.append("\n");

       s.append("Edge: " + name + "\n");
       
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
	   String name = " ";
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
   
   	public String getName() {
   		return name;
   	}
    //**************SETTERS & GETTERS******************//

   	public void setName(String name) {
   		this.name = name;
   	}

   	public Vector<Integer> getNeighbors() {
   		return neighbors;
   	}

   	public void setNeighbors(Vector<Integer> neighbors) {
   		this.neighbors = neighbors;
   	}
      
}