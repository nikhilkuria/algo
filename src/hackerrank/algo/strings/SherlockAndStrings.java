package hackerrank.algo.strings;

import java.util.Scanner;

public class SherlockAndStrings {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numOfTestCases = in.nextInt();
		for (int testIndex = 0; testIndex < numOfTestCases; testIndex++) {
			int numOfIntegers = in.nextInt();
			int[] input = new int[numOfIntegers];
			for (int inputIndex = 0; inputIndex < numOfIntegers; inputIndex++) {
				input[inputIndex] = in.nextInt();
			}
			if(numOfIntegers==1){
				System.out.println("YES");
			}else{
				validate(input);
			}
		}
	}

	private static void validate(int[] input) {
		int[] sumArray = new int[input.length];
		int sum = 0;
		
		for (int index = 0; index < input.length; index++) {
			sum = sum + input[index];
			sumArray[index] = sum;
		}
		
		for (int index = 1; index < sumArray.length; index++) {
			int leftSum = sumArray[index-1];
			int rightSum = sumArray[sumArray.length-1]-sumArray[index];
			if(leftSum==rightSum){
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
	
}
