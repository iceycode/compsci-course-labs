package lab01;

/** TestCreature.java
 * - tests Things and Creatures hierarchy
 * - main method creates array of Things instances
 * 
 * @author Allen Jagoda
 * 
 * contains parameters THING_COUNT & CREATURE_COUNT
 *
 */


public class TestCreature {
	
	//instance variables
	static int THING_COUNT = 4; //array size
	static int CREATURE_COUNT = 2;
	
	/**
	 * TestCreature.main tests the hierarchy of Things and Creatures. Steps: 
		- create some Creature instances (i.e. an array of them) 
		- create some simple Thing instances 
		- add the Creature instances to the array of simple Thing instances 
		- print a heading "Things:" followed by a blank line 
		- print each thing, which each print one line about themselves 
		- print a blank line 
		- print a heading "Creatures:" followed by a blank line 
		- print each creature 
		- print a blank line 
	 * 
	 *
	 */
	public static void main(String[] args) {
		//------------------THINGS SECTION----------------------//
		//array variable created
		Thing thingArr[] = new Thing[THING_COUNT];
		Creature creatureArr[] = new Creature[CREATURE_COUNT];
				
		//adding instances of thing to thing array
		System.out.println("Things: \n");
		thingArr[0] = new Thing("blueberry");
		thingArr[1] = new Tiger("Tony");
		thingArr[2] = new Thing("zircon-encrusted tweezers");
		thingArr[3] = new Fly("Jeff Goldblum");
		
		//printing out things
		for (int i = 0; i < thingArr.length; i++){
			System.out.println(thingArr[i]);
		}
		
		//------------------CREATURES SECTION----------------------//
		
		creatureArr[0] = new Tiger("Tony");
		creatureArr[1] = new Fly("Jeff Goldblum");
		
		//printing creature list
		System.out.println("\nCreatures:\n");
		for (int i = 0; i < 2; i++){
			System.out.println(creatureArr[i]);
		}
		
		//TESTING polymorphism by testing eat/move methods of different subclasses of creature
		Fly fly = new Fly("Jeff Golblum");
		Bat bat = new Bat("Batty");
		Ant ant = new Ant(" Aunty ");
		
		System.out.println("\nTesting eat...");
		
		//testing eat for ant - WONT EAT CREATURES
		fly.eat(thingArr[0]);
		fly.eat(creatureArr[0]);
		fly.move();

		//testing eat for ant - WONT EAT THINGS
		bat.eat(thingArr[0]);
		bat.eat(creatureArr[0]);
		bat.move();
		
		System.out.println("\nTesting move...");
		//testing movements
		ant.move();
		creatureArr[0].move();
		fly.move();
		bat.move();

	}

}
