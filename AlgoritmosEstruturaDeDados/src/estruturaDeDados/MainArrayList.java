package estruturaDeDados;

public class MainArrayList {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add(3);
		list.add(0);
		list.add(5);
		list.add(9);
		list.remove(3);
		
		for(int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + ",");
		}

	}

}
