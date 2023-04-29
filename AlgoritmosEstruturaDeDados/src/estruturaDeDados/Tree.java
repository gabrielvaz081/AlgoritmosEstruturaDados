package estruturaDeDados;

public interface Tree {
	
	public void add(int value);
	
	public boolean contains(int value);
	
	public void remove(int value);
	
	public void preOrderTraversal();
	
	public void inOrderTraversal();
	
	public void postOrderTraversal();

}
