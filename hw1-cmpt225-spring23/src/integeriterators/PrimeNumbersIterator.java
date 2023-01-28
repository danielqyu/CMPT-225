package integeriterators;

public class PrimeNumbersIterator implements IntegerIterator {

	protected int currPrime;

	private boolean isPrime(int num) {
		if (num <= 1)
		{
			return false;
		}
		if (num <= 3)
		{
			return true;
		}
		// this is from geeksforgeeks
		if (num % 2 == 0 || num % 3 == 0)
		{
			return false;
		}
		for (int i = 5; i * i <= num; i = i + 6)
		{
			if (num % i == 0 || num % (i+2) == 0)
			{
				return false;
			}
		}
			return true;
	}

	protected int generateNextPrime(int startNum) {
		int currNum = startNum;
		while (!isPrime(currNum)) {
			currNum += 1;
		}
		return currNum;
	}
	
	public PrimeNumbersIterator() {
		this.currPrime = 2;
	}
	
	public PrimeNumbersIterator(int n) {
		this.currPrime = generateNextPrime(n);
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}
	
	@Override
	public Integer next() {
		int retVal;

		retVal = this.currPrime;
		this.currPrime = generateNextPrime(retVal + 1);
		return retVal;
	}
	
	public void reset() {
		currPrime = 2;
	}

}
