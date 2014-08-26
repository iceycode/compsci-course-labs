package lab10;

/** BSTUser
 * - implements BinarySearchTree
 * - specifically tests to see if toTreeString method works
 *  
 * @author Allen Jagoda (lab10)
 *
 */

public class BSTUser {

	public static void main(String[] args) {
		new BSTUser().run();

	}//main method

	public void run(){
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		tree.add(55);
		tree.add(12);
		tree.add(30);
		tree.add(97);
		tree.add(4);
		
		System.out.println(tree.toTreeString());
	}
}
