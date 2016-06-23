package hackerrank.algo.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Candies {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numOfChildren = in.nextInt();
		
		int[] marks = new int[numOfChildren];
		int[] candies = new int[numOfChildren];
		
		for (int index = 0; index < numOfChildren; index++) {
			marks[index] = in.nextInt();
		}
		
		int totalcount = assignCandies(marks,candies,0,-1,0, 0);
		System.out.println(Arrays.toString(candies));
		System.out.println(totalcount);
	}

	private static int assignCandies(int[] marks, int[] candies, int index, int previousMarks, int previousCandies, int totalCount) {
		if(index<marks.length){
			int currentMarks = marks[index];
			if(currentMarks>previousMarks){
				totalCount+=previousCandies+1;
				candies[index] = previousCandies+1;
			}
			else if(currentMarks==previousMarks){
				totalCount++;
				candies[index] = 1;
			}
			
			return assignCandies(marks, candies, index+1, currentMarks, candies[index], totalCount);
		}
		return totalCount;
	}
	
}
