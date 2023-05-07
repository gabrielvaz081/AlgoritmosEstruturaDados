package estruturaDeDados;

public class BinarySearchTree implements Tree{

	private Node root;
	
	@Override
	public void add(int value) {
		this.root = add(value, this.root);
	}
	
	private Node add(int value, Node node) {
		if(node == null) {
			return new Node(value);
		} else if(value == node.getValue()) {
			return node;
		} else if(value < node.getValue()) {
			node.left = add(value, node.left);
			return node;
		} else {
			node.right = add(value, node.right);
			return node;
		}
	}

	@Override
	public boolean contains(int value) {
		return contains(value, this.root);
	}
	
	private boolean contains(int value, Node node) {
		if(node == null) {
			return false;
		} else {
			if(value == node.getValue()) {
				return true;
			} else if(value < node.getValue()) {
				return contains(value, node.left);
			} else {
				return contains(value, node.right);
			}
		}
	}

	@Override
	public void remove(int value) {
		this.root = remove(value, this.root);
		
	}
	
	private Node remove(int value, Node node) {
		if(node != null) {
			if(value == node.getValue()) {
				if(node.left == null && node.right == null) {
					return null;
				} else if(node.left == null || node.right == null) {
					return node.getLeft() == null ? node.getRight() : node.getLeft();
				} else {
					Node inOrderPredecessor = node.getLeft();
					while(inOrderPredecessor.getRight() != null) {
						inOrderPredecessor = inOrderPredecessor.getRight();
					}
					node.value = inOrderPredecessor.getValue();
					node.left = remove(inOrderPredecessor.value, node.left);
					return node;
				}
			} else if(value < node.getValue()) {
				node.left = remove(value, node.left);
				return node;
			} else {
				node.right = remove(value, node.right);
				return node;
			}
		}
		
		return null;
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(this.root);
	}
	
	private void preOrderTraversal(Node node) {
		if(node != null) {
			System.out.println(node.getValue() + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(this.root);
	}
	
	private void inOrderTraversal(Node node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.getValue() + " ");
			inOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(this.root);
	}
	
	private void postOrderTraversal(Node node) {
		if(node!= null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.getValue() + " ");
		}
	}
	
	private class Node{
		 private int value;
		 private Node right;
		 private Node left;
		 
		 public Node() {}
		 
		 public Node(int value) {
			 this.value = value;
		 }

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}
		 
	}

}
