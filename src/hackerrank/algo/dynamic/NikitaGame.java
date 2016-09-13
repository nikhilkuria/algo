package hackerrank.algo.dynamic;

import java.util.Scanner;

public class NikitaGame {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int testCount = in.nextInt();
		for (int testIndex = 0; testIndex < testCount; testIndex++) {
			int length = in.nextInt();
			int[] testInput = new int[length];
			for (int index = 0; index < length; index++) {
				testInput[index] = in.nextInt();
			}
			System.out.println(getSteps(testInput, 0, 0, testInput.length-1));
		}
	}

	private static int getSteps(int[] testInput, int sumSoFar, int startIndex, int endIndex) {
		if(startIndex==endIndex){
			return sumSoFar;
		}
		int sum = 0;
		for (int index = startIndex; index <= endIndex; index++) {
			sum = sum + testInput[index];
		}
		int partialSum = 0;
		for (int index = startIndex; index <= endIndex; index++) {
			int val = testInput[index];
				partialSum = partialSum + val;
				if(partialSum == (sum - partialSum)){
					return Math.max(getSteps(testInput, sumSoFar+1, startIndex, index), getSteps(testInput, sumSoFar+1, index+1, endIndex));
				}
		}
		return sumSoFar;
	}
	
}
