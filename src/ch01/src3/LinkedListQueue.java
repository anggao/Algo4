package ch01.src3;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {
	private Node first; // link to least recently added node
	private Node last; // link to most recently added node
	private int N;

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

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		N--;
		return item;
	}

	private class QueueIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return first != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
		}

	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
}
