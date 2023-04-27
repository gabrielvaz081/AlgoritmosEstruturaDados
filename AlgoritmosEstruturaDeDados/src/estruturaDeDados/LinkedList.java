package estruturaDeDados;

public class LinkedList implements List{

	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@Override
	public int get(int index) {
		if(index >= 0 && index < this.size) {
			Node currentNode = this.head;
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					return currentNode.getValue();
				}
				
				currentNode = currentNode.getNext();
				
			}
		}
		
		throw new IllegalArgumentException("Index out of bound");
	}

	@Override
	public void add(int value) {
		if(this.size == 0) {
			this.head = new Node(value);
			this.tail = this.head;
		} else {
			Node node = new Node(value);
			this.tail.setNext(node);
			this.tail = node;
		}
		
		this.size++;
	}

	@Override
	public void add(int value, int index) {
		if(index >= 0 && index < this.size) {
			Node node = new Node(value);
			Node currentNode = this.head;
			if(index == 0) {
				node.setNext(currentNode);
				this.head = node;
			} else {
				for(int i = 0; i < index - 1; i++) {
					currentNode = currentNode.getNext();
				}
				
				node.setNext(currentNode.getNext());
				currentNode.setNext(node);
			}
			
			this.size++;
			
		} else {
			
			throw new IllegalArgumentException("Index out of bound");
		}
	}

	@Override
	public void remove(int index) {
		if(index >= 0 && index < this.size) {
			Node currentNode = this.head;
			if(index == 0) {
				this.head = currentNode.getNext();
			} else {
				for(int i = 0; i < index - 1; i++) {
					currentNode = currentNode.getNext();
				}
				
				currentNode.setNext(currentNode.getNext().getNext());
			}
			
			this.size--;
			
		} else {
			
			throw new IllegalArgumentException("Index out of bound");
			
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
