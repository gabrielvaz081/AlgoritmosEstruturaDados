package estruturaDeDados;

public class LinkedQueue implements Queue{

	private Node start;
	private int size;
	
	public LinkedQueue() {
		this.start = null;
		this.size = 0;
	}
	
	@Override
	public void offer(int value) {
		Node node = new Node(value);
		Node currentNode = this.start;
		if(this.size == 0) {
			this.start = node;
		} else {
			for(int i = 0; i < this.size - 1; i++) {
				currentNode = currentNode.getNext();
			}
			
			currentNode.setNext(node);
			
		}
		
		this.size++;
		
	}

	@Override
	public int peek() {
		if(this.size == 0) {
			throw new RuntimeException("Empty Queue");
		} else {
			return this.start.getValue();
		}
	}

	@Override
	public int poll() {
		Node currentNode = this.start;
		if(this.size == 0) {
			throw new RuntimeException("Empty Queue");
		} else {
			int valueStart = this.start.getValue();
			this.start = currentNode.getNext();
			this.size--;
			return valueStart;
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	public class Node{
		
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
