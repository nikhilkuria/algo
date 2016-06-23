package hackerrank.algo.dynamic;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class CandiesCheat {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numOfChildren = in.nextInt();
		
		int[] marks = new int[numOfChildren];
		int[] candies = new int[numOfChildren];
		
		for (int index = 0; index < numOfChildren; index++) {
			marks[index] = in.nextInt();
		}
		BigInteger totalCandies = BigInteger.valueOf(0);
		for (int index = 0; index < numOfChildren; index++) {
			if(index==0){
				totalCandies = totalCandies.add(BigInteger.valueOf(1));
				candies[index]=1;
			}else{
				if(marks[index]>marks[index-1]){
					totalCandies = totalCandies.add(BigInteger.valueOf(candies[index-1]+1));
					candies[index] = candies[index-1]+1;
				}else{
					totalCandies = totalCandies.add(BigInteger.valueOf(1));
					candies[index] = 1;
				}
			}
		}
		
		
		for (int index = candies.length-1; index >= 0; index--) {
			if((index==candies.length-1)){
				continue;
			}else{
				if((marks[index]>marks[index+1])&&(candies[index]<=candies[index+1])){
					totalCandies = totalCandies.subtract(BigInteger.valueOf(candies[index]));
					totalCandies = totalCandies.add(BigInteger.valueOf(candies[index+1]+1));
					candies[index] = candies[index+1]+1;
				}
			}
		}
		
		System.out.println(totalCandies);
	}
}
