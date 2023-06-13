package estruturaDeDados;

public class HashTable{

	private HashTableEntry[] hashTable;
	private int tableSize = 10;
	private int size = 0;
	
	public HashTable() {
		this.hashTable = new HashTableEntry[this.tableSize];
	}
	public String get(String key) {
		int generatedIndex = defineIndex(key);
		
		return this.hashTable[generatedIndex] == null ? null : this.hashTable[generatedIndex].getValue();
	}

	public void add(String key, String value) {
		if(this.size / this.tableSize > 0.5) {
			rehash();
		}
		
		int generatedIndex = defineIndex(key);
		this.hashTable[generatedIndex] = new HashTableEntry(key, value);
		this.size++;
	}

	//public void remove(String key) {
	// Falta implementar!	
	//}

	public int getSize() {
		return this.size;
	}
	
	private void rehash() {
		HashTableEntry[] temporaryTable = this.hashTable;
		int newTableSize = this.tableSize * 2;
		this.hashTable = new HashTableEntry[newTableSize];
		this.tableSize = newTableSize;
		
		for(HashTableEntry entry : temporaryTable) {
			add(entry.getKey(), entry.getValue());
		}
	}
	
	private int defineIndex(String key) {
		int hashCode = key.hashCode() < 0 ? key.hashCode() * (-1) : key.hashCode();
		int index = hashCode % this.tableSize;
		
		while(this.hashTable[index] != null && !this.hashTable[index].getKey().equals(key)) {
			if(index == this.tableSize - 1) {
				index = 0;
			} else {
				index++;
			}
		}
		
		return index;
	}
	
	private class HashTableEntry{
		
		private String key;
		private String value;
		
		public HashTableEntry() {}
		
		public HashTableEntry(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}

}
