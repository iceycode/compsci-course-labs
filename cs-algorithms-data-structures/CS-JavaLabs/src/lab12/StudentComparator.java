package lab12;

import java.util.Comparator;

/** StudentComparator.java
 * - comparator to be used with PriorityQueue
 * ----NOTE: added compare method from here to StudentSorter.java----
 * @author Allen
 *
 * @param <Student>
 */

public class StudentComparator implements Comparator<Student>{


	public int compare(Student s1, Student s2) {
		//initialize comparison value for last name
    	int compValue = s2.getNameLast().compareTo(s1.getNameLast());
    	
        if (compValue == 0){
        	compValue = s2.getNameFirst().compareTo(s1.getNameFirst());
        	if (compValue == 0){
        		compValue = s2.getNameMiddle().compareTo(s1.getNameMiddle());
        		if (compValue == 0){
        			double dValue = s2.getId().compareTo(s1.getId());
        			if (dValue < 0)
        				return 1;
        			else 
        				return -1;
        		}//lastly even if middle names match
        		return compValue;
        	}//if first name match
        	return compValue;
        } //if last last name is same
        return compValue; //return value whether in front or behind
 	}

}