package hw4;

/** Coin.java
 * - class which contains following attributes:
 *   name of coin (ie, penny, nickel, dime, etc)
 *   value of coin (ie, 1, 10, etc)
 * 
 * @author Allen
 *
 */

public class Coin {
	
	//class variables
	private String name;
	private String value;
	
	public Coin() {
		setName("penny");
		setValue("1 cent");
	} //default constructor
	
	public Coin (String name, String value){
		setName(name);
		setValue(value);
	}//non-default constructor
	
	//getter methods
	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
	
	//setter methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		return "name: " + name + ", value:" + value;
	}//toString method
	
	public boolean equals(Coin c){
		if (name == c.getName() && value == c.getValue())
			return true;
		else
			return false;
	}//equals method
	
}//coin class
