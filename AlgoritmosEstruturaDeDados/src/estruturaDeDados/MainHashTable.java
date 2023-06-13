package estruturaDeDados;

public class MainHashTable {

	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable();
		hashTable.add("Elemento 1", "A");
		hashTable.add("Elemento 2", "B");
		hashTable.add("Elemento 3", "C");
		hashTable.add("Elemento 4", "D");
		
		System.out.println(hashTable.get("Elemento 4"));
		System.out.println(hashTable.get("Elemento 3"));
		System.out.println(hashTable.get("Elemento 2"));
		System.out.println(hashTable.get("Elemento 1"));

	}

}
