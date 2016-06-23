package hackerrank.algo.dynamic;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciMod {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		BigInteger first = in.nextBigInteger();
		BigInteger second = in.nextBigInteger();

		int targetIndex = in.nextInt();

		BigInteger result = findNextInSequence(first,second,targetIndex,2);
		System.out.println(result);
	}

	private static BigInteger findNextInSequence(BigInteger first, BigInteger second, int targetIndex, int currentIndex) {
		if(currentIndex == targetIndex){
			return second;
		}
		return findNextInSequence(second, (second.multiply(second).add(first)), targetIndex, currentIndex+1);
	}
}
