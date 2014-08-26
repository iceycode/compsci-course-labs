package lab01;

/** Fly class
 * - inherits methods from creature
 * - EATS ONLY THINGS
 * 
 * @author Allen Jagoda
 *
 */


public class Fly extends Creature{
	
	//class variable name
	private String name;
	
	public Fly(){
		super("fly");
	}//default constructor
	
	public Fly(String aname){
		super(aname);
	}//non-default constructor

	public void move() {
		// TODO Auto-generated method stub
		fly();
	}
	
	public void fly(){
		System.out.println(getName() + getClass().getSimpleName() + " is buzzing around in flight.");
	}
	
	
	@Override
	public void eat(Thing aThing ){
		if (aThing instanceof Creature) 
			System.out.println(getName() +" "+ getClass().getSimpleName() + " won't eat a " + aThing.toString());
		else if (!(aThing instanceof Thing))
			System.out.println(); //print nothing
		else
			super.eat(aThing);
	}

}
