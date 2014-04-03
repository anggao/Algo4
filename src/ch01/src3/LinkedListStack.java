package ch01.src3;

import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item> {
	private Node first; // top of stack (most recently added node)
	private int N; // number of items

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return null;
	}

}
