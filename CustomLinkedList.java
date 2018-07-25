class Node {
	public int data;
	public Node next, prev;

	public Node(int data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}

public class CustomLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public CustomLinkedList() {
		this.size = 0;
	}

	/**
	 * adds element at the starting of the linked list
	 * 
	 * @param element
	 */
	public void addFirst(int value) {
		Node temp = new Node(value, head, null);
		if (head != null) {
			head.prev = temp;
		}
		if (tail == null) {
			tail = temp;
		}
		head = temp;
		System.out.println("adding: " + value);
		size++;
	}

	/**
	 * adds element at the end of the linked list
	 * 
	 * @param element
	 */

	public void addlast(int value) {
		Node temp = new Node(value, null, head);
		if (tail != null) {
			tail.next = temp;
		}
		if (head == null) {
			head = temp;
		}
		tail = temp;
		System.out.println("adding: " + value);
		size++;
	}

	/**
	 * returns the size of the linked list
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * return whether the list is empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * this method walks forward through the linked list
	 */
	public void iterateForward() {

		System.out.println("iterating forward..");
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	public static void main(String args[]) {
		CustomLinkedList customLinkedList = new CustomLinkedList();
		customLinkedList.addFirst(100);
		customLinkedList.addFirst(200);
		customLinkedList.addFirst(300);
		customLinkedList.addFirst(400);
		customLinkedList.addlast(500);
		customLinkedList.iterateForward();
	}

}
