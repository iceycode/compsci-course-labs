package misc_CS401_Programs;

public class Person {
  //two class variables
  public String name; 
  public int age;

  //constructor
  public Person(String name, int age) 
  { 
	  //this refers to the current object; when this is alone, it refers to the entire object
	  this.name = name; //assigns the value of the parameter a to the field of the same name
	  this.age = age; 
	  /*
	   * Person a = new Person ("mike bla", 20);
	  
	  //a == b; ------/this is false
	  Person d = a; //--------------this is true, they are the same 
	  a.equals(b); // <-----true if equals mehtod compares CONTENTS 
	  //contents are different then references
	   */
	  
	  Person b = new Person("mike bla", 20);
  }

  //override the equals method
  public boolean equals(Person a){
	  if (name == a.name)
	  {
		  if (age == a.age){
			 return true; 
		  }
	  }
	return false;
	  
  }
  
  public String toString()
  {
      return (name + ":" + age);
  }
}
