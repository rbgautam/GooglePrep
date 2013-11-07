package com.slist;

public class SLinkedList {
	int size;
	Node head;

	/**
	 * SList() constructs an empty list.
	 **/
	public SLinkedList() {
		size = 0;
		head = new Node();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	/**
	 * length() returns the length of this list.
	 * 
	 * @return the length of this list.
	 **/

	public int length() {
		return size;
	}

	/**
	 * toString() converts the list to a String.
	 * 
	 * @return a String representation of the list.
	 **/
	public String toString() {

		if (isEmpty())
			return "[]";

		Integer intData;
		String result = "[  ";

		Node cur = head.next;

		while (cur != null) {
			intData = cur.getData().getData();
			result = result + intData + "  ";
			cur = cur.next;
		}
		result = result + "]";
		return result;
	}

	/**
	 * addFirst() inserts item "obj" at the beginning of this list.
	 * 
	 * @param obj
	 *            the item to be inserted.
	 **/
	public void addFirst(int intData) {

		Node newNode;
		// TODO Auto-generated method stub
		if (isEmpty()) {
			newNode = new Node(intData);
			head.next = newNode;
			size++;
		} else {
			newNode = new Node(intData);
			newNode.next = head.next;
			head.next = newNode;
			size++;
		}
	}

	/**
	 * addLast() inserts item "obj" at the end of this list.
	 * 
	 * @param obj
	 *            the item to be inserted.
	 **/
	public void addLast(int i) {
		// TODO Auto-generated method stub

	}

	/**
	 * isEmpty() indicates whether the list is empty.
	 * 
	 * @return true if the list is empty, false otherwise.
	 **/

	public void getFirst() {
		// TODO Auto-generated method stub

	}

}
