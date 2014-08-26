package lab01cs402;

/** Thing.java
 * - class at top of hierarchy (superclass of Creatures)
 * - contains methods toString()
 * - also has constructors, getters & setters
 * - inherits various methods from java.lang.Object 
 * 
 * @author Allen Jagoda
 *
 */

public class Thing {

	//class variable name
	private String name;
	
	public Thing() {
		setName("");
	}//default constructor
	
	public Thing(String aname){
		setName(aname); //sets thing name
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Produces a String description of this instance. If the class of the
	 * instance is Thing, then return only the name of the Thing. Otherwise add
	 * the name of the class after the name of the thing, separated by a space.
	 * this makes the class name of the thing serve as the thing's last name
	 * (surname), and the given name of the thing is its first name (given
	 * name).
	 * 
	 * @return description (name if just Thing)
	 */
	public String toString(){
		//use for subclasses ---> String className = getClass().getSimpleName();
		String className = getClass().getSimpleName();
		
		if (className == "Thing.java")
			return getName();
		else
			return this.name + " " + className;
	}//toString method

}
