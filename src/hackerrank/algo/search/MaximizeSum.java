package hackerrank.algo.search;

import java.util.Scanner;
import java.util.TreeSet;

public class MaximizeSum {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int numOfTests = in.nextInt();

		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int length = in.nextInt();
			long hero = in.nextLong();
			int[] array = new int[length];

			for (int index = 0; index < length; index++) {
				array[index] = in.nextInt();
			}

			System.out.println(findMaximum(array, hero));
		}
	}

	private static long findMaximum(int[] array, long hero) {
		
		long max = 0;
		long diff = hero;
		TreeSet<Long> offsetIndices = new TreeSet<Long>();
		long offsetIndex = 0;
		
		for (int index = 0; index < array.length; index++) {
			
			offsetIndex = (offsetIndex + array[index])%hero;
			
			Long prevOffset = offsetIndices.higher(offsetIndex);
			if(prevOffset!=null){
				if(prevOffset-offsetIndex<diff){
					diff = prevOffset-offsetIndex;
				}
			}

			if(offsetIndex>max){
				max = offsetIndex;
			}
			offsetIndices.add(offsetIndex);
		}
		
		
		return Math.max(max, (hero-diff));
		
	}
}
