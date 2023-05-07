package estruturaDeDados;

public class MainBinarySearchTree {

	public static void main(String[] args) {
		Tree bst = new BinarySearchTree();
		
		bst.add(20);
		bst.add(13);
		bst.add(9);
		bst.add(37);
		bst.add(0);
		bst.add(15);
		bst.add(29);
		
		bst.remove(37);
		
		bst.preOrderTraversal();
	}

}
