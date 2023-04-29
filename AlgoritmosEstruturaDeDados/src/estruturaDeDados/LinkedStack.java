package estruturaDeDados;

public class LinkedStack implements Stack{

	private Node top;
	private int size;
	
	public LinkedStack() {
		this.top = null;
		this.size = 0;
	}
	
	@Override
	public void push(int value) {
		Node node = new Node(value);
		Node currentNode = this.top;
		if(this.size == 0) {
			this.top = node;
		} else {
			node.setNext(currentNode);
			this.top = node;
		}
		
		this.size++;
		
	}

	@Override
	public int peek() {
		if(this.size == 0) {
			throw new RuntimeException("Empty Stack");
		} else {
			return this.top.getValue();
		}
	}

	@Override
	public int pop() {
		Node currentNode = this.top;
		if(this.size == 0) {
			throw new RuntimeException("Empty Stack");
		} else {
			int valueTop = this.top.getValue();
			this.top = currentNode.getNext();
			this.size--;
			return valueTop;
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	private class Node{
		
		private int value;
		private Node next;
		
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

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}
