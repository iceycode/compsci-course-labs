/** Programming Exercise 4.5
 * Use the ArrayList class three times. First, create an ArrayList object, team1, with elements of type
 * String. Add three elements to team1. Second, create team2, another ArrayList object with elements of
 * type String. Add four elements to team2. Finally, create an ArrayList object, league, whose elements
 * are ArrayList objects in which each element is of type String. Add team1 and team2 to league.
 */

package chapter041;

import java.util.*;

public class ArrayLists405 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArrayLists405().teams();
	}

	public void teams()	{
		//team1 list
		ArrayList<String> team1 = new ArrayList<String>();
		team1.add(new String ("Cubs"));
		team1.add(new String("White Sox"));
		team1.add(new String("Bears"));
		
		//team2 list
		ArrayList<String> team2 = new ArrayList<String>();
		team2.add(new String("Mets"));
		team2.add(new String("Nuggets"));
		team2.add(new String("Bulls"));
		team2.add(new String("Firefoxes"));
		
		//iterators for team1 & team2
		Iterator<String> itrt1 = team1.iterator();
		Iterator<String> itrt2 = team2.iterator();
		
		//league list
		ArrayList<String> league = new ArrayList<String>();
		
		//iterators
		String teams; 
		while (itrt1.hasNext()){
			teams = itrt1.next();
			league.add(teams);
		}
		
		while (itrt2.hasNext()){
			teams = itrt2.next();
			league.add(teams);
		}
		
		//print out combined teams
		System.out.println(league);		
	}//the method which stores & adds teams
	
}
