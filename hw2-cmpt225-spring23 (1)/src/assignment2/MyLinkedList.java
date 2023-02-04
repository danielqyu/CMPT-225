package assignment2;

import java.util.NoSuchElementException;

/**
 *
 * This is a generic class representing a list of objects.
 * The operations on the list are as follows:
 * - adding and removing elements from the left and from the right.
 * - reversing the list
 * - obtaining the middle element
 * - getting the size of the list
 * 
 * **All operations must run in O(1) time.**
 */
public class MyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private Node<T> mid;
	private int length;
	private boolean reverse;
	private boolean runReverse;

	static class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	/**
	 * The constructor creates an empty list
	 */
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
		this.mid = null;
		this.length = 0;
		this.reverse = false;
		this.runReverse = false;
	}

	/**
	 * Adds the new item to the left of the list. 
	 */
	public void addLeft(T item) {
		if (item == null) 
			return;
		if (this.reverse && this.runReverse != true) {
			this.runReverse = true;
			addRight(item);
			return;
		}

		Node<T> newNode = new Node<>(item);
		this.length++;

		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			this.mid = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;

			if (this.length == 2) {
				return;
			}
			if ((this.length % 2) != 0) {
				this.mid = this.mid.prev;
			}
		}

		this.runReverse = false;
	}

	/**
	 * Adds the new item to the right of the list. 
	 */
	public void addRight(T item) {
		if (item == null)
			return;
		if (this.reverse && this.runReverse != true) {
			this.runReverse = true;
			addLeft(item);
			return;
		}

		Node<T> newNode = new Node<>(item);
		this.length++;

		if (this.tail == null) {
			this.head = newNode;
			this.tail = newNode;
			this.mid = newNode;
		} else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;

			if ((this.length % 2) == 0) {
				this.mid = this.mid.next;
			}
		}

		this.runReverse = false;
	}

	/**
	 * Removes the leftmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeLeft() throws NoSuchElementException{
		T retVal;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (this.reverse && this.runReverse != true) {
			this.runReverse = true;
			return removeRight();
		}

		retVal = this.head.data;
		if (this.head.next != null) {
			this.head = this.head.next;
			this.head.prev = null;
		} else {
			this.head = null;
		}
		this.length--;
		this.runReverse = false;
		return retVal;
	}

	/**
	 * Removes the rightmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeRight() throws NoSuchElementException{
		T retVal;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (this.reverse && this.runReverse != true) {
			this.runReverse = true;
			return removeLeft();
		}

		retVal = this.tail.data;
		this.tail = this.tail.prev;
		this.tail.next = null;
		this.length--;
		this.runReverse = false;
		return retVal;
	}


	/**
	 * Reverses the list
	 */
	public void reverse() {
		if (this.reverse) {
			this.reverse = false;
			if (this.length % 2 == 0) {
				this.mid = this.mid.next;
			}
		} else {
			this.reverse = true;
			if (this.length % 2 == 0) {
				this.mid = this.mid.prev;
			}
		}

	}

	/**
	 * Returns the item in the middle of the list.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T getMiddle() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.mid.data;
	}

	/** 
	 * Returns the size of the list.
	 */
	public int size() {
		return this.length;
	}

	/**
	 * Returns true if list is empty, and returns false otherwise.
	 */
	public boolean isEmpty() {
		if (this.length == 0) {
			return true;
		}
		return false;
	}

}
