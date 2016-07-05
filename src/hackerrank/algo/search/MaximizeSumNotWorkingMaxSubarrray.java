package hackerrank.algo.search;

import java.util.Scanner;

public class MaximizeSumNotWorkingMaxSubarrray {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTests = in.nextInt();
		
		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int length = in.nextInt();
			int hero = in.nextInt();
			int[] array = new int[length];
			
			for (int index = 0; index < length; index++) {
				array[index] = in.nextInt();
			}
			
			System.out.println(findMaximum(array,0,length-1,hero));
		}
	}

	private static int findMaximum(int[] array, int startIndex, int endIndex, int hero) {
		int length = endIndex - startIndex + 1;
		
		if(length==1){
			return array[startIndex] % hero;
		}
		
		int median = length/2;
		
		int leftResult = findMaximum(array, startIndex, endIndex-median, hero);
		int rightResult = findMaximum(array, endIndex-median+1, endIndex, hero);
		
		int leftMaxVal = 0;
		int rightMaxVal = 0;
		int sum = 0;
		for (int index = endIndex-median; index >= startIndex ; index--) {
			sum = (sum + array[index])%hero;
			if(sum>leftMaxVal){
				leftMaxVal = sum;
			}
		}
		sum = 0;
		for (int index = endIndex-median+1; index <= endIndex; index++) {
			sum = (sum + array[index])%hero;
			if(sum>rightMaxVal){
				rightMaxVal = sum;
			}
		}
		
		int overlapSum = Math.max(Math.max(leftMaxVal,rightMaxVal),(leftMaxVal+rightMaxVal)%hero);
		return Math.max(overlapSum, Math.max(leftResult, rightResult));
	}
	
}
