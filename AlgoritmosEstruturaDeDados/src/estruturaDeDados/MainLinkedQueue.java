package estruturaDeDados;

public class MainLinkedQueue {

	public static void main(String[] args) {
		Queue queue = new LinkedQueue();
		queue.offer(0);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		for(int i = queue.getSize(); i > 0; i--) {
			System.out.print(queue.peek() + ",");
			queue.poll();
		}

	}

}
