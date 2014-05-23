package common.datastructure;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	private LinkedList<Integer> testList;

	@Before
	public void init() {
		testList = new LinkedList<Integer>();
	}

	@Test
	public void testInsertFront() {
		System.out.println("testInsertFront");
		testList.insertFront(1);
		testList.printList();
		testList.insertFront(2);
		testList.printList();
	}

	@Test
	public void testInsertBack() {
		System.out.println("testInsertBack");
		testList.insertBack(1);
		testList.printList();
		testList.insertBack(2);
		testList.printList();
		testList.insertBack(3);
		testList.printList();
	}

	@Test
	public void removeFront() {
		System.out.println("removeFront");
		testList.insertFront(3);
		testList.insertFront(2);
		testList.insertBack(1);
		testList.printList();
		testList.removeFront();
		testList.printList();
		testList.removeFront();
		testList.printList();
		testList.removeFront();
		testList.printList();
		testList.removeFront();
		testList.printList();
	}

	@Test
	public void removeBack() {
		System.out.println("removeBack");
		testList.insertFront(3);
		testList.insertFront(2);
		testList.insertBack(1);
		testList.printList();
		testList.removeBack();
		testList.printList();
		testList.removeBack();
		testList.printList();
		testList.removeBack();
		testList.printList();
		testList.removeBack();
		testList.printList();
	}
}
