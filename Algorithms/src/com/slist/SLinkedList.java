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

	/**
	 *  indicates whether the list is empty.
	 * 
	 * @return true if the list is empty, false otherwise.
	 **/
	public boolean isEmpty() {
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
	 * converts the list to a String.
	 * 
	 * @return a String representation of the list.
	 **/
	public String toString() {

		if (isEmpty())
			return "[]";

		Integer intData;
		String result = "[";

		Node cur = head.next;

		while (cur != null) {
			intData = cur.getData().getData();
			result = result + intData + " ";
			cur = cur.next;
		}
		result = result + "]";
		return result;
	}

	/**
	 * inserts item "intData" at the beginning of this list.
	 * 
	 * @param intData
	 *            the item to be inserted.
	 **/
	public void addFirst(int intData) {

		Node newNode;

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
	 * @param intData
	 *            the item to be inserted.
	 **/
	public void addLast(int intData) {

		Node newNode = new Node(intData);

		if (isEmpty())
			head.next = newNode;
		else {
			Node curr = head.next;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		size++;
	}

	/**
	 * Adds the given item at the given index in the list.
	 * 
	 * @param index
	 *            is search position
	 * @param intData
	 *            value to be added to the index position
	 * @return MIN_VALUE if unsuccessful. i.e. index positions exceeds the
	 *         length or negative
	 * @return MAX_VALUE if successful added intData at index position
	 */

	public int addAtNth(int index, int intData) {
		// TODO Auto-generated method stub
		int result = 0;
		// if(isEmpty())
		// {
		// result = Integer.MIN_VALUE;
		// }
		if (index < 0 || index > length()) {
			result = Integer.MIN_VALUE;
		} else {
			if (index == 0) // Node insertion at first position.
			{
				head.next = new Node(intData, head.next);
				result = Integer.MAX_VALUE;
				size++;
			} else {
				int count = 0;
				Node prev = new Node();
				Node curr = head.next;

				// counter to the index position
				while (count != index) {
					prev = curr;
					curr = curr.next;
					count++;
				}
				// Node Insertion other than first position.

				prev.next = new Node(intData, curr);

				// Node Insertion can also be written as follows
				// Node newNode = new Node(intData);
				// prev.next = newNode;
				// newNode.next=curr;

				result = Integer.MAX_VALUE;
				size++;

			}
		}

		return result;

	}

	/**
	 * 
	 * @param index
	 *            search position
	 * @return MAX_VALUE if index positions exceeds the length
	 * @return MIN_VALUE for empty list
	 * @return data value if found
	 */
	public int getNth(int index) {

		int found = 999999999;

		if (isEmpty()) { // Search in empty list
			found = Integer.MIN_VALUE;
		} else if (index >= length() || index < 0) { // Search index increase
														// the length of list
			found = Integer.MAX_VALUE;
		} else { // search from 1st node of the list till length of list

			Node curr = head.next;

			for (int count = 0; count < length(); count++, curr = curr.next) {
				if (count == index) {
					found = curr.getData().getData().intValue();
					break;
				}
			}
		}
		return found;
	}

	/**
	 * @param index
	 *            position to be replaced
	 * @param intData
	 *            data to be replaced
	 * @return MIN_VALUE for unsuccessful attempt i.e. empty list or index
	 *         positions exceeds the length
	 */
	public int replaceNth(int index, int intData) {
		//
		int result = 9999999;

		if (isEmpty() || index < 0 || index >= length()) {
			result = Integer.MIN_VALUE;
		} else { // replace 0th index position
			Node nodeToBeChanged;
			if (index == 0) {
				nodeToBeChanged = head.next;
				nodeToBeChanged.setData(intData);
				result = Integer.MAX_VALUE;
			} else { // replace middle list index position
				int count = 0;
				nodeToBeChanged = head.next;

				while (count != index) {
					nodeToBeChanged = nodeToBeChanged.next;
					count++;
				}
				nodeToBeChanged.setData(intData);
				result = Integer.MAX_VALUE;
			}
		}
		return result;
	}

	public boolean contains(int intData) {
		//
		boolean result = false;
		if (!isEmpty()) {
			Node nodeToBeSearched = head.next;

			while (nodeToBeSearched != null) {
				if (intData == nodeToBeSearched.getData().getData().intValue()) {
					result = true;
					break;
				}
				nodeToBeSearched = nodeToBeSearched.next;
			}
		}
		return result;
	}

	public void clear()
	// post: removes all elements from the list
	{
		head = null;
		size = 0;
	}
}
