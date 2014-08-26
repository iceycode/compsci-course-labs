package miscCode;
/** EvalToken
 * - contains token which places ID on evaluation expression
 * - used ot determine where in queue char belongs
 Following ID Order:
 	
 * 
 * @author Allen
 *
 */

public class EvalToken {
	static final int VAR = 0;
	static final int R_PAR = 1;
	static final int L_PAR = 2;
	static final int MUL_DIV_MOD = 3;
	static final int ADD_SUB = 4;
	static final int GEQLEQ = 5;
	static final int AND = 6;
	static final int OR = 7;
	static final int empty = 8;
	
	protected String operator = new String();
	protected int category;
	protected int address; //calling addres related to token's symbol
	protected int startPos; //position 
}
