package hackerrank.algo.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class EqualStacks {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		EqualStacks stacks = new EqualStacks();
		int[] stackOne = new int[in.nextInt()];
		int[] stackTwo = new int[in.nextInt()];
		int[] stackThree = new int[in.nextInt()];
		
		stacks.populateArray(in, stackOne);
		stacks.populateArray(in, stackTwo);
		stacks.populateArray(in, stackThree);
		int maxiumum = findMaximum(stackOne, stackTwo, stackThree);
		System.out.println(maxiumum);
		
	}

	private static int findMaximum(int[] stackOne, int[] ... remainingStacks) {
		int currentSum = 0;
		for (int index = 0; index < stackOne.length; index++) {
			int value = stackOne[index];
			boolean isFound = true;
			for (int stackIndex = 0; stackIndex < remainingStacks.length; stackIndex++) {
				int[] stack = remainingStacks[stackIndex];
				if(Arrays.binarySearch(stack, value)<0){
					isFound = false;
				}
			}
			if(isFound){
				currentSum = value;
			}
		}
		return currentSum;
	}

	private  void populateArray(Scanner in, int[] stackOne) {
		for (int index = stackOne.length-1; index >=0; index--) {
				stackOne[index] = in.nextInt();
		}
		for (int index = 1; index < stackOne.length; index++) {
			stackOne[index] = stackOne[index] + stackOne[index-1];
		}
	}
	
	
}
