package hackerrank.algo.bits;

import java.util.Scanner;

public class CounterGame {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTests = in.nextInt();
		
		for (int index = 0; index < numOfTests; index++) {
			findTheWinner(in.nextLong());	
		}
	}

	private static void findTheWinner(long nextLong) {
		if(nextLong==1){
			System.out.println("Richard");
			return;
		}
		int counter = 0;
		while(true){
			if(isPowerOfTwo(nextLong) && nextLong!=1){
				nextLong = nextLong>>1;
			}else{
				nextLong = nextLong - largestPowerOfTwo(nextLong);
			}
			counter++;

			if((nextLong)==1){
				if(counter%2==1){
					System.out.println("Louise");
				}else{
					System.out.println("Richard");
				}
				return;
			}
			
		}
	}

	private static long largestPowerOfTwo(long nextLong) {
		return Long.highestOneBit(nextLong-1);
	}

	private static boolean isPowerOfTwo(long nextLong) {
		return (nextLong & (nextLong-1)) == 0;
	}
	
}
