package assignment2;

import basicdatastructures.queue.*;
import basicdatastructures.stack.Stack;
import basicdatastructures.stack.StackLinkedListBased;

public class MyQueueOperations {
	/**
	 * Returns the number of elements in q.
	 */
	public static <T> int size(Queue<T> q) {
		Queue<T> qCopy = MyQueueOperations.clone(q);
		int counter = 0;
		while (!qCopy.isEmpty()) {
			qCopy.dequeue();
			counter++;
		}
		return counter;
	}

	/**
	 * Returns a copy of orig. The items are copied from orig to the new queue using
	 * = operator. For the concrete type of the returned object, you may use either
	 * QueueArrayBased or QueueLinkedListBased, up to you.
	 */
	public static <T> Queue<T> clone(Queue<T> orig) {
		T item;
		Queue<T> qCopy = new QueueLinkedListBased<>();
		Queue<T> og = new QueueLinkedListBased<>();
		while (!orig.isEmpty()) {
			item = orig.dequeue();
			qCopy.enqueue(item);
			og.enqueue(item);
		}
		while (!og.isEmpty()) {
			item = og.dequeue();
			orig.enqueue(item);
		}
		return qCopy;
	}

	/**
	 * Reverses the order of the elements in q.
	 */
	public static <T> void reverse(Queue<T> q) {
		Stack<T> bufferStack = new StackLinkedListBased<T>();
		while (!q.isEmpty()) {
			bufferStack.push(q.dequeue());
		}
		while (!bufferStack.isEmpty()) {
			q.enqueue(bufferStack.pop());
		}
	}

	/**
	 * Checks if the two queues have the same items in the same order. The items in
	 * the queues are compared using == operator.
	 */
	public static <T> boolean areEqual(Queue<T> q1, Queue<T> q2) {
		// make copies
		Queue<T> buffQ1 = MyQueueOperations.clone(q1);
		Queue<T> buffQ2 = MyQueueOperations.clone(q2);

		while (!buffQ1.isEmpty() || !buffQ2.isEmpty()) {
			if (buffQ1.isEmpty() != buffQ2.isEmpty()) {
				return false;
			}
			if (buffQ1.dequeue() != buffQ2.dequeue()) {
				return false;
			}
		}



		return true;
	}
}
