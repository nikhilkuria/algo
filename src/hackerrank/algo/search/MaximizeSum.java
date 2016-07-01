package hackerrank.algo.search;

import java.util.Scanner;

public class MaximizeSum {

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
			
			int[] modulusArray = new int[length];
			
			modulusArray[0] = array[0]%hero;
			int max = modulusArray[0];
			for (int i = 1; i < array.length; i++) {
				modulusArray[i] = (modulusArray[i-1]+array[i])%hero;
				if(modulusArray[i]>max){
					max = modulusArray[i];
				}
			}
			System.out.println(max);
		}
	}
	
}
