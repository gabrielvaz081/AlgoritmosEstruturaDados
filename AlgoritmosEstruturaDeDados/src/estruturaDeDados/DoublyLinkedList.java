package estruturaDeDados;

public class DoublyLinkedList implements List {
	
	private Node head;
	private Node tail;
	private int size;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public class Node {
		private int value;
		private Node previus;
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

		public Node getPrevius() {
			return previus;
		}

		public void setPrevius(Node previus) {
			this.previus = previus;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
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
		Node node = new Node(value);
		if(this.size == 0) {
			this.head = node;
			this.tail = this.head;
		} else {
			node.setPrevius(this.tail);
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
				currentNode.setPrevius(node);
				this.head = node;
			} else if(index > this.size / 2) {
				currentNode = this.tail;
				for(int i = this.size; i > index + 1; i--) {
					currentNode = currentNode.getPrevius();
				}
				
				node.setPrevius(currentNode.getPrevius());
				currentNode.getPrevius().setNext(node);
				currentNode.setPrevius(node);
				node.setNext(currentNode);
			} else {
				for(int i = 0; i < index - 1; i++) {
					currentNode = currentNode.getNext();
				}
				
				node.setNext(currentNode.getNext());
				currentNode.getNext().setPrevius(node);
				currentNode.setNext(node);
				node.setPrevius(currentNode);
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
			} else if(index == this.size - 1) {
				currentNode = this.tail;
				
				this.tail = currentNode.getPrevius();
			} else if(index > this.size / 2){
				currentNode = this.tail;
				
				for(int i = this.size; i > index + 1; i--) {
					currentNode = currentNode.getPrevius();
				}
				
				currentNode.setPrevius(currentNode.getPrevius().getPrevius());
				currentNode.getPrevius().setNext(currentNode);
			} else {
				for(int i = 0; i < index - 1; i++) {
					currentNode = currentNode.getNext();
				}
				
				currentNode.setNext(currentNode.getNext().getNext());
				currentNode.getNext().setPrevius(currentNode);
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

}
