package common.datastructure;

public class LinkedList<Item> {
	private Node head;
	private Node tail;
	private int size;

	private class Node {
		Item item;
		Node next;
	}

	public void insertFront(Item item) {
		Node oldHead = head;
		head = new Node();
		head.next = oldHead;
		head.item = item;
		if (head.next == null) { // special case single element
			tail = head;
		}
		size++;
	}

	public void insertBack(Item item) {
		Node oldTail = tail;
		tail = new Node();
		tail.item = item;
		if (head == null) { // special case single element
			head = tail;
		} else {
			oldTail.next = tail;
		}
		size++;
	}

	public void removeFront() {
		if (head == null)
			return;
		head = head.next;
		if (head == null) // special case single element
			tail = null;
		size--;
	}

	public void removeBack() {
		if (head == null)
			return;
		if (head.next == null) {
			head = null;
			tail = null;
			return;
		}
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		tail = current;
		size--;
	}

	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.item + " ");
			current = current.next;
		}
		System.out.println();
	}
}
