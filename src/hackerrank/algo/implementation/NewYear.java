package hackerrank.algo.implementation;

import java.util.Scanner;

public class NewYear {

	public static final String TOO_CHAOTIC = "Too chaotic";
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		for (int index = 0; index < num; index++) {
			int size = in.nextInt();
			int[] input = new int[size];
			for (int sizeIndex = 0; sizeIndex < size; sizeIndex++) {
				input[sizeIndex] = in.nextInt();
			}
			solveChaos(input);
		}
	}

	private static void solveChaos(int[] input) {
		int result = sort(input);
		if(result == -1){
			System.out.println(TOO_CHAOTIC);
			return;
		}
		System.out.println(result);
	}
	
	public static int sort(int[] input){
		int swapCount = 0;
		for (int theIndex = 0; theIndex < input.length; theIndex++) {
			if(input[input.length-theIndex-1]==input.length-theIndex){
				continue;
			}
			for (int otherIndex = 0; otherIndex < input.length-theIndex-1; otherIndex++) {
				if(otherIndex-input[otherIndex]+1<-2){
					return -1;
				}
				if(input[otherIndex]>input[otherIndex+1]){
					swapCount++;
					swap(input,otherIndex,otherIndex+1);
				}
			}
		}
		return swapCount;
	}
	
	public static void swap(int[] input, int swapIndexOne, int swapIndexTwo){
		int temp = input[swapIndexOne];
		input[swapIndexOne] = input[swapIndexTwo];
		input[swapIndexTwo] = temp;
	}

}
