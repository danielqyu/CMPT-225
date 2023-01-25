package integeriterators;

import java.util.NoSuchElementException;

public class ArrayIterator implements IntegerIterator
{

	protected boolean isCircular;
	protected int[] currArray;
	protected int currIndex;

	/**
	 * Creates an iterator for ar 
	 */
	public ArrayIterator(int[] ar) {
		this.isCircular = false;
		this.currArray = ar;
		this.currIndex = 0;
	}
	
	/**
	 * Creates an iterator for the ar
	 * If isCurcular is true, the iterator will be infinite,
	 * outputting the array in circle 
	 * ar[0],ar[1]...ar[ar.length-1],ar[0],ar[1]...ar[ar.length-1],ar[0]...
	 */
	public ArrayIterator(int[] ar, boolean isCircular) {
		this.isCircular = isCircular;
		this.currArray = ar;
		this.currIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		if (this.currIndex > this.currArray.length - 1 && !this.isCircular) {
			return false;
		}
		return true;
	}
	
	@Override
	public Integer next() throws NoSuchElementException {
		int returnIndex = this.currIndex;

		if (this.isCircular) {
			if (this.currIndex == this.currArray.length) {
				this.reset();
				returnIndex = this.currIndex;
			}
		} else {
			if (!hasNext()) {
				throw new NoSuchElementException("No next element");
			}
		}
		this.currIndex += 1;
		return this.currArray[returnIndex];
	}

	public void reset() {
		this.currIndex = 0;
	}
}
