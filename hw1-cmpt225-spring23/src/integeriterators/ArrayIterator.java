package integeriterators;

public class ArrayIterator implements IntegerIterator
{

	/**
	 * Creates an iterator for ar 
	 */
	public ArrayIterator(int[] ar) {
		// TODO implement me
	}
	
	/**
	 * Creates an iterator for the ar
	 * If isCurcular is true, the iterator will be infinite,
	 * outputting the array in circle 
	 * ar[0],ar[1]...ar[ar.length-1],ar[0],ar[1]...ar[ar.length-1],ar[0]...
	 */
	public ArrayIterator(int[] ar, boolean isCircular) {
		// TODO implement me
	}
	
	@Override
	public boolean hasNext() {
		// TODO implement me
		return false;
	}
	
	@Override
	public Integer next() {
		// TODO implement me
		return -1;
	}
	
	public void reset() {
		// TODO implement me
	}
}
