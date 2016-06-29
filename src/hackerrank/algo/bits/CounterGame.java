package hackerrank.algo.bits;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTests = in.nextInt();
		
		for (int index = 0; index < numOfTests; index++) {
			findTheWinner(in.nextBigInteger());	
		}
	}

	private static void findTheWinner(BigInteger nextLong) {
		if(nextLong.equals(BigInteger.ONE)){
			System.out.println("Richard");
			return;
		}
		int counter = 0;
		while(true){
			if(isPowerOfTwo(nextLong) && !nextLong.equals(BigInteger.ONE)){
				nextLong = nextLong.shiftRight(1);
			}else{
				nextLong = nextLong.subtract(largestPowerOfTwo(nextLong));
			}
			counter++;

			if(nextLong.equals(BigInteger.ONE)){
				if(counter%2==1){
					System.out.println("Louise");
				}else{
					System.out.println("Richard");
				}
				return;
			}
			
		}
	}

	private static BigInteger largestPowerOfTwo(BigInteger nextLong) {
		nextLong = nextLong.subtract(BigInteger.ONE);
		nextLong = nextLong.shiftRight(1);
		nextLong = nextLong.or(nextLong.shiftRight(1));
		nextLong = nextLong.or(nextLong.shiftRight(2));
		nextLong = nextLong.or(nextLong.shiftRight(4));
		nextLong = nextLong.or(nextLong.shiftRight(8));
		nextLong = nextLong.or(nextLong.shiftRight(16));
		nextLong = nextLong.or(nextLong.shiftRight(32));
		
		return nextLong.add(BigInteger.ONE);
	}

	private static boolean isPowerOfTwo(BigInteger nextLong) {
		return nextLong.and(nextLong.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
	}
	
}
