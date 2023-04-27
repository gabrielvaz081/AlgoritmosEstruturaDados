package estruturaDeDados;

public class MainLinkedList {

	public static void main(String[] args) {
		List list = new LinkedList();
		list.add(9);
		list.add(0);
		list.add(4);
		list.add(6);
		for(int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + ",");
		}

	}

}
