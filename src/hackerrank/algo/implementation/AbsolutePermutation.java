package hackerrank.algo.implementation;

import java.util.Scanner;

public class AbsolutePermutation {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTests = in.nextInt();
		
		for (int testIndex = 0; testIndex <= numOfTests; testIndex++) {
			int length = in.nextInt();
			int delta = in.nextInt();
			checkIfPermutationExists(length, delta);

		}
		
	}

	private static void checkIfPermutationExists(int length, int delta) {
		int[] permutation = new int[length];
		StringBuilder permutationString = new StringBuilder();
		for (int index = 0; index < permutation.length; index++) {
			permutation[index] = -1;
		}
		
		for (int index = 0; index < length; index++) {
			int possibleValue = getPossibleValue(index, delta, permutation);
			if(possibleValue == -1){
				System.out.println(-1);
				return;
			}
			permutation[possibleValue] = 1;
			permutationString.append(possibleValue + 1).append(" ");
		}
		System.out.println(permutationString);
	}

	private static int getPossibleValue(int index, int delta, int[] permutation) {
		int[] possibleValues = new int[2];
		possibleValues[0] = index - delta;
		possibleValues[1] = index + delta;
		for (int i = 0; i < possibleValues.length; i++) {
			int possibleValue = possibleValues[i];
			if(possibleValue >= 0 && possibleValue < permutation.length){
				if(permutation[possibleValue] == -1){
					return possibleValue;
				}
			}
		}
		return -1;
	} 
	
}
