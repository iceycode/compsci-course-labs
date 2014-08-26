package lab01cs402;

/** Bat class
 * - inherits methods from creature
 * - EATS ONLY CREATURES
 * - eat() method overridden
 * 
 * @author Allen Jagoda
 *
 */


public class Bat extends Creature{
	
	//class variable name
	private String name;
	
	public Bat(){
		super("bat");
	}//default constructor
	
	public Bat(String aname){
		super(aname);
	}//non-default constructor

	public void move() {
		// TODO Auto-generated method stub
		fly();
	}
	
	public void fly(){
		System.out.println(getName() + getClass().getSimpleName() + " is swooping through the dark.");
	}
	
	
	@Override
	public void eat(Thing aThing ){
		if (aThing instanceof Thing && !(aThing instanceof Creature)) 
			System.out.println(getName() + " "+ getClass().getSimpleName() + " won't eat a " + aThing.toString());
		else if (!(aThing instanceof Thing) && !(aThing instanceof Creature))
			System.out.println(); //print nothing
		else
			super.eat(aThing);
	}
}
