package integeriterators;

import java.util.NoSuchElementException;

public class ArrayIterator implements IntegerIterator
{

	protected boolean IS_CIRCULAR;
	protected int[] currArray;
	protected int currIndex;

	/**
	 * Creates an iterator for ar 
	 */
	public ArrayIterator(int[] ar) {
		IS_CIRCULAR = false;
		currArray = ar;
		currIndex = 0;
	}
	
	/**
	 * Creates an iterator for the ar
	 * If isCurcular is true, the iterator will be infinite,
	 * outputting the array in circle 
	 * ar[0],ar[1]...ar[ar.length-1],ar[0],ar[1]...ar[ar.length-1],ar[0]...
	 */
	public ArrayIterator(int[] ar, boolean isCircular) {
		IS_CIRCULAR = isCircular;
		currArray = ar;
		currIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		if (currIndex > currArray.length - 1 && !IS_CIRCULAR) {
			return false;
		}
		return true;
	}
	
	@Override
	public Integer next() throws NoSuchElementException {
		int returnIndex = currIndex;

		if (IS_CIRCULAR) {
			if (currIndex == currArray.length) {
				this.reset();
				returnIndex = currIndex;
			}
		} else {
			if (!hasNext()) {
				throw new NoSuchElementException("No next element");
			}
		}
		currIndex += 1;
		return currArray[returnIndex];
	}

	public void reset() {
		currIndex = 0;
	}
}
