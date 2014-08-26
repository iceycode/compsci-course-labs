package lab14;

public class Edge implements Comparable<Edge>{
	
	private int src; //source vertex
	private int dest; //destination vertex
	private double weight; //weight of edge
	
	public Edge() {} //default constructor

	public Edge(int src, int dest, double weight) {
		setSrc(src);
		setDest(dest);
		setWeight(weight);
	}//non-default constructor

	@Override
	public int compareTo(Edge e) {
		if (e.getWeight() < this.weight) {
			return 1;
		}
		else if (e.getWeight() > this.weight)
			return -1;
		else
			return 0;
	} //compareTo method for edge weights

	@Override
	public String toString() {
		return "<" + src + ", " + dest + ", " + weight + ">";
	}
	
	public int getSrc() {
		return src;
	}

	public void setSrc(int src2) {
		this.src = src2;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest2) {
		this.dest = dest2;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	


}
