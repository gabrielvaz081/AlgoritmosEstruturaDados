package estruturaDeDados;

public class MainDoublyLinkedList {

	public static void main(String[] args) {
		List list = new DoublyLinkedList();
		list.add(9);
		list.add(7);
		list.add(3);
		list.add(6);
		list.remove(2);;
		
		for(int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + ",");
		}

	}

}
