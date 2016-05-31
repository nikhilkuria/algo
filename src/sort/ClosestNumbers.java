package sort;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int[] input = new int[length];
		for (int index = 0; index < input.length; index++) {
			input[index] = in.nextInt();
		}
		printClosestNumbers(input);
	}

	private static void printClosestNumbers(int[] input) {
		Arrays.sort(input);
		int difference = Integer.MAX_VALUE;
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < input.length-1; index++) {
			int newDiff = input[index+1] - input[index];
			if(newDiff<=difference){
				if(newDiff<difference){
					difference = newDiff;
					builder.setLength(0);
				}
				builder.append(input[index]);
				builder.append(" ");
				builder.append(input[index+1]);
				builder.append(" ");
			}
			
		}
		System.out.println(builder.toString());
	}
	
}
