package lab01cs402;

/** Tiger class
 * - inherits methods from Creature
 * - inherits same eat method as Creature has (no javadoc eat() method specifications)
 * 
 * @author Allen Jagoda
 *
 */

public class Tiger extends Creature{
	
	//class variable name
	private String name;
	
	public Tiger(){
		super("tiger");
	}//default constructor
	
	public Tiger(String aname){
		super(aname);
	}//non-default constructor

	//inherited abstract method move() from Creature
	public void move() {
		System.out.println(getName() + getClass().getSimpleName() + " has just pounced");
		
	}


}
