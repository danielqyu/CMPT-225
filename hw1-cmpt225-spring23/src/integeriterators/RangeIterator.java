package integeriterators;
import java.util.NoSuchElementException;

public class RangeIterator implements IntegerIterator
{
	protected int currNum;
	protected int lastNum;
	protected int beginNum;
	protected boolean tExist;

	protected void generateNextInt() {
		this.currNum += 1;
	}

	/**
	 * Creates an iterator for the infinite sequence 0,1,2,...
	 */
	public RangeIterator() {
		this.currNum = 0;
		this.beginNum = 0;
		this.tExist = false;
	}
	
	/**
	 * Creates an iterator for the infinite sequence s,s+1,s+2...
	 */
	public RangeIterator(int s) {
		this.currNum = s;
		this.beginNum = s;
		this.tExist = false;
	}
	
	/**
	 * Creates an iterator for the finite sequence [s,s+1,s+2...t-1]
	 * @throws IllegalArgumentException if t<s
	 */
	public RangeIterator(int s, int t) throws IllegalArgumentException {
		if (t < s) {
			throw new IllegalArgumentException("t must be less than s");
		}
		this.currNum = s;
		this.beginNum = s;
		this.tExist = true;
		this.lastNum = t - 1;
	}
	
	@Override
	public boolean hasNext() {
		if (this.tExist && this.currNum > this.lastNum) {
			return false;
		}
		return true;
	}
	
	@Override
	public Integer next() throws NoSuchElementException{
		int retVal;

		retVal = this.currNum;
		if (this.tExist && retVal > this.lastNum) {
			throw new NoSuchElementException("No next element");
		}
		generateNextInt();
		return retVal;
	}
	
	public void reset() {
		currNum = this.beginNum;
	}
}
