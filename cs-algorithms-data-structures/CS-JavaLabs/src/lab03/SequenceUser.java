package lab03;

/** SequenceUser class makes use of Sequence.java
 * - adds 100 elemnents to the data array in Sequence
 * - non-JUnit test of the sequence array to show that negative value cannot be entered (throws exception)
 * 
 * @author Allen
 *
 */

public class SequenceUser {

	public static void main(String[] args) {
		new SequenceUser().run();
	}

	public void run(){
		addToSequence();
	}
	
	public void addToSequence(){
		Sequence s = new Sequence(100);
		for (int i = 1; i <= 100; i++){
			s.append(i);
		} //adds 100 elements (1 thru 100) to a Sequence object'
		
		s.append(1000);
		
		displaySeq(s); //displays data array numbers
		
		Sequence sNeg = new Sequence(-1); //should display NegativeArraySizeException
	}//adds numbers to the Sequence data array
	
	public void displaySeq(Sequence s){
		for (int i = 0; i < s.size; i++)
			System.out.println(s.get(i));
	}	
	
}
