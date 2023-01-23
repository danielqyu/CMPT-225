package integeriterators;

public class RangeIterator implements IntegerIterator
{
	/**
	 * Creates an iterator for the infinite sequence 0,1,2,...
	 */
	public RangeIterator() {
		// TODO implement me
	}
	
	/**
	 * Creates an iterator for the infinite sequence s,s+1,s+2...
	 */
	public RangeIterator(int s) {
		// TODO implement me
	}
	
	/**
	 * Creates an iterator for the finite sequence [s,s+1,s+2...t-1]
	 * @throws IllegalArgumentException if t<s
	 */
	public RangeIterator(int s, int t) {
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
