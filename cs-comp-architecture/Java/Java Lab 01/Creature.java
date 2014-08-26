package lab01;

/** Creature.java class
 * - subclass of Thing.java
 * - inherits methods from Thing
 * - methods in addition to Thing:
 * 		eat, move, whatDidYouEat
 * 
 * @author Allen
 *
 */

public abstract class Creature extends Thing{
	
	//private String className = getClass().getSimpleName();
	private String creatureName;
	private String whatItAte;
	
	public Creature() {
		super("Creature");
	}//non-default constructor
	
	public Creature(String cName){
		super(cName);
	}//non-default constructor
	
	/**
	 * Creatures may be asked to eat various Things. By default, creatures eat
	 * whatever they are told AND print a message stating '{this object} has
	 * just eaten a {a Thing}.' substituting the concrete details for the part
	 * enclosed inside of {}. (the single quotes are not part of the message.) A
	 * creature only remembers the last thing it ate.
	 * 
	 * @param aThing
	 */
	public void eat(Thing aThing){
		setWhatItAte(aThing.toString());
		String ate = getWhatItAte();
		System.out.println(this.getName() + " has just eaten a " + ate);
	}//eat method - prints out the thing a creature ate
	
	/** Tell the Creature to move. 
	 *  Each creature will print a message stating the way it most commonly moves.
	 * 
	 */
	public abstract void move(); //move method- abstract, implemented by subclasses
	
	/**
	 * Make the Creature tell what is in its stomach. If there is nothing in its
	 * stomach, whatDidYouEat() prints '{name} {class} has had nothing to eat!'
	 * If it has something in its stomach, whatDidYouEat() prints '{creature
	 * name} {class name} has eaten a {content of stomach}!' NOTE: The pattern
	 * {word} in the text above indicates what attribute value belongs in the
	 * output text.
	 * 
	 */
	public void whatDidYouEat(){
		
		if (getWhatItAte() == null)
			System.out.println( this.toString() + " has had nothing to eat!");
		else
			System.out.println( this.toString() + " has eaten a " + getWhatItAte());
	}

	
	//========GETTER & SETTER METHODS--------


	/**
	 * @return the whatItAte
	 */
	public String getWhatItAte() {
		return whatItAte;
	}

	/**
	 * @param whatItAte the whatItAte to set
	 */
	public void setWhatItAte(String whatItAte) {
		this.whatItAte = whatItAte;
	}
	
}
