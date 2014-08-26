package lab01cs402;

/** Ant class
 * - inherits methods from creature
 * - 
 * 
 * @author Allen Jagoda
 *
 */

public class Ant extends Creature{

	//class variable name
	private String name;
	
	public Ant(){
		super("ant");
	}//default constructor
	
	public Ant(String aname){
		super(aname);
	}//non-default constructor
	
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(getName() + getClass().getSimpleName() + " is crawling around");
	}

}
