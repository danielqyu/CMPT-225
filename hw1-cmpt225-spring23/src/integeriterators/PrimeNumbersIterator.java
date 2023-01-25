package integeriterators;

public class PrimeNumbersIterator implements IntegerIterator {

	protected int currPrime;

	private boolean isPrime(int num) {
		int i;
		if (num <= 1) {
			return false;
		}

		i = 2;
		while (i*i <= num) {
			if (num % i == 0) {
				return false;
			}
			i += 1;
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
