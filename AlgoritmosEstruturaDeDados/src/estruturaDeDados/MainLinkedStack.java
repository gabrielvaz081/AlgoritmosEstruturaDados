package estruturaDeDados;

public class MainLinkedStack {

	public static void main(String[] args) {
		Stack stack = new LinkedStack();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		for(int i = stack.getSize(); i > 0; i--) {
			System.out.print(stack.peek() + ",");
			stack.pop();
		}

	}

}
