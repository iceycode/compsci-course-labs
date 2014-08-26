package lab09;

/** BSTArrayTest.java
 * - implements BinarySearchTreeArray.java class
 * - prints out tables of elements with indexes in table form
 * - adds String and Integer values
   STRING:  dog, turtle, cat, ferret, shark, whale, porpoise
   INTEGERS: 3, 18, 4, 99, 50, 23, 5, 101, 77, 87
 * - deletes "ferret" from 1st tree & 50 from second tree
 * 
 * @author Allen Jagoda CS401 Lab 09
 *
 */

public class BSTArrayTest<Object> extends BinarySearchTreeArray<Object> {


	
	public static void main(String[] args) {
		new BSTArrayTest().run();
	}
	
	public void run(){
		//BSTArray objects
		BinarySearchTreeArray<String> stree = new BinarySearchTreeArray<String>();
		BinarySearchTreeArray<Integer> intree = new BinarySearchTreeArray<Integer>();
		
		//adding elements to string tree
		stree.add("dog");
		stree.add("turtle");
		stree.add("cat");
		stree.add("ferret");
		stree.add("shark");
		stree.add("whale");
		stree.add("porpoise");
		
		//adding elements to integer tree
		intree.add(3);
		intree.add(18);
		intree.add(4);
		intree.add(99);
		intree.add(50);
		intree.add(23);
		intree.add(5);
		intree.add(101);
		intree.add(77);
		intree.add(87);
		
		//printing out tables
		System.out.println("String elements in BST Array: ");
		printTable(stree);
		System.out.println("\nInteger elements in BST Array: ");
		printTable(intree);
		
		//removal of items & printout
		System.out.println("\n--------------------------------"
				+ "\nTables after removal of items");
		stree.remove("ferret");
		intree.remove(50);
		System.out.println("String elements in BST Array: ");
		printTable(stree);
		System.out.println("\nInteger elements in BST Array: ");
		printTable(intree);
		
	}
	
	public <E> void printTable(BinarySearchTreeArray<? extends E> atree){
		final String LABELS = "Element\t     parent\t left\t right\t";
		System.out.println(LABELS);
		
		for (int i = 0; i < atree.tree.length; i++){
			if (atree.tree[i]!=null)
				System.out.println(i + " " + atree.tree[i].element + "    \t" + atree.tree[i].parent +
						"\t" + atree.tree[i].left + 
						"\t" + atree.tree[i].right); 
		}
	}

}
