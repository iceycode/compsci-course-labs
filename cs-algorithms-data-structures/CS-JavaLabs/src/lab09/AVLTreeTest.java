package lab09;

public class AVLTreeTest {

	public static void main(String[] args) {
		new AVLTreeTest().run();

	}
	
	public void run(){
		
		AVLTree<String> avlTree = new AVLTree<String>();
		
		//testing recursive add method
		avlTree.add ("river");
		avlTree.add ("ocean");
		avlTree.add("apple");
		avlTree.add("apple");
	}

}
