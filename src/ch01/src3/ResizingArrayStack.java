package ch01.src3;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1]; // stack items
	private int N; // number of items

	public boolean isEmpay() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		// move stack to a new array of size max;
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	public void push(Item item) {
		// add item to top the stack
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() {
		// remove item from top of the stack
		Item item = a[--N];
		a[N] = null; // avoid loitering
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		// support FILO iteration
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

}
