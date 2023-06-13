package estruturaDeDados;

public class ArrayList implements List{

	private int[] array;
	private int size;
	private int length;
	
	public ArrayList() {
		this.size = 0;
		this.array = new int[10];
		this.length = this.array.length;
	}
	
	@Override
	public int get(int index) {
		if(index >= 0 && index < this.size) {
			return this.array[index];
		}
		
		throw new IllegalArgumentException("Invalid index: " + index);
	}

	@Override
	public void add(int value) {
		if(this.size >= this.length) {
			duplicated();
		}
		
		this.array[this.size] = value;
		this.size++;
	}

	private void duplicated() {
		int[] oldArray = this.array;
		this.array = new int[this.length  * 2];
		for(int i = 0; i < oldArray.length; i++) {
			this.array[i] = oldArray[i];
		}
		
	}
	
	@Override
	public void add(int value, int index) {
		if(index >= 0 && index < this.size) {
			if(this.size >= this.length) {
				duplicated();
			}
			for(int i = this.size; i > index; i--) {
				this.array[i] = this.array[i - 1];
			}
			this.array[index] = value;
			this.size++;
			
		} else {
			
			throw new IllegalArgumentException("Invalid index: " + index);
		}
		
	}

	@Override
	public void remove(int index) {
		if(index >= 0 && index < this.size) {
			for(int i = index; i < this.size; i++) {
				this.array[i] = this.array[i + 1];
			}
			this.size--;
			
		} else {
			
			throw new IllegalArgumentException("Invalid index: " + index);
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
}
